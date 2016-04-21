package com.example.niuqihong.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //获取intent 之间传输的数据
        Intent intent = getIntent();
        String data = intent.getStringExtra("extar_data");
        Toast.makeText(ThirdActivity.this,data,Toast.LENGTH_LONG).show();
//        Log.d(TAG, "onCreate:data ");


    }
}
