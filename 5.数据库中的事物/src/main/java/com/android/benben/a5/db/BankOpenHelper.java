package com.android.benben.a5.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LiYuanxiong on 2016/6/21 11:06.
 * Desribe:
 */
public class BankOpenHelper extends SQLiteOpenHelper {
    public BankOpenHelper(Context context) {
        super(context, "bank.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table account(_id integer primary key autoincrement," +
                "name varchar(20)," +
                "money varchar(20)");
        db.execSQL("insert info account('name','money') values('李远雄','2000')");
        db.execSQL("insert info account('name','money') values('蒋敏','222000')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
