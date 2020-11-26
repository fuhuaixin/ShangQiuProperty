package com.fhx.property.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.fhx.property.base.BaseBean;

import java.util.List;

public class LeaveRecordBean extends BaseBean  {


    /**
     * success : true
     * data : {"records":[{"sheetId":"11cd76535fc64f51a1f1db479d77a113","sheetNo":"LEAVE-NO-7AF1-B7A2","starter":"zhangsan","starterName":"zhangsan","starttime":"2020-11-10 10:21:58","sheetStatus":"3","begintime":"2020-11-07 10:21:37","endtime":"2020-12-05 10:21:40","leaveType":"1","mark":null,"flowContent":null,"isdeleted":"0","updatetime":null,"processId":"165007","operation":"commit","leader":"18538323050","leaderMark":null,"manager":null,"managerMark":null,"result":null,"duration":null},{"sheetId":"38445b41870f41de85723a7c75ef3aa6","sheetNo":"LEAVE-NO-FE8F-18AC","starter":"zhangsan","starterName":"zhangsan","starttime":"2020-11-03 14:28:49","sheetStatus":"4","begintime":"2020-11-03 14:28:37","endtime":"2020-11-10 14:28:43","leaveType":"2","mark":null,"flowContent":null,"isdeleted":"0","updatetime":"2020-11-03 14:29:11","processId":"130001","operation":"commit","leader":"18538323050","leaderMark":null,"manager":null,"managerMark":null,"result":"1","duration":"6"},{"sheetId":"6723d0644703462e82786a4be01f9127","sheetNo":"1604988248965","starter":null,"starterName":null,"starttime":"2020-11-10 14:04:15","sheetStatus":"3","begintime":"2020-10-11 14:00:00","endtime":"2020-10-12 15:00:00","leaveType":"病假","mark":"我的评价机油","flowContent":null,"isdeleted":"0","updatetime":null,"processId":"167501","operation":"commit","leader":"18538323050","leaderMark":null,"manager":null,"managerMark":null,"result":null,"duration":null}],"total":9,"size":3,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":3}
     */

    private boolean success;
    private DataBean data;

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
        /**
         * records : [{"sheetId":"11cd76535fc64f51a1f1db479d77a113","sheetNo":"LEAVE-NO-7AF1-B7A2","starter":"zhangsan","starterName":"zhangsan","starttime":"2020-11-10 10:21:58","sheetStatus":"3","begintime":"2020-11-07 10:21:37","endtime":"2020-12-05 10:21:40","leaveType":"1","mark":null,"flowContent":null,"isdeleted":"0","updatetime":null,"processId":"165007","operation":"commit","leader":"18538323050","leaderMark":null,"manager":null,"managerMark":null,"result":null,"duration":null},{"sheetId":"38445b41870f41de85723a7c75ef3aa6","sheetNo":"LEAVE-NO-FE8F-18AC","starter":"zhangsan","starterName":"zhangsan","starttime":"2020-11-03 14:28:49","sheetStatus":"4","begintime":"2020-11-03 14:28:37","endtime":"2020-11-10 14:28:43","leaveType":"2","mark":null,"flowContent":null,"isdeleted":"0","updatetime":"2020-11-03 14:29:11","processId":"130001","operation":"commit","leader":"18538323050","leaderMark":null,"manager":null,"managerMark":null,"result":"1","duration":"6"},{"sheetId":"6723d0644703462e82786a4be01f9127","sheetNo":"1604988248965","starter":null,"starterName":null,"starttime":"2020-11-10 14:04:15","sheetStatus":"3","begintime":"2020-10-11 14:00:00","endtime":"2020-10-12 15:00:00","leaveType":"病假","mark":"我的评价机油","flowContent":null,"isdeleted":"0","updatetime":null,"processId":"167501","operation":"commit","leader":"18538323050","leaderMark":null,"manager":null,"managerMark":null,"result":null,"duration":null}]
         * total : 9
         * size : 3
         * current : 1
         * orders : []
         * optimizeCountSql : true
         * hitCount : false
         * countId : null
         * maxLimit : null
         * searchCount : true
         * pages : 3
         */

        private int total;
        private int size;
        private int current;
        private boolean optimizeCountSql;
        private boolean hitCount;
        private Object countId;
        private Object maxLimit;
        private boolean searchCount;
        private int pages;
        private List<RecordsBean> records;
        private List<?> orders;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public boolean isOptimizeCountSql() {
            return optimizeCountSql;
        }

