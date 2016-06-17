package com.may.framework.implementation;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.may.framework.Audio;
import com.may.framework.FileIO;
import com.may.framework.Game;
import com.may.framework.Graphics;
import com.may.framework.Input;
import com.may.framework.Screen;
import com.may.framework.implementation.constants.Constants;

public class MainActivity extends AppCompatActivity implements Game{
    GameFastRenderView renderView;
    Graphics graphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Screen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean isPortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        int frameBufferWidth = isPortrait? Constants.CANVAS_WIDTH : Constants.CANVAS_HEIGHT;
        int frameBufferHeight = isPortrait? Constants.CANVAS_HEIGHT : Constants.CANVAS_WIDTH;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight, Bitmap.Config.RGB_565);

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        float scaleX = (float) frameBufferWidth / size.x;
        float scaleY = (float) frameBufferHeight / size.y;

        renderView = new GameFastRenderView(this, frameBuffer);
        graphics = new GameGraphics(getAssets(), frameBuffer);
        fileIO = new GameFileIO(this);
        audio = new GameAudio(this);
        input = new GameInput(this, renderView, scaleX, scaleY);
        screen = getInitScreen();
        setContentView(renderView);
    }

    @Override
    public void onResume() {
        super.onResume();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        screen.resume();
        renderView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        renderView.pause;
        screen.pause();

        if(isFinishing()){
            screen.dispose();
        }
    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public void setScreen(Screen screen) {
        if(screen == null){
            throw  new IllegalArgumentException("Screen must not be null");
        }
        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.update(0);
        this.screen = screen;
    }

    @Override
    public Screen getCurrentScreen() {
        return screen;
    }

    @Override
    public Screen getInitScreen() {
        return null;
    }
}
