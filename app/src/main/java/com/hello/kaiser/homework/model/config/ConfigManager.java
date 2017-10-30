package com.hello.kaiser.homework.model.config;

import android.content.Context;

import com.google.gson.annotations.SerializedName;
import com.hello.kaiser.homework.model.JsonManager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kaiser on 2017/10/18.
 */

public class ConfigManager extends JsonManager implements Serializable {

    private static final String TAG = ConfigManager.class.getSimpleName();

    //api網址
    String mConfigUrl = "http://www.mocky.io/v2/59e6d2c00f00007704ee97b6";


    @SerializedName("config")
    private List<Config> datas;

    public List<Config> getDatas() {
        return datas;
    }

    @Override
    public String ProcessJsonConfig(Context context) {
        return getJsonObject(context, mConfigUrl);
    }


}
