package Tread;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import utils.WeatherForecast;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class HttpThreadForecast extends Thread{
    private Context context;
    private String url;
    private Handler handler;
    private ImageView todayimg;
    private ImageView tomorrwimg;
    private ImageView afterimg;
    private TextView todaytxt;
    private TextView tomorrwtxt;
    private TextView aftertxt;
    private TextView todaytmpcha;
    private TextView tomorrowtmpcha;
    private TextView afterdaytmpcha;
    String[] code={"999","100","101","102","103","104","200","201","202","203","204","205","206","207","208","209","210","211","212","213","300","301","302","303","304",
            "305","306","307","308","309","310","311","312","313","400","401","402","403","404","405","406","407","500","501","502","503","504","507",
            "508","900","901","999"};
    int[] imgcode=new int[]{R.drawable.a100,R.drawable.a101,R.drawable.a102,R.drawable.a103,R.drawable.a104,R.drawable.a200,R.drawable.a201,R.drawable.a202,R.drawable.a203,R.drawable.a204,
            R.drawable.a205,R.drawable.a206,R.drawable.a207,R.drawable.a208,R.drawable.a209,R.drawable.a210,R.drawable.a211,R.drawable.a212,R.drawable.a213,
            R.drawable.a300,R.drawable.a301,R.drawable.a302,R.drawable.a303,R.drawable.a304,R.drawable.a305,R.drawable.a306,R.drawable.a307,R.drawable.a308,R.drawable.a309,
            R.drawable.a310,R.drawable.a311,R.drawable.a312,R.drawable.a313,R.drawable.a400,R.drawable.a401,R.drawable.a402,R.drawable.a403,R.drawable.a404,R.drawable.a405,
            R.drawable.a406,R.drawable.a407,R.drawable.a500,R.drawable.a501,R.drawable.a502,R.drawable.a503,R.drawable.a504,R.drawable.a507,R.drawable.a508,
            R.drawable.a900,R.drawable.a901,R.drawable.a999,};


    public HttpThreadForecast(Context context,String url, Handler handler, ImageView todayimg, ImageView tomorrwimg, ImageView afterimg, TextView todaytxt, TextView tomorrwtxt, TextView aftertxt, TextView todaytmpcha, TextView tomorrowtmpcha, TextView afterdaytmpcha) {
        this.context=context;
        this.url = url;
        this.handler = handler;
        this.todayimg = todayimg;
        this.tomorrwimg = tomorrwimg;
        this.afterimg = afterimg;
        this.todaytxt = todaytxt;
        this.tomorrwtxt = tomorrwtxt;
        this.aftertxt = aftertxt;
        this.todaytmpcha = todaytmpcha;
        this.tomorrowtmpcha = tomorrowtmpcha;
        this.afterdaytmpcha = afterdaytmpcha;
    }

    private void Forecast(){
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
                        jsonForecast(sb);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    private void jsonForecast(StringBuffer json){
        Gson gson=new Gson();
        WeatherForecast weatherForecast=gson.fromJson(json.toString(),WeatherForecast.class);

            String code1=weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(0).getCond().getCode_d();
            int i=0;
            while (!code[i].equals(code1)){
                //Log.i("zlj", String.valueOf(code1.equals(code[i])));
                i++;
                if (code[i].equals(code1)){
                    todayimg.setImageResource(imgcode[i-1]);
                }
            }

            String code2=weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(1).getCond().getCode_d();
            int z=0;
            while (!code[z].equals(code2)){
                //Log.i("zljj", String.valueOf(code2.equals(code[z])));
                z++;
                if (code[z].equals(code2)){
                    tomorrwimg.setImageResource(imgcode[z-1]);
                }
            }


            String code3= weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(2).getCond().getCode_d();
            int j=0;
            while (!code[j].equals(code3)){
                // Log.i("zljjjjjjjjj", String.valueOf(code3.equals(code[j])));
                j++;
                if (code[j].equals(code3)){
                    afterimg.setImageResource(imgcode[j-1]);
                }
            }
            todaytxt.setText(weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(0).getCond().getTxt_d());
            tomorrwtxt.setText(weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(1).getCond().getTxt_d());
            aftertxt.setText(weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(2).getCond().getTxt_d());

            String todaycha=weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(0).getTmp().getMax()+"°"+"/"+
                    weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(0).getTmp().getMin()+"°";
            todaytmpcha.setText(todaycha);
            String tomorrowcha=weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(1).getTmp().getMax()+"°"+"/"+
                    weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(1).getTmp().getMin()+"°";
            tomorrowtmpcha.setText(tomorrowcha);
            String aftercha=weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(2).getTmp().getMax()+"°"+"/"+
                    weatherForecast.getHeWeather5().get(0).getDaily_forecast().get(2).getTmp().getMin()+"°";
            afterdaytmpcha.setText(aftercha);

    }



    @Override
    public void run() {
        Forecast();
    }


}
