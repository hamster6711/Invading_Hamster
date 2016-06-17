package com.may.framework.implementation;

import android.graphics.Bitmap;

import com.may.framework.Graphics;
import com.may.framework.Image;

/**
 * Created by May on 2016-06-16.
 */
public class GameImage implements Image {
    Bitmap bitmap;
    Graphics.ImageFormat format;

    public GameImage(Bitmap bitmap, Graphics.ImageFormat format){
        this.bitmap = bitmap;
        this.format = format;
    }


    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public Graphics.ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}
