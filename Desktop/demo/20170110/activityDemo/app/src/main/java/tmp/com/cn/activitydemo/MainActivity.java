package tmp.com.cn.activitydemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"MainActivity-- onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle("主页");
    }

    @Override
    protected void onStart() {
        Log.i(TAG,"MainActivity-- onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,"MainActivity-- onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,"MainActivity-- onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"MainActivity-- onStop");
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.i(TAG,"MainActivity-- onDestroy");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Log.i(TAG,"MainActivity-- onBackPressed");
        super.onBackPressed();
    }

    public void link(View view){
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        Bundle b = new Bundle();
        b.putString("code","传参");
        intent.putExtras(b);
        startActivityForResult(intent,999);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==999&&resultCode==999){
            Toast.makeText(MainActivity.this,data.getStringExtra("result"),Toast.LENGTH_LONG).show();
        }
    }
}
