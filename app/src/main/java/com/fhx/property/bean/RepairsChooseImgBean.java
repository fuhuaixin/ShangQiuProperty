package com.fhx.property.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class RepairsChooseImgBean implements MultiItemEntity {


    //item类型
    private int fieldType;
    private int chooseImage;
    private String image;

    public RepairsChooseImgBean(int fieldType, int chooseImage, String image) {
        this.fieldType = fieldType;
        this.chooseImage = chooseImage;
        this.image = image;
    }

    public int getFieldType() {
        return fieldType;
    }

    public int getChooseImage() {
        return chooseImage;
    }

    public void setChooseImage(int chooseImage) {
        this.chooseImage = chooseImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setFieldType(int fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public int getItemType() {
        return fieldType;
    }
}
