package com.may.invadinghamster;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

import com.may.invadinghamster.Constants.Constants;
import com.may.invadinghamster.Hamster.Hamster;
import com.may.invadinghamster.Poop.Poop;
import com.may.invadinghamster.strawman.StrawMan;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by May on 2016-06-22.
 */
public class GameView extends SurfaceView implements Runnable {
    Context context;

    // use thread to override the run method
    private Thread gameThread =  null;
    // need a SurfaceHolder when use paint and canvas in a thread
    private SurfaceHolder holder;
    // boolean to set/unset when the game is playing or not
    private volatile boolean playing;
    // Game is paused at start
    private boolean paused = true;
    // canvas and paint object
    private Canvas canvas;
    private Paint paint;
    // tracks the game frame rate
    private long fps;
    // help to calculate fps
    private long timeThisFrame;
    // the size of the screen in pixels
    private int screenX, screenY;
    // strawman
    private StrawMan strawMan;
    // ArrayList of Hamster objects
    private ArrayList<Hamster> hamsList = Hamster.aliveHamsters();
    private ArrayList<Hamster> hitList = new ArrayList<Hamster>();
    // poop object
    private Poop poop = Constants.DEFAULT_POOP;
    // TODO: sound FX
    private SoundPool soundPool;
    private int tempID = -1;

    // TODO: scroes and coins

    // lives
    private int gameCount = 3;

    public GameView(Context context, int x, int y){
        super(context);
        // make a globally available copy of the context so we can use it in another method
        this.context = context;

        // initialize holder and paint objects
        holder = getHolder();
        paint = new Paint();

        screenX = x;
        screenY = y;

        initializeSoundPool();
        try {
            AssetManager assetManager = context.getAssets();
            AssetFileDescriptor descriptor;

            // Load fx in memory ready for use
            descriptor = assetManager.openFd("file name goes here"); //TODO
            tempID = soundPool.load(descriptor, 0); //TODO: create tempID
        } catch (IOException e){
            Log.e("Error:", "failed to load sound files");
        }

        prepareLevel();
    }

    private void initializeSoundPool(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .setAudioAttributes(attributes)
                    .build();
        } else{
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        }
    }

    //TODO: finish the method
    private void prepareLevel(){
        strawMan = StrawMan.getInstance();
        strawMan.setBitmap(context);
        strawMan.update(fps);
        canvas.drawBitmap(strawMan.getBitmap(), strawMan.getLeftX(), strawMan.getHeight(), paint);
    }


    @Override
    public void run() {
        while (playing){
            // capture the current time in milliseconds in startFrameTime
            long startFrameTime = System.currentTimeMillis();

            // update the frame
            if(! paused) {
                update();
            }

            // draw the frame
            draw();

            // calculate the fps of this frame, use the result to time animations and more
            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if(timeThisFrame > 0){
                fps = 1000 / timeThisFrame;
            }
        }
    }

    /**
     * Everything that needs to be updated goes in here.
     */
    public void update(){
    }

    /**
     * Draw the newly updated scene
     */
    public void draw(){
        // make sure the drawing surface is valid, or the game will crash
        if(holder.getSurface().isValid()){
            // lock the canvas ready to draw
            canvas = holder.lockCanvas();
            // TODO: to be fixed -- draw the background
            canvas.drawColor(Color.argb(255, 26, 128, 182));
            // TODO: draw hamster, poop, strawman and lives

            // TODO: could be removed
            paint.setColor(Color.argb(255,  249, 129, 0));
            paint.setTextSize(40);
            canvas.drawText("Lives: " + gameCount, 10, 50, paint);

            // draw everything to the screen
            holder.unlockCanvasAndPost(canvas);
        }
    }

    /**
     * If the Invading Hamster Activity is paused/stopped, shutdown our thread.
     */
    public void pause(){
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e){
            Log.e("Error:", "joining thread");
        }
    }

    /**
     *  If the Invading Hamster Activity is started, then start the thread.
     */
    public void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                // TODO
                break;
            case MotionEvent.ACTION_UP:
                // TODO
                break;
        }
        return true;
    }

}

