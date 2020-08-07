package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

public class BroadDayChooseBean extends BaseBean {

    private String  title;

    private int  status;

    public BroadDayChooseBean(String title, int status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
