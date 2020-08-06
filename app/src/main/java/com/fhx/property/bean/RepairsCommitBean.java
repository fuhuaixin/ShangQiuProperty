package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;


public class RepairsCommitBean extends BaseBean {

    private String msg;

    private String type;

    private String room;

    private int status; // 1 已提交  2 处理中  3 已完成但未评价 4 已完成已评价

    public RepairsCommitBean(String msg, String type, String room, int status) {
        this.msg = msg;
        this.type = type;
        this.room = room;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
