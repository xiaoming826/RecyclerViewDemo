package com.xiaoming826.recycleviewdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaoming826.recycleviewdemo.HeadListActivity;
import com.xiaoming826.recycleviewdemo.R;
import com.xiaoming826.recycleviewdemo.ResultActivity;

import java.util.List;

/**
 * Created by Eric on 2015/10/28.
 */
public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private RecyclerView recyclerView;
    private Context context;
    private List<String> list;

    public MyAdapter(Context context, List<String> list, RecyclerView recyclerView) {
        this.list = list;
        this.context = context;
        this.recyclerView=recyclerView;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
        }


        public void setData(int position) {
            this.textView.setText(list.get(position));
        }

        public void startActivity(Class<?> cls) {
            Intent intent = new Intent(context, cls);
            context.startActivity(intent);
        }

        @Override
        public void onClick(View v) {
            switch (getAdapterPosition()) {
                case 0:
                    //这里的false是说明是否倒序排列
                    recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                    break;
                case 1:
                    recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                    break;
                case 2:
                    recyclerView.setLayoutManager(new GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false));
                    break;
                case 3:
                    recyclerView.setLayoutManager(new GridLayoutManager(context, 3, GridLayoutManager.HORIZONTAL, false));
                    break;
                case 4:
                    Toast.makeText(context, "还没做", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    startActivity(HeadListActivity.class);
                    break;


                case 6:
                    startActivity(ResultActivity.class);
                    break;

                default:
                    Toast.makeText(context, list.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();

            }

        }
    }
}