package com.may.framework.implementation;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import com.may.framework.Music;

import java.io.IOException;

/**
 * Created by May on 2016-06-15.
 */
public class GameMusic implements Music, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    MediaPlayer mediaPlayer;
    boolean isPrepared = false;

    public GameMusic(AssetFileDescriptor assetDescriptor) {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(assetDescriptor.getFileDescriptor(),
                    assetDescriptor.getStartOffset(), assetDescriptor.getLength());
            mediaPlayer.prepare();
            isPrepared = true;
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnSeekCompleteListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnVideoSizeChangedListener(this);
        } catch (Exception e){
            throw new RuntimeException("Could not load music");
        }
    }

    @Override
    public void play() {
        if(this.mediaPlayer.isPlaying()){
            return;
        }
        try {
            synchronized (this){
                if(!isPrepared){
                    mediaPlayer.prepare();
                }
                mediaPlayer.start();
            }
        } catch (IllegalStateException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void setLooping(boolean looping) {

    }

    @Override
    public void setVolume(float volume) {

    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }

    @Override
    public boolean isLooping() {
        return false;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void seekBegin() {

    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

    }
}
