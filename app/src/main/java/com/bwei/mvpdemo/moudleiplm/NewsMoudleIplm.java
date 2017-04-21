package com.bwei.mvpdemo.moudleiplm;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwei.mvpdemo.bean.TopNews;
import com.bwei.mvpdemo.interfaces.OnNewsListener;
import com.bwei.mvpdemo.moudle.NewsMoudle;
import com.bwei.mvpdemo.url.URLUtils;
import com.google.gson.Gson;

/**
 * author by LiKe on 2017/2/17.
 */

public class NewsMoudleIplm implements NewsMoudle {
    @Override
    public void getNews(Context context, String type, final OnNewsListener onNewsListener) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLUtils.BASE_URL + "key=" + URLUtils.KEY + "&type=" + type, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //进行数据解析
                Gson gson = new Gson();
                TopNews topNews = gson.fromJson(response, TopNews.class);
                //将数据进行回调
                onNewsListener.onSuccess(topNews);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //将错误信息同时也进行回调
                onNewsListener.onError(error.getMessage());
            }
        });

        requestQueue.add(stringRequest);
    }
}
