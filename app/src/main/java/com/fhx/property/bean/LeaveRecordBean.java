package com.fhx.property.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.fhx.property.base.BaseBean;

public class LeaveRecordBean extends BaseBean implements MultiItemEntity {
    public static final int Header = 1;
    public static final int Item = 2;

    private int imageHeader;
    private String title;
    private String commitTime;
    private String startTime;
    private String endTime;
    private String  eventType; //事件类型 1
    private int progress; //处理进度 0 审批中  1通过  2退回
    private int itemType;//多布局

    public LeaveRecordBean(int itemType,String title, String commitTime, String startTime, String endTime, String eventType, int progress) {
        this.itemType = itemType;
        this.title = title;
        this.commitTime = commitTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventType = eventType;
        this.progress = progress;
    }

    public int getImageHeader() {
        return imageHeader;
    }

    public void setImageHeader(int imageHeader) {
        this.imageHeader = imageHeader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(String commitTime) {
        this.commitTime = commitTime;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
