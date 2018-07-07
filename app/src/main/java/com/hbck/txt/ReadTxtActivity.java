package com.hbck.txt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class ReadTxtActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tv_content;
    private TxtBean txtBean;
    private Button button_pre;
    private Button button_next;
    private ProcessText processText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_txt);
        //Intent获取TxtBean对象
        txtBean = (TxtBean) getIntent().getSerializableExtra("txtBean");
        setTitle(txtBean.getFileName());
        initView();

        processText = new ProcessText(new File(txtBean.getFilePath()), 1);
        String next = processText.getPre();
        tv_content.setText(next);
    }


    private void initView() {
        tv_content = (EditText) findViewById(R.id.tv_content);
        button_pre = (Button) findViewById(R.id.button_pre);
        button_pre.setOnClickListener(this);
        button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_pre:
                tv_content.setText(processText.getPre());
                break;
            case R.id.button_next:
                if (processText.getCurrentpage() >= processText.getPages()) {
                    Toast.makeText(this, "到尾页了", Toast.LENGTH_SHORT).show();
                    return;
                }
                tv_content.setText(processText.getNext());
                break;
        }
    }
}
