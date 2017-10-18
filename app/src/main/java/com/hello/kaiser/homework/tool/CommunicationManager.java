package com.hello.kaiser.homework.tool;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * Created by kaiser on 2017/10/18.
 */
public class CommunicationManager {
    public static final String handle = CommunicationManager.class.getSimpleName();
    private static CommunicationManager instance = new CommunicationManager();//變成靜態
    private static AsyncHttpClient client = new AsyncHttpClient();

    static {
        client.setTimeout(10000);
        client.setResponseTimeout(10000);
        client.setEnableRedirects(true, true, true);
    }

    private CommunicationManager() {//要件
    }

    public static CommunicationManager getInstance() {//變成靜態用
        return instance;
    }

    public void post(Context context, RequestData RequestData, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.get(context, RequestData.getUrl(), RequestData.getHttpParams(), asyncHttpResponseHandler);
    }

    public static <T> T covertObj(String content, Class<T> classOfT) {
        Gson gson = new Gson();
        T obj = null;
        try {
            obj = gson.fromJson(content, classOfT);
        } catch (JsonSyntaxException e) {
            Log.d(handle, "Failed to convert gson:" + content);
            e.printStackTrace();
        }
        return obj;
    }

}
