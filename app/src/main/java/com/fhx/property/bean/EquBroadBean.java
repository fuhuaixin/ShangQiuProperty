package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

public class EquBroadBean extends BaseBean {

    private String title;


    private String music;

    private int  status;

    private String address;
    private double waterLevel;

    private String mode;

    /*pump参数*/
    public EquBroadBean(String title, String address, int status, double waterLevel) {
        this.title = title;
        this.address = address;
        this.status = status;
        this.waterLevel = waterLevel;
    }

    /*fresh参数*/
    public EquBroadBean(String title, String address, int status, String mode) {
        this.title = title;
        this.address = address;
        this.status = status;
        this.mode = mode;
    }

    public EquBroadBean(String title, String music, int status) {
        this.title = title;
        this.music = music;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
