package com.fhx.property.bean;

import java.util.List;

public class ContactsThirdBean {


    /**
     * success : true
     * data : [{"employeeName":"客服","employeeId":"f7e725ffbe9d96f452327e7fc5910912"},{"employeeName":"部门经理","employeeId":"f7e725ffbe9d96f452327e7fc5910913"},{"employeeName":"部门领导","employeeId":"f7e725ffbe9d96f452327e7fc5910914"},{"employeeName":"菲仕乐","employeeId":"f7e725ffbe9d96f454327e7fc5910911"}]
     */

    private boolean success;
    private List<DataBean> data;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * employeeName : 客服
         * employeeId : f7e725ffbe9d96f452327e7fc5910912
         */

        private String employeeName;
        private String employeeId;
        private String phone;
        private String employeeNo;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmployeeNo() {
            return employeeNo;
        }

        public void setEmployeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }
    }
}
