package com.xiaoming826.recycleviewdemo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xiaoming826.recycleviewdemo.adapter.MyHeadAdapter;

import java.util.ArrayList;
import java.util.List;

public class HeadListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        int imageIds[] = {R.drawable.image_home, R.drawable.image_starry_sky, R.drawable.image_way};
        List<String> items = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            items.add(Math.random()+"");
        }


        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.id_refresh);

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.id_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        recyclerView.setAdapter(new MyHeadAdapter(this,imageIds,items));

    }
}
