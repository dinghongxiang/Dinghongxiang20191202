package com.bawei.dinghongxiang20191203.Util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtils {

    private static NetUtils netUtils=new NetUtils();

    public static NetUtils getInstance() {
        return netUtils;
    }

    private NetUtils(){

    }


    @SuppressLint("StaticFieldLeak")
    public void doGet(final String http, final Huidiao huidiao){
        new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPostExecute(String s) {
                huidiao.Wen(s);
            }

            @Override
            protected String doInBackground(Void... voids) {

                String json="";
                HttpURLConnection httpURLConnection=null;
                InputStream inputStream=null;

                try {
                    URL url = new URL(http);
                    httpURLConnection= (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode()==200){
                        inputStream=httpURLConnection.getInputStream();
                        json=iotoString(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


                return json;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }



    @SuppressLint("StaticFieldLeak")
    public void doGetPhoto(final String http1, final Huidiao huidiao){
        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                huidiao.Tu(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {

                Bitmap bitmap=null;
                HttpURLConnection httpURLConnection=null;
                InputStream inputStream=null;

                try {
                    URL url = new URL(http1);
                    httpURLConnection= (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode()==200){
                        inputStream=httpURLConnection.getInputStream();
                        bitmap=bitmap1(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


                return bitmap;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public String iotoString(InputStream inputStream) throws IOException {
        String json="";

        byte[] bytes = new byte[1024];

        int len=-1;

        ByteArrayOutputStream bm = new ByteArrayOutputStream();

        while ((len=inputStream.read(bytes))!=-1){
            bm.write(bytes,0,len);
        }

        json=new String(bm.toByteArray());

        return json;
    }

    public Bitmap bitmap1(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }


    public boolean HasNet(Context content){
        ConnectivityManager cr= (ConnectivityManager) content.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ao = cr.getActiveNetworkInfo();
        if (ao!=null&&ao.isAvailable()){
            return true;
        }else {
            return false;
        }
    }

    public interface Huidiao{
        void Wen(String json);
        void Tu(Bitmap bitmap);
        void Failure(Throwable throwable);
    }


}
