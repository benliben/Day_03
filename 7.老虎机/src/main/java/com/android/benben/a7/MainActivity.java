package com.android.benben.a7;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    @InjectView(R.id.tiger1)
    ListView tiger1;
    @InjectView(R.id.tiger2)
    ListView tiger2;
    @InjectView(R.id.tiger3)
    ListView tiger3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mContext = this;
        initView();
    }

    private void initView() {
        TigerAdapter adapter = new TigerAdapter();

        tiger1.setAdapter(adapter);
        tiger2.setAdapter(adapter);
        tiger3.setAdapter(adapter);
    }

    class TigerAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 50;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = null;
            if (convertView == null) {
                view = new TextView(mContext);

            } else {
                view = (TextView) convertView;
            }
            Random random = new Random();
            int number = random.nextInt(100);
            if (number < 20) {
                view.setText("桃");
            } else if (number < 40) {
                view.setText("杏");
            } else if (number < 60) {
                view.setText("梨");
            } else if (number < 80) {
                view.setText("枣");
            } else {
                view.setText("瓜");
            }
            view.setTextSize(28);
            return view;
        }
    }

}
