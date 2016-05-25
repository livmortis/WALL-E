package com.baidu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements JData,View.OnClickListener{
    private Button bu;
    private EditText et;
    private ListView lv;
    HttpHandle hh;
    List<Msg> list;
    String text;
    String code;
    String input;
    MyAdapter adapter;
    Msg msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        lv = (ListView) findViewById(R.id.lv);
        bu = (Button) findViewById(R.id.bu);
        bu.setOnClickListener(this);
        et = (EditText) findViewById(R.id.et);
        list = new ArrayList();
        msg=new Msg(msg.LEFT,"hi");
        list.add(msg);
        adapter=new MyAdapter(this,list);
        lv.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bu:
                input=et.getText().toString();
                msg = new Msg(Msg.RIGHT, input);
                list.add(msg);
                adapter.notifyDataSetChanged();
                respose();
                lv.setSelection(list.size());
                et.setText("");
        }
    }
    public void respose(){
        hh = (HttpHandle)new HttpHandle(
                "http://www.tuling123.com/openapi/api?key=d8525bb4b3c6bb538ed4490b1b7baa1c&info="+input
                , this).execute();
    }
    @Override
    public void sendJData(String data) {
        if(data!=null) {
            parseData(data);
        }else{
            Toast.makeText(MainActivity.this,"没有网络，我联系不上你..",Toast.LENGTH_LONG).show();
        }
    }
    private void parseData(String apidata) {
        try {
            JSONObject object = new JSONObject(apidata);
            code = object.getString("code");
            text = object.getString("text");
            msg = new Msg(Msg.LEFT, text);
            list.add(msg);
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
