package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

import java.util.List;


public class RepairsCommitBean extends BaseBean {


    /**
     * success : true
     * data : {"records":[{"repairId":"150df0220f1b69e2418570087e7aeac1","createTime":"2020-10-19T02:09:29.000+00:00","customerId":null,"repairTypeId":null,"repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":null,"reserveTime":null,"notes":null,"updatetime":null,"floor":null,"customerName":null,"content":"待评价","status":"0"},{"repairId":"57250a7f6fb31611808d2edaaad51e9f","createTime":"2020-10-19T02:09:38.000+00:00","customerId":null,"repairTypeId":null,"repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":null,"reserveTime":null,"notes":null,"updatetime":null,"floor":null,"customerName":null,"content":"已评价","status":"0"},{"repairId":"5f7524b0b8928d49ea11d6965ecbc0bc","createTime":"2020-10-19T02:09:15.000+00:00","customerId":null,"repairTypeId":null,"repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":null,"reserveTime":null,"notes":null,"updatetime":null,"floor":null,"customerName":null,"content":"处理中","status":"0"},{"repairId":"f603e2f9048fcf7e876e3cc74a7f30a2","createTime":"2020-10-19T01:21:03.000+00:00","customerId":null,"repairTypeId":null,"repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":null,"reserveTime":null,"notes":null,"updatetime":null,"floor":null,"customerName":null,"content":"content","status":"0"}],"total":4,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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
        /**
         * records : [{"repairId":"150df0220f1b69e2418570087e7aeac1","createTime":"2020-10-19T02:09:29.000+00:00","customerId":null,"repairTypeId":null,"repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":null,"reserveTime":null,"notes":null,"updatetime":null,"floor":null,"customerName":null,"content":"待评价","status":"0"},{"repairId":"57250a7f6fb31611808d2edaaad51e9f","createTime":"2020-10-19T02:09:38.000+00:00","customerId":null,"repairTypeId":null,"repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":null,"reserveTime":null,"notes":null,"updatetime":null,"floor":null,"customerName":null,"content":"已评价","status":"0"},{"repairId":"5f7524b0b8928d49ea11d6965ecbc0bc","createTime":"2020-10-19T02:09:15.000+00:00","customerId":null,"repairTypeId":null,"repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":null,"reserveTime":null,"notes":null,"updatetime":null,"floor":null,"customerName":null,"content":"处理中","status":"0"},{"repairId":"f603e2f9048fcf7e876e3cc74a7f30a2","createTime":"2020-10-19T01:21:03.000+00:00","customerId":null,"repairTypeId":null,"repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":null,"reserveTime":null,"notes":null,"updatetime":null,"floor":null,"customerName":null,"content":"content","status":"0"}]
         * total : 4
         * size : 10
         * current : 1
         * orders : []
         * optimizeCountSql : true
         * hitCount : false
         * countId : null
         * maxLimit : null
         * searchCount : true
         * pages : 1
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

        public static class RecordsBean extends BaseBean {
            /**
             * repairId : 150df0220f1b69e2418570087e7aeac1
             * createTime : 2020-10-19T02:09:29.000+00:00
             * customerId : null
             * repairTypeId : null
             * repairTypeName : null
             * spaceId : null
             * spaceNo : null
             * customerPhone : null
             * reserveTime : null
             * notes : null
             * updatetime : null
             * floor : null
             * customerName : null
             * content : 待评价
             * status : 0
             */

            private String repairId;
            private String createTime;
            private Object customerId;
            private Object repairTypeId;
            private Object repairTypeName;
            private Object spaceId;
            private Object spaceNo;
            private Object customerPhone;
            private Object reserveTime;
            private Object notes;
            private Object updatetime;
            private Object floor;
            private Object customerName;
            private String content;
            private String status;
            private String imgs;

            public String getImgs() {
                return imgs;
            }

            public void setImgs(String imgs) {
                this.imgs = imgs;
            }

            public String getRepairId() {
                return repairId;
            }

            public void setRepairId(String repairId) {
                this.repairId = repairId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getCustomerId() {
                return customerId;
            }

            public void setCustomerId(Object customerId) {
                this.customerId = customerId;
            }

            public Object getRepairTypeId() {
                return repairTypeId;
            }

            public void setRepairTypeId(Object repairTypeId) {
                this.repairTypeId = repairTypeId;
            }

            public Object getRepairTypeName() {
                return repairTypeName;
            }

            public void setRepairTypeName(Object repairTypeName) {
                this.repairTypeName = repairTypeName;
            }

            public Object getSpaceId() {
                return spaceId;
            }

            public void setSpaceId(Object spaceId) {
                this.spaceId = spaceId;
            }

            public Object getSpaceNo() {
                return spaceNo;
            }

            public void setSpaceNo(Object spaceNo) {
                this.spaceNo = spaceNo;
            }

            public Object getCustomerPhone() {
                return customerPhone;
            }

            public void setCustomerPhone(Object customerPhone) {
                this.customerPhone = customerPhone;
            }

            public Object getReserveTime() {
                return reserveTime;
            }

            public void setReserveTime(Object reserveTime) {
                this.reserveTime = reserveTime;
            }

            public Object getNotes() {
                return notes;
            }

            public void setNotes(Object notes) {
                this.notes = notes;
            }

            public Object getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(Object updatetime) {
                this.updatetime = updatetime;
            }

            public Object getFloor() {
                return floor;
            }

            public void setFloor(Object floor) {
                this.floor = floor;
            }

            public Object getCustomerName() {
                return customerName;
            }

            public void setCustomerName(Object customerName) {
                this.customerName = customerName;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
