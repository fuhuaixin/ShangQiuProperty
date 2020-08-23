package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

public class FaultNotifiBean extends BaseBean {
    private String title;
    private String address;
    private String time;
    private int progress; // 0未指派  1 处理中 2已完成

    public FaultNotifiBean(String title, String address, String time, int progress) {
        this.title = title;
        this.address = address;
        this.time = time;
        this.progress = progress;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
