package com.baidu.myapplication;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by asus on 2016/4/21.
 */
public class HttpHandle extends AsyncTask<String ,Void,String> {
    private String url; //url是String类型，而非URL类型。
    private StringBuilder sb;
    private JData jData;

    public HttpHandle(String url,JData jData){
        this.url=url;
        this.jData=jData;
    }
    @Override
    protected String doInBackground(String... params) {
        try {

            URL uuu = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) uuu.openConnection();
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);
            connection.setRequestMethod("GET");
            InputStream in = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            sb = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {         //注意StringBuilder的readLine()方法。
                sb.append(s);
            }


            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    protected void onPostExecute(String s) {
        jData.sendJData(s);
        super.onPostExecute(s);
    }


}























