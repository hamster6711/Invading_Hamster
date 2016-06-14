package com.may.framework;

import com.may.framework.Audio;

/**
 * Created by May on 2016-06-14.
 */
public interface Game {
    public Audio getAudio();
    public Input getInput();
    public FileIO getFileIO();
    public Graphics getGraphics();
    public void setScreen(Screen screen);
    public Screen getCurrentScreen();
    public Screen getInitScreen();
}
