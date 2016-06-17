package com.may.framework.implementation;

import android.content.Context;
import android.os.Build;
import android.view.View;

import com.may.framework.Input;

import java.util.List;

/**
 * Created by May on 2016-06-16.
 */
public class GameInput implements Input {
    TouchHandler touchHandler;

    public GameInput(Context context, View view, float scaleX, float scaleY) {
        if(Build.VERSION.SDK_INT < 5){
            touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
        } else{
            touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
        }
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
}
