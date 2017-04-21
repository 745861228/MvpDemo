package com.bwei.mvpdemo.interfaces;

import com.bwei.mvpdemo.bean.TopNews;

/**
 * author by LiKe on 2017/2/17.
 */

public interface OnNewsListener {

    public void onSuccess(TopNews topNews);
    public void onError(String error);
}
