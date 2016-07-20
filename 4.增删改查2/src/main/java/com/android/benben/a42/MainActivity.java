package com.android.benben.a42;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.benben.a42.dao.InfoDao;

public class MainActivity extends AppCompatActivity {
    @butterknife.InjectView(R.id.main_add)
    Button mAdd;
    @butterknife.InjectView(R.id.main_del)
    Button mDel;
    @butterknife.InjectView(R.id.main_update)
    Button mUpdate;
    @butterknife.InjectView(R.id.main_query)
    Button mQuery;
    @butterknife.InjectView(R.id.main_content)
    TextView mContent;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.inject(this);
        mContext = this;
    }

    @butterknife.OnClick({R.id.main_add, R.id.main_del, R.id.main_update, R.id.main_query})
    public void onClick(View view) {
        InfoDao dao = new InfoDao(mContext);
        switch (view.getId()) {
            case R.id.main_add:
                InfoBean bean = new InfoBean();
                bean.name = "李远雄";
                bean.phone = "182";
                boolean result = dao.add(bean);
                if (result) {
                    Toast.makeText(mContext, "添加成功", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(mContext, "添加失败", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.main_del:
                int del = dao.del("李远雄");
                Toast.makeText(mContext, "成功删除了" + del + "行", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_update:
                InfoBean bean1 = new InfoBean();
                bean1.name = "蒋敏";
                bean1.phone = "7551";
                int update = dao.update(bean1);
                Toast.makeText(mContext, "成功修改了" + update + "行", Toast.LENGTH_LONG).show();

                break;
            case R.id.main_query:
                dao.query("蒋敏");
                dao.query("李远雄");
                break;
        }
    }
}
