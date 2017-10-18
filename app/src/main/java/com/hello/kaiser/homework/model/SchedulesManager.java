package com.hello.kaiser.homework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kaiser on 2017/10/18.
 */

public class SchedulesManager implements Serializable {
    @SerializedName("schedules")
    private List<Schedules> schedules;

    public List<Schedules> getSchedules() {
        return schedules;
    }
}
