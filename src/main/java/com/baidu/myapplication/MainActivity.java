package com.baidu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
//    String apidata;
    String text;
    String code;
    String input;
    MyAdapter adapter;
    Msg msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList();
        init();
        bu = (Button) findViewById(R.id.bu);
        et = (EditText) findViewById(R.id.et);
        lv = (ListView) findViewById(R.id.lv);
        bu.setOnClickListener(this);
        adapter=new MyAdapter(this,R.layout.item,list);
        lv.setAdapter(adapter);
    }
    private void init() {
        msg=new Msg(false,"hello,my host");
        list.add(msg);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bu:
                input=et.getText().toString();
                msg = new Msg(true, input);
                list.add(msg);

                respose();
                adapter.notifyDataSetChanged();
                lv.setSelection(list.size());
        }
    }
    public void respose(){
        hh = (HttpHandle)new HttpHandle(
                "http://www.tuling123.com/openapi/api?key=d8525bb4b3c6bb538ed4490b1b7baa1c&info="+input
                , this).execute();
//        parseData(apidata);
        msg = new Msg(false, text);
        list.add(msg);
    }
    @Override
    public void sendJData(String data) {

//        this.apidata=data;
        parseData(data);
    }

    private void parseData(String apidata) {
        try {

            JSONObject object = new JSONObject(apidata);
            code = object.getString("code");
            text = object.getString("text");


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
