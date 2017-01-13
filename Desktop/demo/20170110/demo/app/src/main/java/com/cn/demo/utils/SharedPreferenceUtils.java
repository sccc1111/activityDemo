package com.cn.demo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by songbo on 2017-01-12.
 */
public class SharedPreferenceUtils {

    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    public SharedPreferenceUtils(Context context) {
        sharedPreferences =context.getSharedPreferences("config", Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    void getString(String name){
        sharedPreferences.getString(name,"");
    }

    void getInt(String name){
        sharedPreferences.getInt(name,0);
    }

    void getLong(String name){
        sharedPreferences.getLong(name,0l);
    }

    void putString(String name,String value){
        editor.putString(name,value);
        editor.commit();
    }

    void putInt(String name,int value){
        editor.putInt(name,value);
        editor.commit();
    }

    void putLong(String name,long value){
        editor.putLong(name,value);
        editor.commit();
    }
}
