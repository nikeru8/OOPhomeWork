package com.hello.kaiser.homework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kaiser on 2017/10/18.
 */

public class Config implements Serializable {

    @SerializedName("ext")//設定檔案格式
    private String ext;
    @SerializedName("location")//設定要備份檔案的目錄
    private String location;
    @SerializedName("subDirectory")//是否處理子目錄 true false
    private boolean subDirectory;
    @SerializedName("unit")//設定備份單位file : 以單一檔案為處理單位； directory : 以整 個目錄為處理單位
    private String unit;
    @SerializedName("remove")//處理完是否刪除檔案， true : 刪除； false : 不刪除
    private String remove;
    @SerializedName("handler") //zip : 壓縮； encode : 加密
    private String handler;
    @SerializedName("destination")//處理後要儲存到什麼地方， directory : 目錄； db : 資料 庫
    private String destination;
    @SerializedName("dir")// 處理後的目錄
    private String dir;
    @SerializedName("connectionString")// 設定資料庫連接字串
    private String connectionString;

    public Config(String ext, String location, boolean subDirectory, String unit, String remove,
                  String handler, String destination, String dir, String connectionString) {
        this.ext = ext;
        this.location = location;
        this.subDirectory = subDirectory;
        this.unit = unit;
        this.remove = remove;
        this.handler = handler;
        this.destination = destination;
        this.dir = dir;
        this.connectionString = connectionString;
    }

    public String getExt() {
        return ext;
    }

    public String getLocation() {
        return location;
    }

    public boolean isSubDirectory() {
        return subDirectory;
    }

    public String getUnit() {
        return unit;
    }

    public String getRemove() {
        return remove;
    }

    public String getHandler() {
        return handler;
    }

    public String getDestination() {
        return destination;
    }

    public String getDir() {
        return dir;
    }

    public String getConnectionString() {
        return connectionString;
    }
}
