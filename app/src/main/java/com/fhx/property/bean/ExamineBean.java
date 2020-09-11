package com.fhx.property.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.fhx.property.base.BaseBean;

public class ExamineBean extends BaseBean implements MultiItemEntity {

    public static final int TYPE_LEAVE = 1;
    public static final int TYPE_CARD = 2;

    private int itemType;

    private String  title;

    private String commitTime;

    private String leaveType;

    private String startTime;
    private String endTime;

    private int progress;

    private String  cardTime;

    public ExamineBean(int itemType,String title, String commitTime, String leaveType, String startTime, String endTime, int progress) {
        this.itemType = itemType;
        this.title = title;
        this.commitTime = commitTime;
        this.leaveType = leaveType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.progress = progress; //处理进度 0 审批中  1通过  2退回
    }

    public ExamineBean(int itemType, String title, String commitTime, String cardTime, int progress) {
        this.itemType = itemType;
        this.title = title;
        this.commitTime = commitTime;
        this.progress = progress;
        this.cardTime = cardTime;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
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

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
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

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getCardTime() {
        return cardTime;
    }

    public void setCardTime(String cardTime) {
        this.cardTime = cardTime;
    }
}
