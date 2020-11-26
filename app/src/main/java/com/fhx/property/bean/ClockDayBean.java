package com.fhx.property.bean;

import java.util.List;

public class ClockDayBean {


    /**
     * success : true
     * data : {"listRecords":[{"checkType":"am","isworkday":"true","checktime":"2020-11-10 08:05:00","employeeId":"cf447d13e84bded911c596e48fe0ee8a","attendId":"2c85a140b7f1460f8a3c9a8e717b51fc","checkResult":"late","checkday":"2020-11-10"},{"checkType":"pm","isworkday":"true","checktime":"2020-11-10 16:05:00","employeeId":"cf447d13e84bded911c596e48fe0ee8a","attendId":"81d6de7bcea4447885ba18badf9a0836","checkResult":"early","checkday":"2020-11-10"},{"checkType":"am","isworkday":"true","checktime":"2020-11-11 09:39:18","employeeId":"cf447d13e84bded911c596e48fe0ee8a","attendId":"77eda499572542c995a747b3b0517ecf","checkResult":"late","checkday":"2020-11-11"},{"checkType":"pm","isworkday":"true","checktime":"2020-11-11 15:53:23","employeeId":"cf447d13e84bded911c596e48fe0ee8a","attendId":"7cad0d4f59594030b655743fd35f3942","checkResult":"early","checkday":"2020-11-11"}],"listDays":[{"date":"2020-11-01","type":"restday"},{"date":"2020-11-02","type":"workday"},{"date":"2020-11-03","type":"workday"},{"date":"2020-11-04","type":"workday"},{"date":"2020-11-05","type":"workday"},{"date":"2020-11-06","type":"workday"},{"date":"2020-11-07","type":"restday"},{"date":"2020-11-08","type":"restday"},{"date":"2020-11-09","type":"workday"},{"date":"2020-11-10","type":"workday"},{"date":"2020-11-11","type":"workday"},{"date":"2020-11-12","type":"workday"},{"date":"2020-11-13","type":"workday"},{"date":"2020-11-14","type":"restday"},{"date":"2020-11-15","type":"restday"},{"date":"2020-11-16","type":"workday"},{"date":"2020-11-17","type":"workday"},{"date":"2020-11-18","type":"workday"},{"date":"2020-11-19","type":"workday"},{"date":"2020-11-20","type":"workday"},{"date":"2020-11-21","type":"restday"},{"date":"2020-11-22","type":"restday"},{"date":"2020-11-23","type":"workday"},{"date":"2020-11-24","type":"workday"},{"date":"2020-11-25","type":"workday"},{"date":"2020-11-26","type":"workday"},{"date":"2020-11-27","type":"workday"},{"date":"2020-11-28","type":"restday"},{"date":"2020-11-29","type":"restday"},{"date":"2020-11-30","type":"workday"},{"date":"2020-12-01","type":"workday"}]}
     */

    private boolean success;
    private DataBean data;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ListRecordsBean> listRecords;
        private List<ListDaysBean> listDays;

        public List<ListRecordsBean> getListRecords() {
            return listRecords;
        }

        public void setListRecords(List<ListRecordsBean> listRecords) {
            this.listRecords = listRecords;
        }

        public List<ListDaysBean> getListDays() {
            return listDays;
        }

        public void setListDays(List<ListDaysBean> listDays) {
            this.listDays = listDays;
        }

        public static class ListRecordsBean {
            /**
             * checkType : am
             * isworkday : true
             * checktime : 2020-11-10 08:05:00
             * employeeId : cf447d13e84bded911c596e48fe0ee8a
             * attendId : 2c85a140b7f1460f8a3c9a8e717b51fc
             * checkResult : late
             * checkday : 2020-11-10
             */

            private String checkType;
            private String isworkday;
            private String checktime;
            private String employeeId;
            private String attendId;
            private String checkResult;
            private String checkday;

            public String getCheckType() {
                return checkType;
            }

            public void setCheckType(String checkType) {
                this.checkType = checkType;
            }

            public String getIsworkday() {
                return isworkday;
            }

            public void setIsworkday(String isworkday) {
                this.isworkday = isworkday;
            }

            public String getChecktime() {
                return checktime;
            }

            public void setChecktime(String checktime) {
                this.checktime = checktime;
            }

            public String getEmployeeId() {
                return employeeId;
            }

            public void setEmployeeId(String employeeId) {
                this.employeeId = employeeId;
            }

            public String getAttendId() {
                return attendId;
            }

            public void setAttendId(String attendId) {
                this.attendId = attendId;
            }

            public String getCheckResult() {
                return checkResult;
            }

            public void setCheckResult(String checkResult) {
                this.checkResult = checkResult;
            }

            public String getCheckday() {
                return checkday;
            }

            public void setCheckday(String checkday) {
                this.checkday = checkday;
            }
        }

        public static class ListDaysBean {
            /**
             * date : 2020-11-01
             * type : restday
             */

            private String date;
            private String type;
            private String holidayname;
            private String holidayid;

            public String getHolidayname() {
                return holidayname;
            }

            public void setHolidayname(String holidayname) {
                this.holidayname = holidayname;
            }

            public String getHolidayid() {
                return holidayid;
            }

            public void setHolidayid(String holidayid) {
                this.holidayid = holidayid;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
