package com.example.weather;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.List;

import Tread.HttpThreadAqi;
import Tread.HttpThreadForecast;
import Tread.HttpThreadSuggestion;
import Tread.HttpThreadWeather;

import static com.example.weather.R.string.weather;

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    private TextView textTest;
    private TextView dushu;
    private TextView location;
    private TextView locationWeather;
    private TextView wind;
    private TextView windLevel;
    private TextView shidu;
    private TextView body;
    private TextView fabu;

    private TextView wuran;
    private TextView aqi;
    private TextView PM25;

    private ImageView todayimg;
    private ImageView tomorrwimg;
    private ImageView afterimg;
    private TextView todaytxt;
    private TextView tomorrwtxt;
    private TextView aftertxt;
    private TextView todaytmpcha;
    private TextView tomorrowtmpcha;
    private TextView afterdaytmpcha;
    private Handler handler=new Handler();
    private View view;
    private LinearLayout suggest;
    private LinearLayout addView;

    private TextView clothe;
    private TextView clothes;
    private TextView sport;
    private TextView sports;
    private TextView comfortable;
    private TextView comfortables;
    private TextView travel;
    private TextView travels;

    private ProgressBar pro;
    private FloatingActionButton fab;
    private SwipeRefreshLayout SR;
    private ScrollView scrollView;
    private TextView load;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.colorblue);//通知栏所需颜色
        setContentView(R.layout.activity_main);
        initView();
        pro.bringToFront();
        pro.setVisibility(View.VISIBLE);
        load.setVisibility(View.VISIBLE);
        HttpThread();
        SR.setColorSchemeResources(R.color.colorblue,R.color.colorgreen,R.color.colorwrite);
        SR.setOnRefreshListener(this);
        if(scrollView!=null){
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    SR.setEnabled(scrollView.getScrollY() == 0);
                }
            });
        }



    }

    private void initView() {
        //textTest= (TextView) findViewById(R.id.test);
        dushu = (TextView) findViewById(R.id.dushu);
        location = (TextView) findViewById(R.id.location);
        locationWeather = (TextView) findViewById(R.id.locationweahter);
        wind = (TextView) findViewById(R.id.wind);
        windLevel= (TextView) findViewById(R.id.windLevle);
        shidu = (TextView) findViewById(R.id.shidu);
        body = (TextView) findViewById(R.id.body);
        fabu = (TextView) findViewById(R.id.fabu);
        todayimg = (ImageView) findViewById(R.id.TodayImg);
        tomorrwimg = (ImageView) findViewById(R.id.TomorrowImg);
        afterimg = (ImageView) findViewById(R.id.AfterDayImg);
        todaytxt = (TextView) findViewById(R.id.TodayTxt);
        tomorrwtxt = (TextView) findViewById(R.id.TomorrowTxt);
        aftertxt = (TextView) findViewById(R.id.AfterDayTxt);
        todaytmpcha = (TextView) findViewById(R.id.todaytmpcha);
        tomorrowtmpcha = (TextView) findViewById(R.id.tomorrowtmpcha);
        afterdaytmpcha = (TextView) findViewById(R.id.afterdaytmpcha);
        wuran = (TextView) findViewById(R.id.wuran);
        aqi = (TextView) findViewById(R.id.aqi);
        PM25 = (TextView) findViewById(R.id.PM25);


        view= LayoutInflater.from(this).inflate(R.layout.suggest,null);
        suggest= (LinearLayout) view.findViewById(R.id.suggest);
        addView= (LinearLayout) findViewById(R.id.addview);
        addView.addView(suggest);

        clothe= (TextView) suggest.findViewById(R.id.clothe);
        clothes = (TextView) suggest.findViewById(R.id.clothes);
        sport = (TextView) suggest.findViewById(R.id.sport);
        sports = (TextView) suggest.findViewById(R.id.sports);
        comfortable = (TextView) suggest.findViewById(R.id.comfortable);
        comfortables = (TextView) suggest.findViewById(R.id.comfortables);
        travel = (TextView) suggest.findViewById(R.id.travel);
        travels = (TextView) suggest.findViewById(R.id.travels);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        pro = (ProgressBar) findViewById(R.id.pro);
        SR = (SwipeRefreshLayout) findViewById(R.id.SR);
        scrollView= (ScrollView) findViewById(R.id.Scrol);
        load = (TextView) findViewById(R.id.load);

    }

    //沉浸式导航栏
    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    private void HttpThread(){

        String dailyurl="https://free-api.heweather.com/v5/now?city=xinxiang&key=fe38bea187194e6fa8c42e96dd4f6d3a";
        String forecasturl="https://free-api.heweather.com/v5/forecast?city=xinxiang&key=fe38bea187194e6fa8c42e96dd4f6d3a";
        String aqiurl="https://free-api.heweather.com/v5/weather?city=xinxiang&key=fe38bea187194e6fa8c42e96dd4f6d3a";
        String suggesturl="https://free-api.heweather.com/v5/suggestion?city=xinxiang&key=fe38bea187194e6fa8c42e96dd4f6d3a";
        Tread.HttpThreadWeather weather=new Tread.HttpThreadWeather(dailyurl,handler,textTest,dushu,location,locationWeather,wind,windLevel,shidu,body,fabu,pro,SR,load);
        HttpThreadForecast forecast=new HttpThreadForecast(MainActivity.this,forecasturl,handler,todayimg,tomorrwimg,afterimg,todaytxt,tomorrwtxt,aftertxt,todaytmpcha,tomorrowtmpcha,afterdaytmpcha);
        HttpThreadAqi weatherAqi=new HttpThreadAqi(aqiurl,handler,wuran,aqi,PM25);
        HttpThreadSuggestion suggestion=new HttpThreadSuggestion(suggesturl,handler,clothe,clothes,sport,sports,comfortable,comfortables,travel,travels);

        forecast.start();
        weatherAqi.start();
        suggestion.start();
        weather.start();
//        Message msg=handler.obtainMessage();
//        if (msg.getData().getString("forecast")!=null){
//             SR.setRefreshing(false);
//             pro.setVisibility(View.GONE);
//          }else {
//            pro.setVisibility(View.VISIBLE);
//        }
    }

    @Override
    public void onRefresh() {
        Log.i("ppppppp", "onRefresh: ");
        SR.setRefreshing(true);
        HttpThread();
    }
}
