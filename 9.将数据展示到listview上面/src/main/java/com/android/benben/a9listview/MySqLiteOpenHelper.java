package com.android.benben.a9listview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by LiYuanxiong on 2016/6/22 9:14.
 * Desribe:
 */
public class MySqLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = "MySqLiteOpenHelper";

    public MySqLiteOpenHelper(Context context) {
        super(context, "inf.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table inf(" +
                "_id integer primary key autoincrement," +
                "name varchar(20)," +
                "phone varchar(11))");

        Log.i(TAG, "表被创建了");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
