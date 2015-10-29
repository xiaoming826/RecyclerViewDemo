package com.xiaoming826.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoming826.recycleviewdemo.bean.Result;

import java.util.List;

/**
 * Created by Eric on 2015/10/28.
 */
public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyHolder> {
    private  List<Result> list;
    private  Context context;

    public ResultAdapter(Context context, List<Result> list) {
        this.context=context;
        this.list=list;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.result_item, parent, false);

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

    class MyHolder extends RecyclerView.ViewHolder {
            TextView name;
        ImageView icon;
        ImageView image;

        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            icon= (ImageView) itemView.findViewById(R.id.iv_icon);
            image = (ImageView) itemView.findViewById(R.id.iv_image);
        }

        public void setData(int position){

            name.setText(list.get(position).getName());
            icon.setImageDrawable(context.getResources().getDrawable(list.get(position).getIcon()));
            image.setImageDrawable(context.getResources().getDrawable(list.get(position).getImage()));

        }
    }

}
