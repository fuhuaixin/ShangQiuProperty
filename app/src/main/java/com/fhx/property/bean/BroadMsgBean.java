package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

import java.util.List;

public class BroadMsgBean extends BaseBean {

    private int isOpen;

    private String broadType;

    private String broadTitle;

    private String startTime;

    private String endTime;

    private List<String> repetitionList;

    public BroadMsgBean(int isOpen, String broadType, String broadTitle, String startTime, String endTime, List<String> repetitionList) {
        this.isOpen = isOpen;
        this.broadType = broadType;
        this.broadTitle = broadTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.repetitionList = repetitionList;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    public String getBroadType() {
        return broadType;
    }

    public void setBroadType(String broadType) {
        this.broadType = broadType;
    }

    public String getBroadTitle() {
        return broadTitle;
    }

    public void setBroadTitle(String broadTitle) {
        this.broadTitle = broadTitle;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> getRepetitionList() {
        return repetitionList;
    }

    public void setRepetitionList(List<String> repetitionList) {
        this.repetitionList = repetitionList;
    }
}
