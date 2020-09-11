package com.fhx.property.bean;

public class LeaveBean {
    private int Image;
    private String title;
    private int remain;

    public LeaveBean(int image, String title, int remain) {
        Image = image;
        this.title = title;
        this.remain = remain;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }
}
