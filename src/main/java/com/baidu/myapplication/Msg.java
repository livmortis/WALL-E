package com.baidu.myapplication;

/**
 * Created by asus on 2016/4/23.
 */
public class Msg {

//    private int LEFT=0;
//    private int RIGHT=1;
    private boolean type=false;


    public Msg(boolean type,String content){
        this.type=type;
        this.content=content;
    }


    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
