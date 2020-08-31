package com.fhx.property.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.fhx.property.base.BaseBean;

public class AssignedBean extends BaseBean implements MultiItemEntity {
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_ITEM = 2;
    private int  itemType;

    private String header;

    private String name;

    private int isChoose;

    public AssignedBean(int itemType, String header) {
        this.itemType = itemType;
        this.header = header;
    }

    public AssignedBean(int itemType, String name, int isChoose) {
        this.itemType = itemType;
        this.name = name;
        this.isChoose = isChoose;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(int isChoose) {
        this.isChoose = isChoose;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }


}
