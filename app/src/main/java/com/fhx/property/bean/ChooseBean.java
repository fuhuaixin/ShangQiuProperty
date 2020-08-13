package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

public class ChooseBean extends BaseBean {
    private String title;

    private int isChoose;

    public ChooseBean(String title, int isChoose) {
        this.title = title;
        this.isChoose = isChoose;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(int isChoose) {
        this.isChoose = isChoose;
    }
}
