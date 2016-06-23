package com.may.invadinghamster.strawman;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.may.invadinghamster.Constants.Constants;
import com.may.invadinghamster.GameView;
import com.may.invadinghamster.R;

/**
 * Created by May on 2016-06-22.
 */
public class StrawMan {
    private int width = Constants.STRAW_MAN_WIDTH;
    private int height = Constants.STRAW_MAN_HEIGHT;
    private Bitmap bitmap;
    private int leftX = 0;
    private int speed = 0;
    private int leftBound = Constants.CANVAS_WIDTH - Constants.PADDING;
    private int rightBound = Constants.PADDING;

    /**
     * Update the position of the strawman using its top left coordinate
     */
    public void update(long fps) {
        if (speed < 0) {
            leftX += speed / fps;
        } else if (speed == 0) {
        } else {
            if (leftX + width <= leftBound - speed) {
                leftX += speed / fps;
            }
        }
        if (leftX + speed >= leftBound) {
            leftX = leftBound - width;
        } else if (leftX + speed <= rightBound) {
            leftX = rightBound;
        }
    }

    public void moveRight() {
        speed = Constants.STRAW_MOVE_SPEED;
    }

    public void moveLeft() {
        speed = -Constants.STRAW_MOVE_SPEED;
    }

    public void stop() {
        speed = 0;
    }

    /**
     * Construct a singleton for strawman
     */
    public StrawMan() {}

    private static class StrawManHolder {
        private static final StrawMan INSTANCE = new StrawMan();
    }

    public static StrawMan getInstance() {
        return StrawManHolder.INSTANCE;
    }

    public void setBitmap(Context context){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.strawman);
        // TODO: might not be needed
        // bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
    }

    public Bitmap getBitmap(){
        return bitmap;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getRightX() {
        return this.leftX + width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.getWeight();
    }

    // for testing purposes
    @Override
    public String toString() {
        String left = new Double(leftX).toString();
        String right = new Double(leftX + Constants.STRAW_MAN_WIDTH).toString();
        return (left + " " + right + "\n");
    }

}
