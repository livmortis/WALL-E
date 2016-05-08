package com.baidu.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by asus on 2016/4/21.
 */
public class MyAdapter extends ArrayAdapter {
    LayoutInflater inflater;
    View v;
    TextView tv;
    TextView tvr;
    RelativeLayout rlleft;
    RelativeLayout rlright;
//    List<Msg> list;
    Msg msg;
    int res;

    public MyAdapter(Context context, int resource, List<Msg> list){
        super(context, resource, list);
        res=resource;
//        this.list=list;
//        this.TAG=TAG;
//        this.i=i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        msg = (Msg) getItem(position);
        if (convertView == null) {
            v = inflater.from(getContext()).inflate(res, null);


        } else {
            v = convertView;
        }
        if(msg.isType()) {
            rlleft = (RelativeLayout) v.findViewById(R.id.left);
            rlright = (RelativeLayout) v.findViewById(R.id.right);
            tvr = (TextView) v.findViewById(R.id.itemr_tv);
            tvr.setText(msg.getContent());
            rlleft.setVisibility(View.INVISIBLE);
        }
        else{
            rlright = (RelativeLayout) v.findViewById(R.id.right);
            rlleft = (RelativeLayout) v.findViewById(R.id.left);
            tv = (TextView) v.findViewById(R.id.item_tv);
            tv.setText(msg.getContent());
            rlright.setVisibility(View.INVISIBLE);
        }
        return v;
    }

}
