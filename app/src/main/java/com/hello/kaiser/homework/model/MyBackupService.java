package com.hello.kaiser.homework.model;

import com.hello.kaiser.homework.model.config.ConfigManager;
import com.hello.kaiser.homework.model.schedule.SchedulesManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser on 2017/10/27.
 */

public class MyBackupService {
    private List<JsonManager> managers = new ArrayList<>();

    public MyBackupService() {
        managers.add(new ConfigManager());
        managers.add(new SchedulesManager());
    }

    public List<JsonManager> ProgressJsonConfigs() {
        return managers;
    }

}

















