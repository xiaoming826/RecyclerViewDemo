package com.xiaoming826.recycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaoming826.recycleviewdemo.R;

import java.util.List;

/**
 * Created by Eric on 2015/10/28.
 */
public class MyHeadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEWTYPE_HEAD = 0;
    private static final int VIEWTYPE_BODY = 1;
    private static final int VIEWTYPE_FOOT = 2;

    private static final String TAG = "MyHeadAdapter";
    private Context context;
    private int[] imageIds;
    private List<String> items;

    public MyHeadAdapter(Context context, int[] imageIds, List<String> items) {
        this.context = context;
        this.imageIds = imageIds;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEWTYPE_HEAD) {
            View view = LayoutInflater.from(context).inflate(R.layout.head_view, parent, false);

            return new MyHeadHolder(view);
//            return new MyHeadHolder(new ImageView(context));
        } else if (viewType == VIEWTYPE_BODY) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_main_item, parent, false);

            return new MyBodyHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_main_item, parent, false);

            return new MyFootHolder(view);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEWTYPE_HEAD;
        } else if (position == getItemCount() - 1) {
            return VIEWTYPE_FOOT;
        } else {
            return VIEWTYPE_BODY;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof MyBodyHolder) {
            ((MyBodyHolder) holder).textView.setText(items.get(position - 1));
        } else if (holder instanceof MyHeadHolder) {

        // ((MyHeadHolder) holder).imageView.setImageDrawable(context.getResources().getDrawable(imageIds[0]));
           // ((MyHeadHolder) holder).imageView.setImageDrawable(context.getResources().getDrawable(android.R.drawable.ic_input_add));

        } else if (holder instanceof MyFootHolder) {
            ((MyFootHolder) holder).textView.setText("FootView");
        }
    }


    @Override
    public int getItemCount() {
        return items.size() + 2;
    }

    public class MyBodyHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyBodyHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }


    }

    public class MyHeadHolder extends RecyclerView.ViewHolder {

     //   ImageView imageView;

        public MyHeadHolder(View itemView) {
            super(itemView);
         //   imageView= (ImageView) itemView;
       }


    }

    public class MyFootHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyFootHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

    }
}
