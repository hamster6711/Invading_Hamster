package com.may.framework;

/**
 * Created by May on 2016-06-14.
 */
public interface Image {
    public int getWidth();
    public int getHeight();
    public Graphics.ImageFormat getFormat();
    public void dispose();
}
