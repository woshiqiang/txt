package com.hbck.txt;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<TxtBean> listTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("文本阅读器");
        init();

    }

    private void init() {
        listView = (ListView) findViewById(R.id.listView);

        final ProgressDialog dialog = ProgressDialog.show(this, "", "正在读取...", false, false);
        dialog.show();
        //遍历sd卡，耗时操作，单独放在线程里
        new Thread(new Runnable() {
            @Override
            public void run() {
                File file = Environment.getExternalStorageDirectory();
                listTxt = TxtTool.listFileTxt(file);
                dialog.dismiss();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MyAdapter adapter = new MyAdapter(MainActivity.this, listTxt);
                        listView.setAdapter(adapter);
                    }
                });
            }
        }).start();

        //列表项点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ReadTxtActivity.class);
                intent.putExtra("txtBean", listTxt.get(position));
                startActivity(intent);
            }
        });
    }

}
