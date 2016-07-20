package com.android.benben.a8;

import android.content.Context;

import com.android.benben.a8.bean.NewsBean;

import java.util.ArrayList;

/**
 * Created by LiYuanxiong on 2016/6/21 15:59.
 * Desribe:
 */
public class NewsUtils {

    /*封装新闻假数据到list中返回*/
    public static ArrayList<NewsBean> getAllNews(Context context) {

        ArrayList<NewsBean> arrayList = new ArrayList<>();

        for (int i = 0; i < 300; i++) {
            NewsBean bn = new NewsBean();
            bn.title = "谢霆锋经纪人：偷拍系侵权行为";
            bn.des = "哈哈";
            bn.news_url = "http://www.baidu.com";
            bn.img = context.getResources().getDrawable(R.mipmap.ic_launcher);
            arrayList.add(bn);

            NewsBean bn1 = new NewsBean();
            bn1.title = "反手空地方你哦按覅";
            bn1.des = "都我哎叫苏乞儿就去";
            bn1.news_url = "http://www.baidu.com";
            bn1.img =context.getResources().getDrawable(R.mipmap.ic_launcher);
            arrayList.add(bn1);

            NewsBean bn2 = new NewsBean();
            bn2.title = "拉到市公安局欧IT将诶就突然跑去金二胖就去";
            bn2.des = "怕时间得分加帕尔飞机票去儿科他脾气就陪她就跑了法尔加迫切";
            bn2.news_url = "http://www.baidu.com";
            bn2.img = context.getResources().getDrawable(R.mipmap.ic_launcher);
            arrayList.add(bn2);

            NewsBean bn3 = new NewsBean();
            bn3.title = "大佛平均安排的书法家怕";
            bn3.des = "哦啊及东风破安静哦破房间爱爬山的解放牌阿胶平爱狗爱好同仁";
            bn3.news_url = "http://www.baidu.com";
            bn3.img = context.getResources().getDrawable(R.mipmap.ic_launcher);
            arrayList.add(bn3);
        }


        return arrayList;
    }
}
