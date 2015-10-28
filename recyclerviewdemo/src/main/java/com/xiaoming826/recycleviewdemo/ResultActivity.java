package com.xiaoming826.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xiaoming826.recycleviewdemo.bean.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        List<Result> list=new ArrayList<Result>();
        list.add(new Result("曼论坛",R.drawable.dot_yellow,R.drawable.luntan));
        list.add(new Result("曼论坛",R.drawable.dot_yellow,R.drawable.luntan));
        list.add(new Result("曼论坛",R.drawable.dot_yellow,R.drawable.luntan));
        list.add(new Result("曼论坛",R.drawable.dot_yellow,R.drawable.luntan));
        list.add(new Result("曼论坛",R.drawable.dot_yellow,R.drawable.luntan));
        list.add(new Result("曼论坛",R.drawable.dot_yellow,R.drawable.luntan));
        list.add(new Result("曼论坛",R.drawable.dot_yellow,R.drawable.luntan));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv_result);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new ResultAdapter(this,list));
        recyclerView.setNestedScrollingEnabled(false);
    }
}