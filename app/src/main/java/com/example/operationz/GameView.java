package com.example.operationz;


import static android.view.MotionEvent.ACTION_DOWN;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private DrawThread drawThread;

    int levelNum;
    DBHelper dbHelper;

    public GameView(Context context, int levelNum, DBHelper dbHelper) {
        super(context);
        getHolder().addCallback(this);
        this.levelNum = levelNum;
        this.dbHelper = dbHelper;
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        drawThread.setTowardPoint((int)event.getX(),(int)event.getY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                drawThread.setTowardPoint((int)event.getX(),(int)event.getY());
                return true;
            case MotionEvent.ACTION_MOVE: // движение
                return true;

            case MotionEvent.ACTION_UP: // отпускание
                drawThread.setTowardPoint(0,0);
                return true;

            case MotionEvent.ACTION_CANCEL:

                break;
        }
        return false;
    }

//https://startandroid.ru/ru/uroki/vse-uroki-spiskom/168-urok-103-multitouch-obrabotka-mnozhestvennyh-kasanij.html
//и предыдущий урок


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // создание SurfaceView
        drawThread = new DrawThread(getContext(),getHolder(), levelNum, dbHelper);
        drawThread.start();
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // изменение размеров SurfaceView
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // уничтожение SurfaceView
        drawThread.requestStop();
        boolean retry = true;
        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }


//    public GameView(Context context) {
//        super(context);
//    }
//    private int viewWidth;
//    private int viewHeight;
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        viewWidth = w;
//        viewHeight = h;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawARGB(250, 0, 0, 0);
//        Paint p = new Paint();
//
//    }
}
