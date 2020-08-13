package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

public class ReminderListBean extends BaseBean {

    private String title;

    private String price;

    private String room;
    private int isPay; //0未缴 1已缴

    public ReminderListBean(String title, String price, String room,int isPay) {
        this.title = title;
        this.price = price;
        this.room = room;
        this.isPay = isPay;
    }

    public int getIsPay() {
        return isPay;
    }

    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
