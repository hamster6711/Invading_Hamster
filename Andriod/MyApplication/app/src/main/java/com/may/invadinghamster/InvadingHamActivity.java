package com.may.invadinghamster;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

// the entry point to the game, handles the lifecycle of the game by calling methods of
// InvadingHamView when prompted to
public class InvadingHamActivity extends AppCompatActivity {
    // the view of the game, hold the logic of the game and respond to screen touches
    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        // Get a Display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();
        // Load the resolution into a Point object
        Point size  = new Point();
        display.getSize(size);

        // Initialize gameView and set it as the view
        gameView = new GameView(this, size.x, size.y);
        setContentView(gameView);
    }

    @Override
    protected void onResume(){
        super.onResume();
        gameView.resume();
    }

    protected void onPause(){
        super.onPause();
        gameView.pause();
    }
}
