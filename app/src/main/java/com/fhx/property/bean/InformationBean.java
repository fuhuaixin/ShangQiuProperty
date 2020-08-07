package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

public class InformationBean extends BaseBean {

    private int status;

    private String  title;

    private String useTime;

    public InformationBean(int status, String title, String useTime) {
        this.status = status;
        this.title = title;
        this.useTime = useTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }
}
