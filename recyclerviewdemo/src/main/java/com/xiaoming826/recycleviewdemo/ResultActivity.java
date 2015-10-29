package com.xiaoming826.recycleviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.xiaoming826.recycleviewdemo.bean.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = "ResultActivity";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        List<Result> list = new ArrayList<>();
        list.add(new Result("曼论坛", R.drawable.dot_yellow, R.drawable.luntan));
        list.add(new Result("曼论坛", R.drawable.dot_blue, R.drawable.dahuamancheng));
        list.add(new Result("曼论坛", R.drawable.dot_yellow, R.drawable.zhuzaimancheng));
        list.add(new Result("曼论坛", R.drawable.dot_blue, R.drawable.xiangqin));
        list.add(new Result("曼论坛", R.drawable.dot_yellow, R.drawable.yue));
        list.add(new Result("曼论坛", R.drawable.dot_blue, R.drawable.xueba));
        list.add(new Result("曼论坛", R.drawable.dot_blue, R.drawable.mantaobao));
        list.add(new Result("曼论坛", R.drawable.dot_yellow, R.drawable.sheep));
        list.add(new Result("曼论坛", R.drawable.dot_yellow, R.drawable.shejian));
        list.add(new Result("曼论坛", R.drawable.dot_blue, R.drawable.weixin));
        list.add(new Result("",R.drawable.transparent, R.drawable.transparent));
        list.add(new Result("",R.drawable.transparent, R.drawable.transparent));


        recyclerView = (RecyclerView) findViewById(R.id.rcv_result);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new ResultAdapter(this, list));
        recyclerView.setNestedScrollingEnabled(false);

        Log.d(TAG, "onCreate() getScreenHeight: " + getScreenHeight(this));
        Log.d(TAG, "onCreate() getScreenWidth: " + getScreenWidth(this));
        Log.d(TAG, "onCreate() getStatusHeight: " + getStatusHeight(this));
    }

    /**
     * 获得屏幕高度
     *
     * @param context context
     * @return widthPixels
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕宽度
     *
     * @param context context
     * @return heightPixels
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    /**
     * 获得状态栏的高度
     *
     * @param context context
     * @return StatusHeight
     */
    public static int getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }
}
