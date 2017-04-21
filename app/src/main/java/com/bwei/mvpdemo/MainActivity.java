package com.bwei.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bwei.mvpdemo.bean.TopNews;
import com.bwei.mvpdemo.interfaces.OnNewsListener;
import com.bwei.mvpdemo.moudleiplm.NewsMoudleIplm;
import com.bwei.mvpdemo.presenter.NewsPresenter;

public class MainActivity extends AppCompatActivity implements OnNewsListener {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //查找控件
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        NewsPresenter newsPresenter = new NewsPresenter(MainActivity.this, this);
        newsPresenter.getNewsData();
    }

    @Override
    public void onSuccess(TopNews topNews) {
        Toast.makeText(this, topNews.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
