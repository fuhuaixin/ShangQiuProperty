package com.fhx.property.bean;

import java.util.List;

public class HomeTaskBean {


    /**
     * data : [{"beginTime":"2020-12-08 15:25:05","processId":"242512","processName":"报修工单","startTime":"2020-12-08 15:21:54","status":"3","updateTime":"2020-12-08 15:25:05"},{"beginTime":"2020-12-08 16:30:02","processId":"242501","processName":"报修工单","startTime":"2020-12-08 15:21:29","status":"3","updateTime":"2020-12-08 16:30:02"},{"processId":"292525","processName":"投诉工单","startTime":"2020-12-15 10:57:17","status":"1"},{"processId":"302501","processName":"投诉工单","startTime":"2020-12-15 14:10:19","status":"1"},{"processId":"240012","processName":"报修工单","startTime":"2020-12-08 14:39:44","status":"1"},{"processId":"240034","processName":"报修工单","startTime":"2020-12-08 14:46:52","status":"1"},{"processId":"240045","processName":"报修工单","startTime":"2020-12-08 15:05:15","status":"1"},{"processId":"240067","processName":"报修工单","startTime":"2020-12-08 15:18:13","status":"1"},{"processId":"247501","processName":"报修工单","startTime":"2020-12-09 14:06:25","status":"1"},{"processId":"247512","processName":"报修工单","startTime":"2020-12-09 14:11:22","status":"1"},{"beginTime":"2020-12-16 16:26:59","notes":"sdfs ","processId":"332501","processName":"手动工单","startTime":"2020-12-16 16:22:12","status":"3","updateTime":"2020-12-16 16:26:59"},{"processId":"295001","processName":"投诉工单","startTime":"2020-12-15 10:51:37","status":"1"},{"processId":"232539","processName":"报修工单","startTime":"2020-12-08 11:08:57","status":"1"},{"processId":"230034","processName":"报修工单","startTime":"2020-12-09 13:58:43","status":"0"},{"processId":"305001","processName":"投诉工单","startTime":"2020-12-15 14:23:56","status":"1"},{"beginTime":"2020-12-15 14:59:34","processId":"305023","processName":"投诉工单","startTime":"2020-12-15 14:24:27","status":"3","updateTime":"2020-12-15 14:59:34"},{"beginTime":"2020-12-08 11:12:14","processId":"232568","processName":"报修工单","startTime":"2020-12-08 11:11:19","status":"3","updateTime":"2020-12-08 11:12:14"}]
     * success : true
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
         * beginTime : 2020-12-08 15:25:05
         * processId : 242512
         * processName : 报修工单
         * startTime : 2020-12-08 15:21:54
         * status : 3
         * updateTime : 2020-12-08 15:25:05
         * notes : sdfs
         */

        private String beginTime;
        private String processId;
        private String processName;
        private String startTime;
        private String status;
        private String updateTime;
        private String notes;
        private String orderType;

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getProcessId() {
            return processId;
        }

        public void setProcessId(String processId) {
            this.processId = processId;
        }

        public String getProcessName() {
            return processName;
        }

        public void setProcessName(String processName) {
            this.processName = processName;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }
    }
}
