package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

public class NotifyListBean extends BaseBean {

    private String title;
    private String msg;
    private String time;
    private String job;
    private String image;

    public NotifyListBean(String title, String msg, String time, String job) {
        this.title = title;
        this.msg = msg;
        this.time = time;
        this.job = job;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
