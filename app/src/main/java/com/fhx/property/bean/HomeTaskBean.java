package com.fhx.property.bean;

public class HomeTaskBean {

    private String title;

    private String msg;

    private String time;

    private int state; //状态  1是进行中 0是已完成

    public HomeTaskBean(String title, String msg, String time, int state) {
        this.title = title;
        this.msg = msg;
        this.time = time;
        this.state = state;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
