package com.fhx.property.bean;

import java.util.List;

public class RepairsMSgBean {


    /**
     * success : true
     * data : {"orderDetails":[],"evaluteInfo":null,"self":{"repairId":"792385a829178a1e22e23aaf3b0c5a02","createTime":"2020-12-07 15:29:59","customerId":"5","repairTypeId":null,"repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":"18601571210","reserveTime":"2020-12-10 00:00:00","notes":"A栋1902","updatetime":"2020-12-07 15:31:22","floor":null,"customerName":"LPB","content":"A栋1902空调漏水报修","status":"2","originType":"0","processId":"225101","imgs":null},"order":{"workOrderId":"d7808490db178a08f5072bc5eb19b7ae","workOrderType":"0","relationId":"792385a829178a1e22e23aaf3b0c5a02","orderStatus":"3","creator":null,"createTime":"2020-12-07 15:29:59","priority":null,"executor":null,"notes":null,"endTime":null,"floor":null,"updateTime":"2020-12-07 15:31:23","relationTableName":"t_repair","contactNum":null,"processId":"225101"}}
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
         * orderDetails : []
         * evaluteInfo : null
         * self : {"repairId":"792385a829178a1e22e23aaf3b0c5a02","createTime":"2020-12-07 15:29:59","customerId":"5","repairTypeId":null,"repairTypeName":null,"spaceId":null,"spaceNo":null,"customerPhone":"18601571210","reserveTime":"2020-12-10 00:00:00","notes":"A栋1902","updatetime":"2020-12-07 15:31:22","floor":null,"customerName":"LPB","content":"A栋1902空调漏水报修","status":"2","originType":"0","processId":"225101","imgs":null}
         * order : {"workOrderId":"d7808490db178a08f5072bc5eb19b7ae","workOrderType":"0","relationId":"792385a829178a1e22e23aaf3b0c5a02","orderStatus":"3","creator":null,"createTime":"2020-12-07 15:29:59","priority":null,"executor":null,"notes":null,"endTime":null,"floor":null,"updateTime":"2020-12-07 15:31:23","relationTableName":"t_repair","contactNum":null,"processId":"225101"}
         */

        private String evaluteInfo;
        private SelfBean self;
        private OrderBean order;
        private List<?> orderDetails;

        public String getEvaluteInfo() {
            return evaluteInfo;
        }

        public void setEvaluteInfo(String evaluteInfo) {
            this.evaluteInfo = evaluteInfo;
        }

        public SelfBean getSelf() {
            return self;
        }

        public void setSelf(SelfBean self) {
            this.self = self;
        }

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public List<?> getOrderDetails() {
            return orderDetails;
        }

        public void setOrderDetails(List<?> orderDetails) {
            this.orderDetails = orderDetails;
        }

        public static class SelfBean {
            /**
             * repairId : 792385a829178a1e22e23aaf3b0c5a02
             * createTime : 2020-12-07 15:29:59
             * customerId : 5
             * repairTypeId : null
             * repairTypeName : null
             * spaceId : null
             * spaceNo : null
             * customerPhone : 18601571210
             * reserveTime : 2020-12-10 00:00:00
             * notes : A栋1902
             * updatetime : 2020-12-07 15:31:22
             * floor : null
             * customerName : LPB
             * content : A栋1902空调漏水报修
             * status : 2
             * originType : 0
             * processId : 225101
             * imgs : null
             */

            private String repairId;
            private String createTime;
            private String customerId;
            private String repairTypeId;
            private String repairTypeName;
            private String spaceId;
            private String spaceNo;
            private String customerPhone;
            private String reserveTime;
            private String notes;
            private String updatetime;
            private String floor;
            private String customerName;
            private String content;
            private String status;
            private String originType;
            private String processId;
            private String imgs;

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

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getRepairTypeId() {
                return repairTypeId;
            }

            public void setRepairTypeId(String repairTypeId) {
                this.repairTypeId = repairTypeId;
            }

            public String getRepairTypeName() {
                return repairTypeName;
            }

            public void setRepairTypeName(String repairTypeName) {
                this.repairTypeName = repairTypeName;
            }

            public String getSpaceId() {
                return spaceId;
            }

            public void setSpaceId(String spaceId) {
                this.spaceId = spaceId;
            }

            public String getSpaceNo() {
                return spaceNo;
            }

            public void setSpaceNo(String spaceNo) {
                this.spaceNo = spaceNo;
            }

            public String getCustomerPhone() {
                return customerPhone;
            }

            public void setCustomerPhone(String customerPhone) {
                this.customerPhone = customerPhone;
            }

            public String getReserveTime() {
                return reserveTime;
            }

            public void setReserveTime(String reserveTime) {
                this.reserveTime = reserveTime;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getFloor() {
                return floor;
            }

            public void setFloor(String floor) {
                this.floor = floor;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
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

            public String getOriginType() {
                return originType;
            }

            public void setOriginType(String originType) {
                this.originType = originType;
            }

            public String getProcessId() {
                return processId;
            }

            public void setProcessId(String processId) {
                this.processId = processId;
            }

            public String getImgs() {
                return imgs;
            }

            public void setImgs(String imgs) {
                this.imgs = imgs;
            }
        }

        public static class OrderBean {
            /**
             * workOrderId : d7808490db178a08f5072bc5eb19b7ae
             * workOrderType : 0
             * relationId : 792385a829178a1e22e23aaf3b0c5a02
             * orderStatus : 3
             * creator : null
             * createTime : 2020-12-07 15:29:59
             * priority : null
             * executor : null
             * notes : null
             * endTime : null
             * floor : null
             * updateTime : 2020-12-07 15:31:23
             * relationTableName : t_repair
             * contactNum : null
             * processId : 225101
             */

            private String workOrderId;
            private String workOrderType;
            private String relationId;
            private String orderStatus;
            private String creator;
            private String createTime;
            private String priority;
            private String executor;
            private String notes;
            private String endTime;
            private String floor;
            private String updateTime;
            private String relationTableName;
            private String contactNum;
            private String processId;

            public String getWorkOrderId() {
                return workOrderId;
            }

            public void setWorkOrderId(String workOrderId) {
                this.workOrderId = workOrderId;
            }

            public String getWorkOrderType() {
                return workOrderType;
            }

            public void setWorkOrderType(String workOrderType) {
                this.workOrderType = workOrderType;
            }

            public String getRelationId() {
                return relationId;
            }

            public void setRelationId(String relationId) {
                this.relationId = relationId;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getCreator() {
                return creator;
            }

            public void setCreator(String creator) {
                this.creator = creator;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getPriority() {
                return priority;
            }

            public void setPriority(String priority) {
                this.priority = priority;
            }

            public String getExecutor() {
                return executor;
            }

            public void setExecutor(String executor) {
                this.executor = executor;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getFloor() {
                return floor;
            }

            public void setFloor(String floor) {
                this.floor = floor;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getRelationTableName() {
                return relationTableName;
            }

            public void setRelationTableName(String relationTableName) {
                this.relationTableName = relationTableName;
            }

            public String getContactNum() {
                return contactNum;
            }

            public void setContactNum(String contactNum) {
                this.contactNum = contactNum;
            }

            public String getProcessId() {
                return processId;
            }

            public void setProcessId(String processId) {
                this.processId = processId;
            }
        }
    }
}
