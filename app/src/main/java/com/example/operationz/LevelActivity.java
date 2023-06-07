package com.example.operationz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_level);
        Intent intent = getIntent();
        String levelNum = intent.getStringExtra("room");
        int levelNumber = Integer.parseInt(levelNum);

        dbHelper = new DBHelper(this);
//

//        Room[] rooms = new Room[2];
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 22; j++) {
//                rooms[0].blocks[i][j] = 0;
//                rooms[1].blocks[i][j] = 0;
//            }
//        }
//        Level level = new Level(rooms);
//        dbHelper.Add(level);

//
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(new GameView(this, levelNumber, dbHelper));

        if(levelNumber == 3){
            int[][] room1 = new int[10][22];
            int[][] room2 = new int[10][22];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 22; j++) {
                    room1[i][j] = 0;
                    room2[i][j] = 0;
                }
            }
            for (int i = 0; i < 22; i++) {
                room1[1][i] = 1;
            }
            dbHelper.Delete();
            dbHelper.Add(room1, room2);
        }






    }
}