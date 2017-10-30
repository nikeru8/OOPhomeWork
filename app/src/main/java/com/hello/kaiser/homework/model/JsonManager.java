package com.hello.kaiser.homework.model;

import android.content.Context;
import android.util.Log;

import com.hello.kaiser.homework.tool.CommunicationManager;
import com.hello.kaiser.homework.tool.RequestData;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by kaiser on 2017/10/27.
 */

public abstract class JsonManager {

    private static final String TAG = "JsonManager";

    private String mResponse;

    public abstract String ProcessJsonConfig(Context context);

    public String getJsonObject(Context context, String url) {
        //參數
        final RequestData requestData = new RequestData.Builder(url)
                .build();

        Log.d(TAG, "RequestData =" + requestData.getUrl() + "\n Params :" + requestData.getParameters());
        CommunicationManager.getInstance().post(context, requestData, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d(TAG, " onSuccess " + responseString.toString());
                mResponse = responseString;
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, " onFailure " + responseString + "\nthrowable =" + throwable);
                mResponse = "";
            }
        });
        return mResponse;
    }

}
