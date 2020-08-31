package com.fhx.property.bean;

public class WriteLogBean {

    private String title;
    private String msg;
    private int image;

    public WriteLogBean(String title, String msg, int image) {
        this.title = title;
        this.msg = msg;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
