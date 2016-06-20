package com.example.benben.day03;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.benben.day03.crud.dao.InfoDao;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.main_add)
    Button mAdd;
    @InjectView(R.id.main_del)
    Button mDel;
    @InjectView(R.id.main_update)
    Button mUpdate;
    @InjectView(R.id.main_query)
    Button mQuery;
    @InjectView(R.id.main_content)
    TextView mContent;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mContext = this;

        /*创建一个帮助类对象*/
        MySqliteOpenHelper mOpen = new MySqliteOpenHelper(mContext);
        /*调用getReadableDatabase方法，来初始化数据库的创建*/
        SQLiteDatabase db = mOpen.getReadableDatabase();


    }

    @OnClick({R.id.main_add, R.id.main_del, R.id.main_update, R.id.main_query})
    public void onClick(View view) {
        InfoDao dao = new InfoDao(mContext);
        switch (view.getId()) {
            case R.id.main_add:
                InfoBean bean = new InfoBean();
                bean.name = "李远雄";
                bean.phone = "182802546800";
                dao.add(bean);
                InfoBean bean1 = new InfoBean();
                bean1.name = "蒋敏";
                bean1.phone = "182802546800";
                dao.add(bean1);

                break;
            case R.id.main_del:
                dao.del("蒋敏");
                break;
            case R.id.main_update:
                InfoBean bean2 = new InfoBean();
                bean2.name = "李远雄";
                bean2.phone = "119";
                dao.add(bean2);
                dao.update(bean2);

                break;
            case R.id.main_query:
                dao.query("李远雄");

                dao.query("蒋敏");
                break;
        }
    }
}
