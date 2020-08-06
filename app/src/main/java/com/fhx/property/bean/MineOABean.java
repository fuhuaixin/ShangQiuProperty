package com.fhx.property.bean;

public class MineOABean {
    private int image;
    private String title;
    private int total;

    public MineOABean(int image, String title, int total) {
        this.image = image;
        this.title = title;
        this.total = total;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
