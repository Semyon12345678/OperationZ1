package com.example.operationz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "levelsBD";
    public static final String TABLE_LEVELS = "levels";

    public static final String KEY_ID = "id";
    public static final String KEY_ROOM1 = "room1";
    public static final String KEY_ROOM2 = "room2";




    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table" + TABLE_LEVELS + " (" + KEY_ID + "integer primary key," + KEY_ROOM1 + "integer," + KEY_ROOM2 + "integer," + KEY_ROOM3 + "integer" + ")");
        String query = "CREATE TABLE " + TABLE_LEVELS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_ROOM1 + " INTEGER, " +
                KEY_ROOM2 + " INTEGER); ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LEVELS);
        onCreate(db);
    }
    public void Delete (){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LEVELS, null, null);
        db.close();
    }

    public void Add(int[][] room1, int[][] room2){
        int room1Int = 1;
        int room2Int = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 22; j++) {
                if (room1[i][j] == 0){
                    room1Int = room1Int*10;
                }
                else{
                    room1Int = room1Int*10+1;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 22; j++) {
                if (room2[i][j] == 0){
                    room2Int = room1Int*10;
                }
                else{
                    room2Int = room1Int*10+1;
                }
            }
        }


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_ROOM1, room1Int);
        cv.put(KEY_ROOM2, room2Int);
        db.insert(TABLE_LEVELS, null, cv);
        db.close();
    }

    public int[][] getRoom1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_LEVELS, null, null, null, null, null, null); //TABLE_LEVELS, KEY_ROOM1, null, null,
        cursor.moveToFirst();
        int roomInt = cursor.getInt(1);
        db.close();
        int[][] room1 = new int[10][22];
        for (int i = 9; i >=0; i--) {
            for (int j = 21; j >=0; j--) {
                room1[i][j] = roomInt%10;
                roomInt = roomInt/10;
            }
        }
        room1[0][0] = 0;
        return room1;
    }

    public int[][] getRoom2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_LEVELS, null, null, null, null, null, null); //TABLE_LEVELS, KEY_ROOM1, null, null,
        cursor.moveToFirst();
        int roomInt = cursor.getInt(2);
        db.close();
        int[][] room2 = new int[10][22];
        for (int i = 9; i >=0; i--) {
            for (int j = 21; j >=0; j--) {
                room2[i][j] = roomInt%10;
                roomInt = roomInt/10;
            }
        }
        room2[0][0] = 0;
        return room2;
    }
}
