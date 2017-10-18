package com.hello.kaiser.homework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kaiser on 2017/10/18.
 */

public class ConfigManager implements Serializable {

    @SerializedName("config")
    private List<Config> datas;

    public List<Config> getDatas() {
        return datas;
    }
}
