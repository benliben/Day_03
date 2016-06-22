package com.android.benben.a9listview.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.benben.a9listview.MySqLiteOpenHelper;
import com.android.benben.a9listview.bean.InfoBean;

import java.util.ArrayList;

/**
 * Created by LiYuanxiong on 2016/6/22 9:18.
 * Desribe:
 */
public class InfoDao {
    private static final String TAG = "InfoDao";
    private MySqLiteOpenHelper mOpen;

    public InfoDao(Context context) {
        /*创建一个帮助类对象*/
        mOpen = new MySqLiteOpenHelper(context);
    }

    public boolean add(InfoBean bean) {
        /*调用getReadableDatabase方法，来初始化数据库的创建*/
        SQLiteDatabase db = mOpen.getReadableDatabase();
        ContentValues values = new ContentValues();//用map封装的对象，用来存放值
        values.put("name", bean.name);
        values.put("phone", bean.phone);

        /**
         * table:表名
         * nullColumnHack：可以为空，表示添加一个空行
         * values：添加数据一行的值
         * 返回值表示添加这一行的id 如果是-1表示添加失败
         */
        long insert = db.insert("inf", null, values);
        db.close();//关闭数据库对象
        return insert != -1;
    }

    public int del(String name) {
        SQLiteDatabase db = mOpen.getReadableDatabase();

        /**
         * table :表名
         * whereClause ：删除条件
         * whereArgs :条件的站位符参数
         * 返回值为成功删除多少行
         */
        int result = db.delete("inf", "name=?", new String[]{name});
        db.close();//关闭数据库
        return result;
    }

    public int update(InfoBean bean) {
        SQLiteDatabase db = mOpen.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone", bean.phone);

        /**
         * table 表名
         * values 更新的值
         * whereClause 更新的条件
         * whereArgs   更新条件的站位符号
         * 返回值是成功修改多少行
         */
        int result = db.update("inf", values, "name=?", new String[]{bean.name});
        db.close();
        return result;
    }

    public ArrayList<InfoBean> query(String name) {
        ArrayList<InfoBean> list = new ArrayList<>();
        SQLiteDatabase db = mOpen.getReadableDatabase();
        /**
         * sql sql语句
         * selectionArgs   查询条件占位符的值 返回一个cursor对象
         */
        Cursor cursor = db.rawQuery("select _id,name,phone from inf where name=?;", new String[]{name});
        /*解析cursor里面的内容*/
        if (cursor != null && cursor.getCount() > 0) {
            /*循环遍历结果，获取每一行的内容*/
            while (cursor.moveToNext()) {//条件，游标是否定位到了下一行
                InfoBean bean = new InfoBean();
                bean.id = String.valueOf(cursor.getInt(0));
                bean.name = cursor.getString(1);
                bean.phone = cursor.getString(2);
                list.add(bean);
            }
            cursor.close();
        }
        db.close();
        return list;
    }
}
