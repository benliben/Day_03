package com.example.benben.day03.crud.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.benben.day03.InfoBean;
import com.example.benben.day03.MySqliteOpenHelper;

/**
 * Created by LiYuanXiong on 2016/6/20 20:25.
 * Email:3187683623@qq.com
 */
public class InfoDao {
    private MySqliteOpenHelper mOpen;

    public InfoDao(Context context) {
        /*创建一个帮助类对象*/
        mOpen = new MySqliteOpenHelper(context);
    }

    public void add(InfoBean bean) {
        /*调用getReadableDatabase方法，来初始化数据库的创建*/
        SQLiteDatabase db = mOpen.getReadableDatabase();
        /**
         * sql sql语句
         * bindArgs   sql语句中的占位符
         */
        db.execSQL("insert into info(name,phone) values(?,?);", new Object[]{bean.name, bean.phone});
        db.close();//关闭数据库对象
    }

    public void del(String name) {
        /*调用getReadableDatabase方法，来初始化数据库的创建*/
        SQLiteDatabase db1 = mOpen.getReadableDatabase();
        /**
         * sql sql语句
         * bindArgs   sql语句中的占位符
         */
        db1.execSQL("delete from info where name=?;", new Object[]{name});
        db1.close();//关闭数据库对象

    }

    public void update(InfoBean bean) {
        /*调用getReadableDatabase方法，来初始化数据库的创建*/
        SQLiteDatabase db2 = mOpen.getReadableDatabase();
        /**
         * sql sql语句
         * bindArgs   sql语句中的占位符
         */
        db2.execSQL("update info set phone=? where name=?;", new Object[]{bean.name, bean.phone});
        db2.close();//关闭数据库对象

    }

    public void query(String name) {
        /*调用getReadableDatabase方法，来初始化数据库的创建*/
        SQLiteDatabase db3 = mOpen.getReadableDatabase();
        /**
         * sql sql语句
         * selectionArgs   查询条件占位符的值 返回一个cursor对象
         */
        Cursor cursor = db3.rawQuery("select _id, name,phone from info where name=?;",  new String[]{name});
        /*解析cursor里面的内容*/
        if (cursor != null && cursor.getCount() > 0) {//判断cursor中是否存在数据
            /*循环遍历结果，获取每一行的内容*/
            while (cursor.moveToNext()) {//条件，游标是否定位到下一行
                int id = cursor.getInt(0);
                String name1 = cursor.getString(1);
                String phone = cursor.getString(2);

                Log.i("lyx", "id:" + id + "name:" + name1 + "phone:" + phone);

            }

            cursor.close();

        }

        db3.close();//关闭数据库对象

    }


}
