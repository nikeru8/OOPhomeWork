package com.hello.kaiser.homework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.hello.kaiser.homework.tool.CommunicationManager;
import com.hello.kaiser.homework.tool.RequestData;
import com.hello.kaiser.homework.model.Config;
import com.hello.kaiser.homework.model.ConfigManager;
import com.hello.kaiser.homework.model.SchedulesManager;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private TextView show;
    List<Config> dataList = new ArrayList<>();
    //api網址
    String mConfigUrl = "http://www.mocky.io/v2/59e6d2c00f00007704ee97b6";
    String mSchedules = "http://www.mocky.io/v2/59e6e7550f00005305ee97e6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initSet();

    }


    private void initView() {
        show = (TextView) findViewById(R.id.show_item);
    }

    private void initSet() {
        loadingConfig(mConfigUrl);
        loadingSchedules(mSchedules);
    }

    private void loadingConfig(String url) {
        //參數
        final RequestData requestData = new RequestData.Builder(url)
                .build();

        Log.d(TAG, "RequestData =" + requestData.getUrl() + "\n Params :" + requestData.getParameters());
        CommunicationManager.getInstance().post(this, requestData, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d(TAG, " onSuccess " + responseString.toString());
                ConfigManager getJsonFirst = CommunicationManager.covertObj(responseString, ConfigManager.class);
                Log.d(TAG, "確認Manager有抓取到東西 = " + getJsonFirst.getDatas().get(0).getDestination());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, " onFailure " + responseString + "\nthrowable =" + throwable);
                Toast.makeText(MainActivity.this, "responseString =" + responseString + "\n throwable =" + throwable, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void loadingSchedules(String url) {
        //參數
        final RequestData requestData = new RequestData.Builder(url)
                .build();

        Log.d(TAG, "RequestData =" + requestData.getUrl() + "\n Params :" + requestData.getParameters());
        CommunicationManager.getInstance().post(this, requestData, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d(TAG, " onSuccess " + responseString.toString());
                SchedulesManager getJsonFirst = CommunicationManager.covertObj(responseString, SchedulesManager.class);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, " onFailure " + responseString + "\nthrowable =" + throwable);
                Toast.makeText(MainActivity.this, "responseString =" + responseString + "\n throwable =" + throwable, Toast.LENGTH_SHORT).show();

            }
        });
    }

}
