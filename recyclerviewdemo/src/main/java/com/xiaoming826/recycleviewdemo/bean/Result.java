package com.xiaoming826.recycleviewdemo.bean;

/**
 * Created by Eric on 2015/10/28.
 */
public class Result {

    private String name;

    private int icon;

    private int image;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Result(String name, int icon, int image) {
        this.name = name;
        this.icon = icon;
        this.image = image;
    }

    public Result() {
    }
}
