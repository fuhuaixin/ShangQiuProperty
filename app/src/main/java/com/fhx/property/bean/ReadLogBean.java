package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

import java.util.List;

public class ReadLogBean extends BaseBean {

    private int headImage;
    private String title;
    private String time;
    private String msg;
    private List<String> images;

    public ReadLogBean( String title, String time, String msg, List<String> images) {
        this.title = title;
        this.time = time;
        this.msg = msg;
        this.images = images;
    }

    public int getHeadImage() {
        return headImage;
    }

    public void setHeadImage(int headImage) {
        this.headImage = headImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
