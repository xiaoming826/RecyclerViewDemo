package com.xiaoming826.recycleviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.xiaoming826.recycleviewdemo.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout refresh;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle("RecyclerView  Demo");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        List<String> list = new ArrayList<>();
        list.add("纵向列表");
        list.add("横向列表");
        list.add("纵向格子");
        list.add("横向格子");
        list.add("有头和尾的列表");
        list.add("瀑布流效果");
        list.add("效果");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");
        list.add("我是来卖萌的");


        refresh = (SwipeRefreshLayout) findViewById(R.id.id_refresh);

        refresh.setOnRefreshListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(this, list,recyclerView));

    }

    @Override
    public void onRefresh() {
        Toast.makeText(MainActivity.this, "呵呵哒", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refresh.setRefreshing(false);
            }
        }, 1000);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }


}
