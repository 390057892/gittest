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

import utils.WeatherSuggestion;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class HttpThreadSuggestion extends Thread {

    private String url;
    private Handler handler;
    private TextView clothe;
    private TextView clothes;
    private TextView sport;
    private TextView sports;
    private TextView comfortable;
    private TextView comfortables;
    private TextView travel;
    private TextView travels;

    public HttpThreadSuggestion(String url, Handler handler, TextView clothe, TextView clothes, TextView sport, TextView sports, TextView comfortable, TextView comfortables, TextView travel, TextView travels) {
        this.url = url;
        this.handler = handler;
        this.clothe = clothe;
        this.clothes = clothes;
        this.sport = sport;
        this.sports = sports;
        this.comfortable = comfortable;
        this.comfortables = comfortables;
        this.travel = travel;
        this.travels = travels;
    }

    public void Suggest(){
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
                        jsonSuggest(sb);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void jsonSuggest(StringBuffer json){
        Gson gson=new Gson();
        WeatherSuggestion weatherSuggestion=gson.fromJson(json.toString(),WeatherSuggestion.class);
        clothe.setText(weatherSuggestion.getHeWeather5().get(0).getSuggestion().getDrsg().getBrf());
        clothes.setText(weatherSuggestion.getHeWeather5().get(0).getSuggestion().getDrsg().getTxt());
        sport.setText(weatherSuggestion.getHeWeather5().get(0).getSuggestion().getSport().getBrf());
        sports.setText(weatherSuggestion.getHeWeather5().get(0).getSuggestion().getSport().getTxt());
        comfortable.setText(weatherSuggestion.getHeWeather5().get(0).getSuggestion().getComf().getBrf());
        comfortables.setText(weatherSuggestion.getHeWeather5().get(0).getSuggestion().getComf().getTxt());
        travel.setText(weatherSuggestion.getHeWeather5().get(0).getSuggestion().getTrav().getBrf());
        travels.setText(weatherSuggestion.getHeWeather5().get(0).getSuggestion().getTrav().getTxt());

    }

    @Override
    public void run() {
        Suggest();
    }
}
