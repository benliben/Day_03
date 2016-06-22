package com.android.benben.a9listview;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.benben.a9listview.bean.InfoBean;
import com.android.benben.a9listview.dao.InfoDao;

import java.util.ArrayList;

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
    ListView mContent;

    private Context mContext;
    private ArrayList<InfoBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mContext = this;
    }

    @OnClick({R.id.main_add, R.id.main_del, R.id.main_update, R.id.main_query})
    public void onClick(View view) {
        InfoDao dao = new InfoDao(mContext);
        InfoBean bean = new InfoBean();
        switch (view.getId()) {
            case R.id.main_add:
                bean.name = "小明";
                bean.phone = "120";
                boolean result = dao.add(bean);
                if (result) {
                    Toast.makeText(mContext, "添加成功", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(mContext, "添加失败", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.main_del:
                int del = dao.del("小明");
                Toast.makeText(mContext, "成功删除了" + del + "行", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_update:
                bean.name = "小明";
                bean.phone = "119";
                int date = dao.update(bean);
                Toast.makeText(mContext, "成功修改了" + date + "行", Toast.LENGTH_LONG).show();
                break;
            case R.id.main_query:
                /*获取查询的数据*/
                ArrayList<InfoBean> query = dao.query("小明");
                /*封装adapter*/
                QueryAdapter queryAdapter = new QueryAdapter(query, mContext);
                mContent.setAdapter(queryAdapter);

                break;
        }
    }
}
