package com.may.framework.implementation.strawman;

import com.may.framework.implementation.constants.Constants;

/**
 * Created by May on 2016-06-14.
 */
public class StrawMan {
    private int width = Constants.STRAW_MAN_WIDTH;
    private int height = Constants.STRAW_MAN_HEIGHT;
    private int leftX = 0;
    private int speed = 0;
    private int leftBound = Constants.CANVAS_WIDTH - Constants.PADDING;
    private int rightBound = Constants.PADDING;

    /**
     * Update the position of the strawman using its top left coordinate
     */
    public void update() {
        if (speed < 0) {
            leftX += speed;
        } else if (speed == 0) {
        } else {
            if (leftX + width <= leftBound - speed) {
                leftX += speed;
            }
        }
        if (leftX + speed >= leftBound) {
            leftX = leftBound - width;
        } else if (leftX + speed <= rightBound) {
            leftX = rightBound;
        }
    }

    public void moveRight() {
        speed = 8;
    }

    public void moveLeft() {
        speed = -8;
    }

    public void stop() {
        speed = 0;
    }

    /**
     * Construct a singleton for strawman
     */
    private StrawMan() {
    }

    private static class StrawManHolder {
        private static final StrawMan INSTANCE = new StrawMan();
    }

    public static StrawMan getInstance() {
        return StrawManHolder.INSTANCE;
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

    public void setLeftX(int leftX) {
        this.leftX = leftX;
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
