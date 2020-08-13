package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

public class CarManageBean extends BaseBean {

    private String carNum;

    private String carOwner; //车主

    private String room;

    public CarManageBean(String carNum, String carOwner, String room) {
        this.carNum = carNum;
        this.carOwner = carOwner;
        this.room = room;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
