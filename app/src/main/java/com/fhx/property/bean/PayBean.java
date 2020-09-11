package com.fhx.property.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.fhx.property.base.BaseBean;

public class PayBean extends BaseBean implements MultiItemEntity {
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_ITEM = 2;
    private int  itemType;

    private String header;

    private String month;
    private int money;


    public PayBean(int itemType, String header) {
        this.itemType = itemType;
        this.header = header;
    }

    public PayBean(int itemType, String month, int money) {
        this.itemType = itemType;
        this.month = month;
        this.money = money;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }


}
