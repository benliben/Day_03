package com.example.benben.day03;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by LiYuanXiong on 2016/6/20 20:21.
 * Email:3187683623@qq.com
 */
public class MySqliteOpenHelper extends SQLiteOpenHelper {
    public MySqliteOpenHelper(Context context) {
        super(context, "info.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table info (" +
                "_id integer primary key autoincrement," +
                "name varchar(20)," +
                "phone varchar(11))");
        Log.i("lyx", "表被创建了: ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
