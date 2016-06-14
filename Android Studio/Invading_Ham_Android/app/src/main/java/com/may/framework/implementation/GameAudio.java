package com.may.framework.implementation;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import com.may.framework.Audio;
import com.may.framework.Music;
import com.may.framework.Sound;

import java.io.IOException;

/**
 * Created by May on 2016-06-14.
 * Sound can be stored in memory to reduce load from CPU, since it is short
 * and will be played repeatedly in the game;
 * Music will be stored in and played from the file system, as it is lengthy and will
 * take up a lot more memory .
 */
public class GameAudio implements Audio {
    AssetManager assets;
    SoundPool soundPool;

    public GameAudio(Activity activity){
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        initializeSoundPool();
    }

    public void initializeSoundPool(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(20)
                    .setAudioAttributes(attributes)
                    .build();
        } else{
            soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
        }
    }

    @Override
    public Music createMusic(String file) {
        try{
            AssetFileDescriptor assetDescriptor = assets.openFd(file);
            return new GameMusic(assetDescriptor);
        }catch (IOException e) {
            throw new RuntimeException("Could not load music '" + file + "'");
        }
    }

    @Override
    public Sound createSound(String file) {
        try{
            AssetFileDescriptor assetDescriptor = assets.openFd(file);
            int soundID = soundPool.load(assetDescriptor, 0);
            return new GameSound(soundPool, soundID);
        }catch (IOException e){
            throw new RuntimeException("Could not load sound '" + file + "'");
        }
    }
}
