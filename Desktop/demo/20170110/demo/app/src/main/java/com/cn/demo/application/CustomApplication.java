package com.cn.demo.application;

import android.app.Application;

/**
 * Created by songbo on 2017-01-13.
 */
public class CustomApplication extends Application {
    private static final String VALUE = "demo";

    private String value;

    @Override
    public void onCreate()
    {
        super.onCreate();
        setValue(VALUE); // 初始化全局变量
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
