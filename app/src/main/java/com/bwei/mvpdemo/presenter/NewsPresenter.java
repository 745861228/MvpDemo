package com.bwei.mvpdemo.presenter;

import android.content.Context;

import com.bwei.mvpdemo.bean.TopNews;
import com.bwei.mvpdemo.interfaces.OnNewsListener;
import com.bwei.mvpdemo.moudleiplm.NewsMoudleIplm;

/**
 * author by LiKe on 2017/2/17.
 */

public class NewsPresenter {

    private final Context context;
    private final OnNewsListener onNewsListener;

    public NewsPresenter(Context context,OnNewsListener onNewsListener) {
        this.context = context;
        this.onNewsListener = onNewsListener;
    }

    NewsMoudleIplm newsMoudleIplm = new NewsMoudleIplm();

    public void getNewsData(){
        newsMoudleIplm.getNews(context, "top", new OnNewsListener() {
            @Override
            public void onSuccess(TopNews topNews) {
                onNewsListener.onSuccess(topNews);
            }

            @Override
            public void onError(String error) {
                onNewsListener.onError(error);
            }
        });
    }
}
