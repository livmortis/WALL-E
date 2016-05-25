package com.baidu.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/4/21.
 */
public class MyAdapter extends BaseAdapter {
    LayoutInflater inflater;
    View v;
    TextView tv;
    RelativeLayout rlleft;
    Msg msg;

    List<Msg> list=new ArrayList<>();
    Context context=null;
    public MyAdapter(Context context, List<Msg> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Msg getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        msg = getItem(position);
        inflater=LayoutInflater.from(context);
        if(list.get(position).isType()==msg.LEFT){
            rlleft = (RelativeLayout) inflater.inflate(R.layout.item, null);
        }
        if(list.get(position).isType()==msg.RIGHT) {
            rlleft = (RelativeLayout) inflater.inflate(R.layout.itemr, null);
        }
        tv = (TextView) rlleft.findViewById(R.id.item_tv);
        tv.setText(list.get(position).getContent());                  //ø’÷∏’Î“Ï≥£
        return rlleft;

//        if(msg.isType()) {
//            rlleft = (RelativeLayout) v.findViewById(R.id.left);
//            rlright = (RelativeLayout) v.findViewById(R.id.right);
//            tvr = (TextView) v.findViewById(R.id.itemr_tv);
//            tvr.setText(msg.getContent());
//            rlleft.setVisibility(View.INVISIBLE);
//        }
//        else{
//            rlright = (RelativeLayout) v.findViewById(R.id.right);
//            rlleft = (RelativeLayout) v.findViewById(R.id.left);
//            tv = (TextView) v.findViewById(R.id.item_tv);
//            tv.setText(msg.getContent());
//            rlright.setVisibility(View.INVISIBLE);
//        }
    }

}
