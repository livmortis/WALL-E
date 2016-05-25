package com.baidu.myapplication;

/**
 * Created by asus on 2016/4/23.
 */
public class Msg {

    public static int LEFT=0;
    public static int RIGHT=1;
    private int type;


    public Msg(int type,String content){
        this.type=type;
        this.content=content;
    }


    public int isType() {
        return type;
    }



    private String content=null;


    public String getContent() {
        return content;
    }
}
