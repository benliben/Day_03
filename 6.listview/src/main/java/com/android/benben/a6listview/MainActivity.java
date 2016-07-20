package com.android.benben.a6listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<Integer, Integer> map = new HashMap<>();

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        /*创建listView*/
        ListView mContent = (ListView) findViewById(R.id.main_context);
        /*创建一个adapter对象*/
        MyListAdapter adapter = new MyListAdapter();
        /*将adapter设置给listView*/
        mContent.setAdapter(adapter);
    }


    class MyListAdapter extends BaseAdapter {


        /*告诉listView来显示多少个条目*/
        @Override
        public int getCount() {
            return 20;
        }

        /*根据position获取listView上条目对应的Bean数据，该方法不影响数据的展示，可以先不实现*/
        @Override
        public Object getItem(int position) {
            return null;
        }

        /*用来获取条目position行的id，该方法不影响数据的展示，可以先不实现*/
        @Override
        public long getItemId(int position) {
            return 0;
        }

        /*返回一个view对象作为条目上的内容展示，该条目返回什么样的view listView的条目就显示什么样的view，必须实现*/
        /*屏幕上每显示一个条目，getView就被调用一次*/
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView view = null;
            if (convertView == null) {//判断convertView是否为空
                view = new TextView(mContext);//创建一个textview对象
                view.setText("position" + position);//设置textview的内容
                view.setTextSize(30);

            } else {
                view = (TextView) convertView;
            }
            map.put(view.hashCode(), 1);
            Log.i("lyx", "创建了: " + map.size() + "个对象");
            return view;


        }
    }
}
