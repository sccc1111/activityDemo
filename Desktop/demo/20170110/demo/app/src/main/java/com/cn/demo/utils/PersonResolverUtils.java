package com.cn.demo.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.cn.demo.utils.dto.ContactInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by songbo on 2017-01-12.
 */
public class PersonResolverUtils {

    private static final Uri queryUri = Uri.parse("content://cn.itcast.providers.personprovider/query");
    private static final Uri insertUri = Uri.parse("content://cn.itcast.providers.personprovider/insert");
    private static final Uri updateUri = Uri.parse("content://cn.itcast.providers.personprovider/update");
    private static final Uri deleteUri = Uri.parse("content://cn.itcast.providers.personprovider/delete");

    public static List<Map> getPersonInfoList(Context context){
        List<Map> personInfoList = new ArrayList<>();

        ContentResolver contentResolver = context.getContentResolver();

        Cursor cursor = contentResolver.query(queryUri,null,null,null,null);

        while(cursor.moveToNext()){
            Map map = new HashMap();
            map.put("name",cursor.getString(cursor.getColumnIndex("name")));
            map.put("phone",cursor.getString(cursor.getColumnIndex("phone")));
            map.put("email",cursor.getString(cursor.getColumnIndex("email")));
            personInfoList.add(map);
        }
        return personInfoList;
    }

    public static Uri insert(Context context,ContentValues contentValues){
        ContentResolver contentResolver = context.getContentResolver();

        return contentResolver.insert(insertUri,contentValues);
    }

    public static void update(Context context,ContentValues contentValues,String name){
        ContentResolver contentResolver = context.getContentResolver();

        contentResolver.update(updateUri,contentValues,"name = ?",new String[]{name});
    }

    public static int delete(Context context,String name){
        ContentResolver contentResolver = context.getContentResolver();

        return contentResolver.delete(deleteUri,"name = ?",new String[]{name});
    }
}
