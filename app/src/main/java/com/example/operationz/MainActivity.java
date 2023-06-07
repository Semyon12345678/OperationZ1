package com.example.operationz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.operationz.R;

public class MainActivity extends AppCompatActivity {

    Button btnLevel1, btnLevel2;
    Button btnLevel1Ed, btnLevel2Ed;
    Button btnClean;
    DBHelper dbHelper;
//
//    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        setContentView(new GameView(this));

//        getSupportActionBar().hide();
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);


//        dbHelper = new DBHelper(this);

//        int[][] room1 = new int[10][22];
//        int[][] room2 = new int[10][22];
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 22; j++) {
//                room1[i][j] = 0;
//                room2[i][j] = 0;
//            }
//        }
//
//        dbHelper.Add(room1, room2);

//


//        dbHelper = new DBHelper(this);
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();

        btnLevel1 = findViewById(R.id.btnLevel1);
        btnLevel2 = findViewById(R.id.btnLevel2);
        btnLevel1Ed = findViewById(R.id.btnLevel1Ed);
        btnLevel2Ed = findViewById(R.id.btnLevel2Ed);
        btnClean = findViewById(R.id.btnClean);





        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String levelNum = "1";
                Intent intent = new Intent(MainActivity.this, LevelActivity.class);
                intent.putExtra("room", levelNum);
                startActivity(intent);
            }
        });

        btnLevel1Ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String levelNum = "2";
                Intent intent = new Intent(MainActivity.this, LevelActivity.class);
                intent.putExtra("room", levelNum);
                startActivity(intent);
            }
        });


        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String levelNum = "3";
                Intent intent = new Intent(MainActivity.this, LevelActivity.class);
                intent.putExtra("room", levelNum);
                startActivity(intent);
            }
        });



        btnLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLevel2Ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}