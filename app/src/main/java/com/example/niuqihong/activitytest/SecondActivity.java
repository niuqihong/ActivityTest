package com.example.niuqihong.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button = (Button) findViewById(R.id.button2);
        assert button !=null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("return_data","return Value to top activity");
            /*此方法 是专门用于向上一个activity 返回数据的,setResult()方法接收两个 参数,
            第一个参数用于向上一个活动返回处理结果,一般只使用 RESULT_OK 或 RESULT_CANCELED 这两个值,
            第二个参数则是把带有数据的 Intent 传递回去,然后调用 了 finish()方法来销毁当前活动。
            */
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("return_data","hello fristAcvitity");
        setResult(RESULT_OK,intent);
        finish();
    }
}
