package com.android.benben.a42.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.benben.a42.InfoBean;
import com.android.benben.a42.MySqliteOpenHelper;


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

    public boolean add(InfoBean bean) {
        /*调用getReadableDatabase方法，来初始化数据库的创建*/
        SQLiteDatabase db = mOpen.getReadableDatabase();
        ContentValues values = new ContentValues();//是用map封装的对象，用来存放值的
        values.put("name", bean.name);
        values.put("phone", bean.phone);
        /**
         * table:表名
         * nullColumnHack：可以为空，表示添加一个空行
         * values：添加数据一行的值
         * 返回值表示添加这一行的id 如果是-1表示添加失败
         */
        long insert = db.insert("info", null, values);
        db.close();//关闭数据库对象
        if (insert != -1) {
            return true;
        }
        return false;
    }

    public int del(String name) {
        /*调用getReadableDatabase方法，来初始化数据库的创建*/
        SQLiteDatabase db1 = mOpen.getReadableDatabase();
        /**
         * table :表名
         * whereClause ：删除条件
         * whereArgs :条件的站位符参数
         * 返回值为成功删除多少行
         */
        int result=db1.delete("info", "name=?", new String[]{name});
        db1.close();//关闭数据库对象
        return result;
    }

    public int update(InfoBean bean) {
        /*调用getReadableDatabase方法，来初始化数据库的创建*/
        SQLiteDatabase db2 = mOpen.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone", bean.phone);
        /**
         * table 表名
         * values 更新的值
         * whereClause 更新的条件
         * whereArgs   更新条件的站位符号
         * 返回值是成功修改多少行
         */
        int result=db2.update("info", values, "name=?", new String[]{bean.name});
        db2.close();//关闭数据库对象
        return result;

    }

    public void query(String name) {
        /*调用getReadableDatabase方法，来初始化数据库的创建*/
        SQLiteDatabase db3 = mOpen.getReadableDatabase();
        /**
         * table 表名
         * selectionArgs 查询的列名，如果是null代表查询所有列
         * selection 查询的条件
         * selectionArgs 条件占位符的参数值
         * groupBy 按什么字段分组
         * having 分组条件
         * orderBy 按什么字段分组
         */
       Cursor cursor= db3.query("info", new String[]{"_id", "name", "phone"}, "name=?",
                new String[]{name}, null, null, "_id desc");
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
