package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

public class LeaseListBean extends BaseBean {

    private String title ="";
    private String room ="";
    private String image ="";
    private String spaceId ="";

    public LeaseListBean(String title, String room,String spaceId) {
        this.title = title;
        this.room = room;
        this.spaceId = spaceId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
