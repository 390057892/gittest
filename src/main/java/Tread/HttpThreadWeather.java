package Tread;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import utils.WeatherDaily;
import utils.WeatherForecast;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class HttpThreadWeather extends Thread {

    private String url;
    private Handler handler;
    private TextView textTest;
    private TextView dushu;
    private TextView location;
    private TextView locationWeather;
    private TextView wind;
    private TextView windLevel;
    private TextView shidu;
    private TextView body;
    private TextView fabu;
    private ProgressBar pro;
    private SwipeRefreshLayout SR;
    private TextView load;

    public HttpThreadWeather(String url, Handler handler, TextView textTest, TextView dushu, TextView location, TextView locationWeather, TextView wind, TextView windLevel, TextView shidu, TextView body,TextView fabu,ProgressBar pro
                             ,SwipeRefreshLayout SR, TextView load) {
        this.url = url;
        this.handler = handler;
        this.textTest = textTest;
        this.dushu = dushu;
        this.location = location;
        this.locationWeather = locationWeather;
        this.wind = wind;
        this.windLevel = windLevel;
        this.shidu = shidu;
        this.body = body;
        this.fabu=fabu;
        this.pro=pro;
        this.SR=SR;
        this.load=load;
    }

    public void Weather(){
        try {
            URL httpUrl = new URL(url);
            try {
                HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
                conn.setRequestMethod("GET");
                conn.setReadTimeout(5000);
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer sb=new StringBuffer();
                String str;
                while ((str=reader.readLine())!=null){
                    sb.append(str);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        jsonWeather(sb);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    public void jsonWeather(StringBuffer json){
        Gson gson=new Gson();
        WeatherDaily weatherDaily=gson.fromJson(json.toString(),WeatherDaily.class);
        String du=weatherDaily.getHeWeather5().get(0).getNow().getTmp()+"°";
        dushu.setText(du);
        location.setText(weatherDaily.getHeWeather5().get(0).getBasic().getCity());
        String lo="/"+weatherDaily.getHeWeather5().get(0).getNow().getCond().getTxt();
        locationWeather.setText(lo);
        wind.setText(weatherDaily.getHeWeather5().get(0).getNow().getWind().getDir());
        String wi=weatherDaily.getHeWeather5().get(0).getNow().getWind().getSc()+"级";
        windLevel.setText(wi);
        String sh=weatherDaily.getHeWeather5().get(0).getNow().getHum()+"%";
        shidu.setText(sh);
        String bo=weatherDaily.getHeWeather5().get(0).getNow().getFl()+"°";
        body.setText(bo);
        String fa=weatherDaily.getHeWeather5().get(0).getBasic().getUpdate().getLoc()+"发布";
        fabu.setText(fa);
        pro.setVisibility(View.GONE);
        SR.setRefreshing(false);
        load.setVisibility(View.GONE);
        Log.i("qaq", "jsonWeather: ");
    }



    @Override
    public void run() {
        Weather();
    }

}
