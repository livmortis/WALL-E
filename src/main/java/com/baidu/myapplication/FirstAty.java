package com.baidu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by asus on 2016/5/25.
 */
public class FirstAty extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_aty);
        ImageView iv = (ImageView) findViewById(R.id.image_v);
//        iv.setVisibility(View.VISIBLE);
        AnimationDrawable ad = new AnimationDrawable();
        ad.addFrame(getResources().getDrawable(R.drawable.mg1,null), 200);
//        ad.addFrame(getResources().getDrawable(R.drawable.mg2,null), 200);
        ad.addFrame(getResources().getDrawable(R.drawable.mg3,null), 200);
        ad.addFrame(getResources().getDrawable(R.drawable.mg4,null), 200);
        ad.addFrame(getResources().getDrawable(R.drawable.mg5,null), 200);
//        ad.addFrame(getResources().getDrawable(R.drawable.mg6,null), 200);
//        ad.addFrame(getResources().getDrawable(R.drawable.mg7,null), 1);
//        ad.addFrame(getResources().getDrawable(R.drawable.mg8,null), 200);
        ad.addFrame(getResources().getDrawable(R.drawable.mg9,null), 200);
//        ad.addFrame(getResources().getDrawable(R.drawable.mg10,null), 1);
        ad.addFrame(getResources().getDrawable(R.drawable.mg11, null), 200);
        iv.setImageDrawable(ad);
        ad.setOneShot(false);
        ad.start();


        final Button bu = (Button) findViewById(R.id.start);

        bu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    bu.setBackgroundResource(R.drawable.downcaijian);
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    bu.setBackgroundResource(R.drawable.caijian);
                    Intent intent = new Intent(FirstAty.this, MainActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });


    }
}
