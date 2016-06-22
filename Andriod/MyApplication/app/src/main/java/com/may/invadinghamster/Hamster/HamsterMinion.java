package com.may.invadinghamster.Hamster;

import com.may.invadinghamster.Constants.Constants;

/**
 * Created by May on 2016-06-22.
 */
public class HamsterMinion extends Hamster{

    public HamsterMinion(int leftX, int leftY) {
        super(leftX, leftY);
        this.setSpeed(Constants.HAMSTER_MINION_SPEED);
        this.setWidth(Constants.HAMSTER_MINION_WIDTH);
        this.setHeight(Constants.HAMSTER_MINION_HEIGHT);
    }

    @Override
    public void flee() {
        this.setSpeed(Constants.HAMSTER_MINION_FLEE_SPEED);
    }
}
