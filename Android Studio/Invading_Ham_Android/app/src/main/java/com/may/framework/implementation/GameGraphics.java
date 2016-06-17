package com.may.framework.implementation;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.may.framework.Graphics;
import com.may.framework.Image;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by May on 2016-06-14.
 */
public class GameGraphics implements Graphics {
    AssetManager assets;
    Bitmap frameBuffer;
    Canvas canvas;
    Paint paint;
    Rect srcRect = new Rect();
    Rect dstRect = new Rect();

    public GameGraphics(AssetManager assets, Bitmap frameBuffer){
        this.assets = assets;
        this.frameBuffer = frameBuffer;
        this.canvas = new Canvas(frameBuffer);
        this.paint = new Paint();
    }

    @Override
    public Image newImage(String fileName, ImageFormat format) {
        Bitmap.Config config = null;
        if(format == ImageFormat.RGB565){
            config = Bitmap.Config.RGB_565;
        } else if(format == ImageFormat.ARGB4444){
            config = Bitmap.Config.ARGB_4444;
        } else{
            config = Bitmap.Config.ARGB_8888;
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = config;

        InputStream in = null;
        Bitmap bitmap = null;

        try {
            in = assets.open(fileName);
            bitmap = BitmapFactory.decodeStream(in, null, options);
            if(bitmap == null){
                throw new RuntimeException("Could not load bitmap from asset '" + fileName + "'");
            }
         }catch (IOException e){
            throw new RuntimeException("Could not load bitmap from asset '" + fileName + "'");
        }
        finally{
            if(in != null){
                try {in.close();}
                catch (IOException e){}
            }
        }

        //TODO--check reduncancy for this part of the code
        if (bitmap.getConfig() == Bitmap.Config.RGB_565)
            format = ImageFormat.RGB565;
        else if (bitmap.getConfig() == Bitmap.Config.ARGB_4444)
            format = ImageFormat.ARGB4444;
        else
            format = ImageFormat.ARGB8888;

        return  new GameImage(bitmap, format);
    }

    @Override
    public void clearScreen(int color) {
        canvas.drawRGB((color & 0xff0000) >> 16, color & 0xff00 >> 8, (color & 0xff));
    }

    @Override
    public void drawLine(int x, int y, int x2, int y2, int color) {
        paint.setColor(color);
        canvas.drawLine(x, y, x2, y2, paint);
    }

    @Override
    public void drawRect(int x, int y, int width, int height, int color) {
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x, y, x + width - 1, y + height - 1, paint);
    }

    @Override
    public void drawString(String text, int x, int y, Paint paint) {
        canvas.drawText(text, x, y, paint);
    }

    @Override
    public void drawImage(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight) {
        srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth;
        srcRect.bottom = srcY + srcHeight;

        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + srcWidth;
        dstRect.bottom = y + srcHeight;

        canvas.drawBitmap(((GameImage) image).bitmap, srcRect, dstRect, null);
    }

    @Override
    public void drawImage(Image image, int x, int y) {
        canvas.drawBitmap(((GameImage) image).bitmap, x, y, null);
    }

    public void drawScaledImage(Image image, int x, int y, int width, int height, int srcX,
                                int srcY, int srcWidth, int srcHeight){
        srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth;
        srcRect.bottom = srcY + srcHeight;

        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + width;
        dstRect.bottom = y + height;

        canvas.drawBitmap(((GameImage) image).bitmap, srcRect, dstRect, null);

    }

    @Override
    public int getWidth() {
        return frameBuffer.getWidth();
    }

    @Override
    public int getHeight() {
        return frameBuffer.getHeight();
    }

    @Override
    public void drawARGB(int a, int r, int g, int b) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawARGB(a, r, g, b);
    }
}
