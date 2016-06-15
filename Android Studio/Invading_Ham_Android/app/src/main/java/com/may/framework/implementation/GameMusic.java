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
        if(this.mediaPlayer.isPlaying() == true){
            this.mediaPlayer.stop();

            synchronized (this){
                isPrepared = false;
            }
        }
    }

    @Override
    public void pause() {
        if(this.mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }

    }

    @Override
    public void setLooping(boolean isLooping) {
        mediaPlayer.setLooping(isLooping);

    }

    @Override
    public void setVolume(float volume) {
        this.mediaPlayer.setVolume(volume, volume);
    }

    @Override
    public boolean isPlaying() {
        return this.mediaPlayer.isPlaying();
    }

    @Override
    public boolean isStopped() {
        return !isPrepared;
    }

    @Override
    public boolean isLooping() {
        return this.mediaPlayer.isLooping();
    }

    @Override
    public void dispose() {
        if(this.mediaPlayer.isPlaying()){
            this.mediaPlayer.stop();
        }
        this.mediaPlayer.release();
    }

    @Override
    public void seekBegin() {
        mediaPlayer.seekTo(0);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        synchronized (this){
            isPrepared = false;
        }
    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {
        //TODO: Auto-generated method
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        synchronized (this){
            isPrepared = true;
        }
    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        //TODO: Auto-generated method
    }
}
