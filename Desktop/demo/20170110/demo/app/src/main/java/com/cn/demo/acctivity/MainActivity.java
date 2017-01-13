package com.cn.demo.acctivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.cn.demo.R;
import com.cn.demo.adapter.CommonAdapter;
import com.cn.demo.utils.ContentResolverUtils;
import com.cn.demo.utils.PersonResolverUtils;
import com.cn.demo.utils.dto.ContactInfo;
import com.cn.demo.viewholder.ViewHolder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    private int i=0;
    private EditText et_name,et_phone;
    private Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.demo_list_01);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        refresh();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_add){
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", String.valueOf(et_name.getText()));
            contentValues.put("phone", String.valueOf(et_phone.getText()));
            Uri url = PersonResolverUtils.insert(getApplicationContext(),contentValues);
            if(url!=null){
                Toast.makeText(getApplicationContext(),"新增成功",Toast.LENGTH_LONG).show();
                refresh();
            }
        }
    }

    private void refresh(){
        List<Map> list = PersonResolverUtils.getPersonInfoList(getApplicationContext());
        if(list!=null&&list.size()>0){
            listView.setAdapter(new CommonAdapter<Map>(getApplicationContext(), list, R.layout.demo_list_01) {
                @Override
                public void convert(ViewHolder helper, final Map map) {
                    helper.setText(R.id.tv_title, (String) map.get("name"));
                    helper.setText(R.id.tv_phone,(String) map.get("phone"));
                    helper.getView(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int count = PersonResolverUtils.delete(getApplicationContext(),(String) map.get("name"));
                            if(count>0){
                                Toast.makeText(getApplicationContext(),"删除成功",Toast.LENGTH_LONG).show();
                                refresh();
                            }
                        }
                    });
                }
            });
        }else {
            listView.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1));
        }
    }
}