        public void setOptimizeCountSql(boolean optimizeCountSql) {
            this.optimizeCountSql = optimizeCountSql;
        }

        public boolean isHitCount() {
            return hitCount;
        }

        public void setHitCount(boolean hitCount) {
            this.hitCount = hitCount;
        }

        public Object getCountId() {
            return countId;
        }

        public void setCountId(Object countId) {
            this.countId = countId;
        }

        public Object getMaxLimit() {
            return maxLimit;
        }

        public void setMaxLimit(Object maxLimit) {
            this.maxLimit = maxLimit;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public List<?> getOrders() {
            return orders;
        }

        public void setOrders(List<?> orders) {
            this.orders = orders;
        }

        public static class RecordsBean  {
            /**
             * sheetId : 11cd76535fc64f51a1f1db479d77a113
             * sheetNo : LEAVE-NO-7AF1-B7A2
             * starter : zhangsan
             * starterName : zhangsan
             * starttime : 2020-11-10 10:21:58
             * sheetStatus : 3
             * begintime : 2020-11-07 10:21:37
             * endtime : 2020-12-05 10:21:40
             * leaveType : 1
             * mark : null
             * flowContent : null
             * isdeleted : 0
             * updatetime : null
             * processId : 165007
             * operation : commit
             * leader : 18538323050
             * leaderMark : null
             * manager : null
             * managerMark : null
             * result : null
             * duration : null
             */


            private String sheetId;
            private String sheetNo;
            private String starter;
            private String starterName;
            private String starttime;
            private String sheetStatus;
            private String begintime;
            private String endtime;
            private String leaveType;
            private Object mark;
            private Object flowContent;
            private String isdeleted;
            private Object updatetime;
            private String processId;
            private String operation;
            private String leader;
            private Object leaderMark;
            private Object manager;
            private Object managerMark;
            private Object result;
            private Object duration;


            public String getSheetId() {
                return sheetId;
            }

            public void setSheetId(String sheetId) {
                this.sheetId = sheetId;
            }

            public String getSheetNo() {
                return sheetNo;
            }

            public void setSheetNo(String sheetNo) {
                this.sheetNo = sheetNo;
            }

            public String getStarter() {
                return starter;
            }

            public void setStarter(String starter) {
                this.starter = starter;
            }

            public String getStarterName() {
                return starterName;
            }

            public void setStarterName(String starterName) {
                this.starterName = starterName;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getSheetStatus() {
                return sheetStatus;
            }

            public void setSheetStatus(String sheetStatus) {
                this.sheetStatus = sheetStatus;
            }

            public String getBegintime() {
                return begintime;
            }

            public void setBegintime(String begintime) {
                this.begintime = begintime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public String getLeaveType() {
                return leaveType;
            }

            public void setLeaveType(String leaveType) {
                this.leaveType = leaveType;
            }

            public Object getMark() {
                return mark;
            }

            public void setMark(Object mark) {
                this.mark = mark;
            }

            public Object getFlowContent() {
                return flowContent;
            }

            public void setFlowContent(Object flowContent) {
                this.flowContent = flowContent;
            }

            public String getIsdeleted() {
                return isdeleted;
            }

            public void setIsdeleted(String isdeleted) {
                this.isdeleted = isdeleted;
            }

            public Object getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(Object updatetime) {
                this.updatetime = updatetime;
            }

            public String getProcessId() {
                return processId;
            }

            public void setProcessId(String processId) {
                this.processId = processId;
            }

            public String getOperation() {
                return operation;
            }

            public void setOperation(String operation) {
                this.operation = operation;
            }

            public String getLeader() {
                return leader;
            }

            public void setLeader(String leader) {
                this.leader = leader;
            }

            public Object getLeaderMark() {
                return leaderMark;
            }

            public void setLeaderMark(Object leaderMark) {
                this.leaderMark = leaderMark;
            }

            public Object getManager() {
                return manager;
            }

            public void setManager(Object manager) {
                this.manager = manager;
            }

            public Object getManagerMark() {
                return managerMark;
            }

            public void setManagerMark(Object managerMark) {
                this.managerMark = managerMark;
            }

            public Object getResult() {
                return result;
            }

            public void setResult(Object result) {
                this.result = result;
            }

            public Object getDuration() {
                return duration;
            }

            public void setDuration(Object duration) {
                this.duration = duration;
            }
        }
    }
}
