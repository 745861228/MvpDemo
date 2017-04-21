package com.bwei.mvpdemo.moudle;

import android.content.Context;

import com.bwei.mvpdemo.interfaces.OnNewsListener;

/**
 * author by LiKe on 2017/2/17.
 */

public interface NewsMoudle {
    public void getNews(Context context, String type, OnNewsListener onNewsListener);
}
