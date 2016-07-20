package com.android.benben.a8;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.benben.a8.adapter.*;
import com.android.benben.a8.bean.NewsBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Context mContext;
    private ListView mContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mContent = (ListView) findViewById(R.id.main_content);

        /*获取新闻数据用list封装*/
        ArrayList<NewsBean> arrayList = NewsUtils.getAllNews(mContext);
        /*创建一个adapter设置个listview*/
        MyAdapter adapter = new MyAdapter(mContext,arrayList);
        mContent.setAdapter(adapter);

        /*设置listviw条目的点击事件*/
        mContent.setOnItemClickListener(this);
    }


    /**
     * listView的条目点击时会调用
     * @param parent  listView
     * @param view     点击条目的view对象
     * @param position     条目的位置
     * @param id        条目的id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*需要获取条目上bean对象中url的跳转*/
        NewsBean bean = (NewsBean) parent.getItemAtPosition(position);
        String url = bean.news_url;
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }
}
