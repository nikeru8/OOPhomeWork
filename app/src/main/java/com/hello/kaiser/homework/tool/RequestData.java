package com.hello.kaiser.homework.tool;

import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

/**
 * Created by kaiser on 2017/10/18.
 */

public class RequestData {
    public static final String TAG = RequestData.class.getSimpleName();
    private Builder builder;

    private RequestData(Builder builder) {
        this.builder = builder;
    }

    public String getUrl() {
        return builder.url;
    }

    public List getParameters() {
        return builder.parameters;
    }

    public RequestParams getHttpParams() {
        RequestParams params = new RequestParams();
        for (int i = 0; i < getParameters().size(); i++) {
            NameValuePair pair = (NameValuePair) getParameters().get(i);
            params.add(pair.getName(), pair.getValue());
        }
        return params;
    }


    public static class Builder {

        String url;
        List parameters = new ArrayList<>();

        public Builder(String url) {
            this.url = url;
            parameters = new ArrayList<>();
        }

        public Builder addParameter(String name, String value) {
            BasicNameValuePair nameValuePair = new BasicNameValuePair(name, value);
            parameters.add(nameValuePair);
            return this;
        }

        public RequestData build() {
            return new RequestData(this);
        }
    }
}