package com.fhx.property.bean;

public class EquBroadBean {

    private String title;


    private String music;

    private int  status;

    public EquBroadBean(String title,  String music, int status) {
        this.title = title;
        this.music = music;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
