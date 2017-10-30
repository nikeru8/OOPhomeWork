package com.hello.kaiser.homework.model.schedule;

import android.content.Context;

import com.google.gson.annotations.SerializedName;
import com.hello.kaiser.homework.model.JsonManager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kaiser on 2017/10/18.
 */

public class SchedulesManager extends JsonManager implements Serializable {

    String mSchedules = "http://www.mocky.io/v2/59e6e7550f00005305ee97e6";

    @SerializedName("schedules")
    private List<Schedules> schedules;

    public List<Schedules> getSchedules() {
        return schedules;
    }

    @Override
    public String ProcessJsonConfig(Context context) {
        return getJsonObject(context, mSchedules);
    }
}
