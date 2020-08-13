package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

public class ContactsListBean extends BaseBean {

    private String branch;  //部门分支

    private int total; //人员总数

    private String name;
    private String job;
    private String tag; //主管标签
    private String phone;

    public ContactsListBean(String branch, String name, String job, String tag, String phone) {
        this.branch = branch;
        this.name = name;
        this.job = job;
        this.tag = tag;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ContactsListBean(String branch, int total) {
        this.branch = branch;
        this.total = total;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
