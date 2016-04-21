package com.example.niuqihong.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button = (Button) findViewById(R.id.button_1);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在intent之间传输数据
                String stringData = "use Intent pass data to next  Activity";
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                intent.putExtra("extar_data",stringData);
                startActivity(intent);
            }
        });
        Button button_back =(Button) findViewById(R.id.button_12);
        assert button_back != null;
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //用此方法启动活动,但是这个方法 期望在活动销毁的时候返回一个结果给上一个activity
                startActivityForResult(intent,1);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab!=null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                finish();//销毁当前的活动
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*    重写此方法接受 上一个activity 返回的信息
    onActivityResult()方法带有三个参数,第一个参数 requestCode,即我们在启动活动时传 入的请求码。
    第二个参数 resultCode,即我们在返回数据时传入的处理结果。第三个参数 data, 即携带着返回数据的 Intent。
    由于在一个活动中有可能调用 startActivityForResult()方法去启 动很多不同的活动,
    每一个活动返回的数据都会回调到 onActivityResult()这个方法中,因此 我们首先要做的就是通过检查 requestCode
    的值来判断数据来源。确定数据是从SecondActivity 返回的之后,我们再通过 resultCode 的值来判断处理结果是否成功
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returenData = data.getStringExtra("return_data");
                    Toast.makeText(MainActivity.this,returenData,Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            System.out.print("11111");
            Toast.makeText(MainActivity.this,"111",Toast.LENGTH_SHORT).show();
            return true;
        }else if (id == R.id.add_item){
            //使用显示的intent 转换activity
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }else if (id == R.id.remove_item){
            //使用隐式的Intent
            Intent intent = new Intent("com.example.activitytest.ACTION_START1");
            intent.addCategory("com.example.activitytest.MY_CATEGORY");
            startActivity(intent);
        }else if (id == R.id.url_intent){
            //用Intent启动网页
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.baidu.com"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
