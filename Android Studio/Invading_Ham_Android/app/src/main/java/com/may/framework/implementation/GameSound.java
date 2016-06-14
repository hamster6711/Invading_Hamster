package com.may.framework.implementation;

import android.media.SoundPool;

import com.may.framework.Sound;

/**
 * Created by May on 2016-06-15.
 *
 * Uses the soundPool and interger ID to keep track of various sounds,
 * play them and dispose them from memory.
 */
public class GameSound implements Sound {
    int soundId;
    SoundPool soundPool;

    public GameSound(SoundPool soundPool, int soundId) {
        this.soundPool = soundPool;
        this.soundId = soundId;
    }

    @Override
    public void play(float volume) {
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }

    @Override
    public void dispose() {
        soundPool.unload(soundId);
    }
}
