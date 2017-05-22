package Tread;

import android.os.Handler;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import utils.WeatherAqi;

/**
 * Created by Administrator on 2017/5/17 0017.
 */

public class HttpThreadAqi extends Thread{
    private String url;
    private Handler handler;
    private TextView wuran;
    private TextView aqi;
    private TextView PM25;

    public HttpThreadAqi(String url, Handler handler, TextView wuran, TextView aqi, TextView PM25) {
        this.url = url;
        this.handler = handler;
        this.wuran = wuran;
        this.aqi = aqi;
        this.PM25 = PM25;
    }

    public void Aqi(){
        try {
            URL httpUrl=new URL(url);
            try {
                HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
                conn.setRequestMethod("GET");
                conn.setReadTimeout(5000);
                BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer sb=new StringBuffer();
                String str;
                while ((str=reader.readLine())!=null){
                    sb.append(str);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        jsonAqi(sb);
                    }
                });


            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void jsonAqi(StringBuffer json){
        Gson gson=new Gson();
        WeatherAqi weatherAqi=gson.fromJson(json.toString(),WeatherAqi.class);
        aqi.setText(weatherAqi.getHeWeather5().get(0).getAqi().getCity().getAqi());
        PM25.setText(weatherAqi.getHeWeather5().get(0).getAqi().getCity().getPm25());
        wuran.setText(weatherAqi.getHeWeather5().get(0).getAqi().getCity().getQlty());
    }


    @Override
    public void run() {
        Aqi();
    }
}
