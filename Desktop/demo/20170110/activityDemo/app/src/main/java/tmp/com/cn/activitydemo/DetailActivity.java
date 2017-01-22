package tmp.com.cn.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class DetailActivity extends Activity {
    private static final String TAG = "DetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"DetailActivity-- onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        android.app.ActionBar actionBar = getActionBar();
        actionBar.setTitle("明细");
        Intent i = getIntent();
        Bundle b = i.getExtras();

        Toast.makeText(DetailActivity.this,b.getString("code"),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        Log.i(TAG,"DetailActivity-- onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,"DetailActivity-- onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,"DetailActivity-- onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"DetailActivity-- onStop");
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.i(TAG,"DetailActivity-- onDestroy");
        super.onDestroy();
    }

    public void link1(View view){
        Intent intent = new Intent(DetailActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void link2(View view){
        Intent intent = new Intent(DetailActivity.this,MainActivity.class);
        intent.putExtra("result","返回值");
        setResult(999,intent);
        finish();
    }
}
