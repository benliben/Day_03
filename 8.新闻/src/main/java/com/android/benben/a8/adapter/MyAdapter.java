package com.android.benben.a8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.benben.a8.R;
import com.android.benben.a8.bean.NewsBean;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by LiYuanxiong on 2016/6/21 16:15.
 * Desribe:
 */
public class MyAdapter extends BaseAdapter {
    private ArrayList<NewsBean> list;
    /*通过构造方法接收要显示的数据级*/
    public MyAdapter(Context context,ArrayList<NewsBean> list) {
        this.list = list;
        this.context = context;
    }

    private Context context;



    @Override

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        /*复用converView优化listView，创建view作为getView的返回值用来显示一个条目*/
        if (convertView == null) {
            /**
             * context 上下文
             * resource  要转换成view对象的layout的id
             * root 将layout用root（viewgroup）包一层作为getview的返回值
             */
            /*方法一： 简单      将一个布局对象文件转换成一个view对象*/
//            view=View.inflate(context, R.layout.item_news, null);//
            /*方法二；一般        通过layoutInflater将布局转换成view对象*/
            view=LayoutInflater.from(context).inflate(R.layout.item_news, null);
            /*方法三；难   通过context获取系统服务得到一个layoutInflater，通过layoutInflater将一个布局转换成view对象*/
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_news, null);
        }else {
            view = convertView;
        }

        /*获取view上面的子控件对象*/
        ImageView img = (ImageView) view.findViewById(R.id.img);
        TextView title = (TextView) view.findViewById(R.id.news_title);
        TextView des = (TextView) view.findViewById(R.id.news_des);
        /*获取条目对象的list集合中的新闻数据，bean对象*/
        NewsBean bean = list.get(position);
        /*将获取到的数据赋值到子控件对象上，做显示*/
        img.setImageDrawable(bean.img);
        title.setText(bean.title);
        des.setText(bean.des);

        return view;
    }

    private void initView(View view) {



    }
}
