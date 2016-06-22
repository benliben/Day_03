package com.android.benben.a9listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.benben.a9listview.bean.InfoBean;

import java.util.ArrayList;

/**
 * Created by LiYuanxiong on 2016/6/22 10:33.
 * Desribe:
 */
public class QueryAdapter extends BaseAdapter {
    private ArrayList<InfoBean> list;
    private Context mContext;

    public QueryAdapter(ArrayList<InfoBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

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
        if (convertView == null) {
            view=View.inflate(mContext, R.layout.item_list, null);
        }else {
            view = convertView;
        }
        /*找到控件*/
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView phone = (TextView) view.findViewById(R.id.phone);

        /*找到内容*/
        InfoBean bean = list.get(position);
        /*设置内容*/
        id.setText(bean.id);
        phone.setText(bean.phone);
        name.setText(bean.name);
        return view;
    }
}
