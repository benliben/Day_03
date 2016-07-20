package com.android.benben.a5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.benben.a5.db.BankOpenHelper;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
    }

    public void  transtation(View v){

        /*创建一个帮助类对象*/
        BankOpenHelper oPen = new BankOpenHelper(mContext);
        /*调用数据库帮助类对象的getReadableDatabase创建数据库，初始化表数据，获取一个SqLiteDatabase对象去做砖帐*/
        SQLiteDatabase db = oPen.getReadableDatabase();
        /*转账*/

        db.beginTransaction();//开启一个数据库事物
        try{
            db.execSQL("update account set money=money-2000 where name=?", new String[]{"蒋敏"});
            db.execSQL("update account set money=money+2000 where name=?", new String[]{"李远雄"});

            db.setTransactionSuccessful();//标记事物中的Sql语句全部执行成功执行
        }finally {
            db.endTransaction();//判断事物的标记是否成功，如果不成功，回滚错误之前那=的sql语句
        }

    }
}
