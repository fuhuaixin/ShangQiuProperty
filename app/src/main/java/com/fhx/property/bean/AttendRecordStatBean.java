package com.fhx.property.bean;

import java.util.List;

public class AttendRecordStatBean {

    /**
     * success : true
     * data : [{"employeeName":"0002","deptName":"空水技工","countEarly":2,"deptId":"23f31ddf735875d51b7987fe34aac187","countLate":2,"employeeNo":"0002","countSignout":2,"employeeid":"cf447d13e84bded911c596e48fe0ee8a","countSign":3,"countSignin":3}]
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
         * employeeName : 0002
         * deptName : 空水技工
         * countEarly : 2
         * deptId : 23f31ddf735875d51b7987fe34aac187
         * countLate : 2
         * employeeNo : 0002
         * countSignout : 2  //下班打卡
         * employeeid : cf447d13e84bded911c596e48fe0ee8a
         * countSign : 3 //出勤天数
         * countSignin : 3 //上班打卡
         */

        private String employeeName;
        private String deptName;
        private int countEarly;
        private String deptId;
        private int countLate;
        private String employeeNo;
        private int countSignout;
        private String employeeid;
        private int countSign;
        private int countSignin;

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public int getCountEarly() {
            return countEarly;
        }

        public void setCountEarly(int countEarly) {
            this.countEarly = countEarly;
        }

        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public int getCountLate() {
            return countLate;
        }

        public void setCountLate(int countLate) {
            this.countLate = countLate;
        }

        public String getEmployeeNo() {
            return employeeNo;
        }

        public void setEmployeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
        }

        public int getCountSignout() {
            return countSignout;
        }

        public void setCountSignout(int countSignout) {
            this.countSignout = countSignout;
        }

        public String getEmployeeid() {
            return employeeid;
        }

        public void setEmployeeid(String employeeid) {
            this.employeeid = employeeid;
        }

        public int getCountSign() {
            return countSign;
        }

        public void setCountSign(int countSign) {
            this.countSign = countSign;
        }

        public int getCountSignin() {
            return countSignin;
        }

        public void setCountSignin(int countSignin) {
            this.countSignin = countSignin;
        }
    }
}
