package com.example.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //输出onCreate调试信息.
        Log.d("tag","onCreate");
        setContentView(R.layout.activity_main);
        //恢复之前的所有数据.
        if (savedInstanceState != null) {
            String tempData = savedInstanceState.getString("data_key");
            Log.d("tag",tempData);
        }
        //创建按钮响应.
        Button startNormalActivity = (Button)findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button)findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    //输出调试信息.
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag","onStart");
    }

    @Override
    protected  void onResume() {
        super.onResume();
        Log.d("tag","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tag","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tag","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("tag","onRestart");
    }

    //保存数据.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key",tempData);
    }
}
