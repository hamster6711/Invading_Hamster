package com.may.framework.implementation;

import android.view.View;

import com.may.framework.Input;

import java.util.List;

/**
 * Created by May on 2016-06-16.
 */
public interface TouchHandler extends View.OnTouchListener{
    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<Input.TouchEvent> getTouchEvents();
}
