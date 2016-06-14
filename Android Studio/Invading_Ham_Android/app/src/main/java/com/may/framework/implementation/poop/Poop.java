package com.may.framework.implementation.poop;

import com.may.framework.implementation.constants.Constants;
import com.may.framework.implementation.strawman.StrawMan;

/**
 * Created by May on 2016-06-14.
 */
public class Poop {
    private int x, y;
    private int speed = 0;
    private int width = Constants.POOP_WIDTH;
    private int height = Constants.POOP_HEIGHT;

    public void update(){
        if (y + speed >= Constants.CANVAS_HEIGHT - height) {
            speed = 0;
            y = Constants.CANVAS_HEIGHT;
        } else {
            y += speed;
        }
    }

    /**
     *
     * @return true iff the poop hits the strawman
     */
    public boolean isHit(){
        int leftY = y + height;
        int leftX = x;
        int rightX = leftX + width;

        int inBound = (int) Math.round(width * Constants.AVOID_WIDTH_RATIO);
        int leftBound = StrawMan.getInstance().getLeftX() - inBound;
        int rightBound = StrawMan.getInstance().getRightX() + inBound;
        int upperBound = (int) Math.round(Constants.STRAW_MAN_HEIGHT -
                Constants.STRAW_MAN_SCALED_HEIGHT * Constants.AVOID_TOP_RATIO);
        int lowerBound = (int) Math.round(Constants.STRAW_MAN_HEIGHT +
                Constants.STRAW_MAN_SCALED_HEIGHT * Constants.AVOID_BOTTOM_RATIO);

        // the hamster falls in the calculated attack range of the straw man
        if (leftY >= upperBound && leftY <= lowerBound){
            if (leftX >= leftBound && leftX <= rightBound) {
                return true;
            }
            else if (rightX >= leftBound && rightX <= rightBound) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param x
     *      x coordinate of poop
     * @param y
     *      y coordinate of poop
     * Construct a new poop
     */
    public Poop(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
}
