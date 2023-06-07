package com.example.operationz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawThread  extends Thread{
    private SurfaceHolder surfaceHolder;
    private volatile boolean running = true; //флаг для остановки потока
    private Paint backgroundPaint = new Paint();
    private Bitmap soldier1;
    private Bitmap soldier2;
    private Bitmap soldier3;
    private Bitmap soldier4;
    private Bitmap block;
    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private Bitmap bitmap3;
    private Bitmap bitmap4;
    private Bitmap bitmap5;
    private Bitmap bitmap6;
    private Bitmap enemyBitmap;
    Hero hero = new Hero();
    Enemy enemy = new Enemy();
    Crosspiece crosspiece;
    private int towardPointX;
    private int towardPointY;
    int direction;
    int directionTest;

    int enemyDirection = 1;

    int levelNum;
    DBHelper dbHelper;

    int[][] room1;
    int[][] room2;
    int[][] currentRoom;


    int g = 1;



    {
        backgroundPaint.setColor(Color.GRAY);
        backgroundPaint.setStyle(Paint.Style.FILL);
    }
    public void setTowardPoint(int x, int y) {
        towardPointX = x;
        towardPointY = y;
    }
    public DrawThread(Context context, SurfaceHolder surfaceHolder, int levelNum, DBHelper dbHelper) {
        this.dbHelper = dbHelper;
        this.levelNum = levelNum;
        this.surfaceHolder = surfaceHolder;
        bitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier1);
        bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier2);
        bitmap3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier3);
        bitmap4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier4);
        bitmap5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.block);
        bitmap6 = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);

    }
    public void requestStop() {
        running = false;
    }


    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    int blockHeight = canvas.getHeight()/10;
                    int blockWidth = canvas.getWidth()/22;

//                    int[][] room1 = dbHelper.getRoom1();
//                    int[][] room2 = dbHelper.getRoom2();

                    Room room = new Room(blockHeight, blockWidth);



                    Paint paint = new Paint();
                    paint.setColor(Color.RED);
                    // рисование на canvas
                    room1 = new int[10][22];
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 22; j++) {
                            room1[i][j] = 0;
                        }
                    }
                    for (int i = 0; i < 10; i++) {
                            room1[i][11] = 1;
                    }
                    room1[5][5]=1;
                    room1[4][11] = 0;
                    room1[5][11] = 0;
                    room1[6][11] = 0;

                    room2 = new int[10][22];
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 22; j++) {
                            room2[i][j] = 0;
                        }
                    }

                    canvas.drawRGB(255, 255, 255);

                    if (levelNum == 1 || levelNum == 3) {
                        if(g==1)currentRoom = room1;
                        else currentRoom = room2;
                        block = Bitmap.createScaledBitmap(bitmap5, canvas.getWidth() / 22, canvas.getHeight() / 10, false);
                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 22; j++) {
                                if (currentRoom[i][j] != 0) {
                                    int[] blockCoordinates = room.getBlockCoordinates(i, j);
                                    canvas.drawBitmap(block, blockCoordinates[0], blockCoordinates[1], backgroundPaint);
                                }
                            }
                        }



                        crosspiece = new Crosspiece(canvas.getHeight(), canvas.getWidth());
                        direction = crosspiece.getDirection(towardPointX, towardPointY);
                        if (direction != 0) directionTest = direction;

                            hero.go(direction, blockHeight, blockWidth, room1);
                            soldier1 = Bitmap.createScaledBitmap(bitmap1, canvas.getWidth() / 22, canvas.getHeight() / 10, false);
                            soldier2 = Bitmap.createScaledBitmap(bitmap2, canvas.getWidth() / 22, canvas.getHeight() / 10, false);
                            soldier3 = Bitmap.createScaledBitmap(bitmap3, canvas.getWidth() / 22, canvas.getHeight() / 10, false);
                            soldier4 = Bitmap.createScaledBitmap(bitmap4, canvas.getWidth() / 22, canvas.getHeight() / 10, false);


                        enemyBitmap = Bitmap.createScaledBitmap(bitmap6, canvas.getWidth() / 22, canvas.getHeight() / 10, false);

                    enemy.go(blockHeight, blockWidth, room1, hero.x, hero.y);
                    hero.hp = enemy.heroHP;

                    if (enemy.hp!=0) {
                        canvas.drawBitmap(enemyBitmap, enemy.x, enemy.y, backgroundPaint);
                    }
                        if (hero.hp!=0) {
                            if (directionTest == 1)
                                canvas.drawBitmap(soldier1, hero.x, hero.y, backgroundPaint);
                            else if (directionTest == 2)
                                canvas.drawBitmap(soldier2, hero.x, hero.y, backgroundPaint);
                            else if (directionTest == 3)
                                canvas.drawBitmap(soldier3, hero.x, hero.y, backgroundPaint);
                            else if (directionTest == 4)
                                canvas.drawBitmap(soldier4, hero.x, hero.y, backgroundPaint);
                            else canvas.drawBitmap(soldier2, hero.x, hero.y, backgroundPaint);

                        }
                    }

                    else {
                        block = Bitmap.createScaledBitmap(bitmap5, canvas.getWidth() / 22, canvas.getHeight() / 10, false);
                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 22; j++) {
                                if(room1[i][j] != 0){
                                    int[] blockCoordinates = room.getBlockCoordinates(i, j);
                                    canvas.drawBitmap(block, blockCoordinates[0], blockCoordinates[1], backgroundPaint);
                                }
                            }
                        }


                        int blockTowardPointX = towardPointX/blockWidth+1;
                        int blockTowardPointY = towardPointY/blockHeight+1;
                        if (room1[blockTowardPointY][blockTowardPointX] == 0) room1[blockTowardPointY][blockTowardPointX] = 1;
//                        dbHelper.Delete();
//                        dbHelper.Add(room1, room2);
                    }

                    // рисование на canvas
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }





            }
        }
    }
}
