package com.hello.kaiser.homework.model.schedule;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kaiser on 2017/10/18.
 */

public class Schedules implements Serializable {

    @SerializedName("ext")//檔案形式
    private String ext;
    @SerializedName("time")//時間
    private String time;
    @SerializedName("interval")//定時
    private String interval;

    public Schedules(String ext, String time, String interval) {
        this.ext = ext;
        this.time = time;
        this.interval = interval;
    }

    public String getExt() {
        return ext;
    }

    public String getTime() {
        return time;
    }

    public String getInterval() {
        return interval;
    }
}
