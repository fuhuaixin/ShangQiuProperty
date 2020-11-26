package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

import java.util.List;

public class TenantByPageBean extends BaseBean {

    /**
     * success : true
     * data : {"records":[{"tenantryId":"1","tenantryName":"王五","phone":"18601571210","phoneBackup":"18601571210","peopleId":"411326199309126137","company":"似懂非懂","logoUrl":"http://127.0.0.01","notes":"cs","updatetime":"2020-11-11 14:51:35","status":"2","contracts":[{"contractId":"1","spaceId":"1","customerId":"1","beginDate":"2020-11-05","endDate":"2020-11-06","status":"1","contractType":"1","room":"A1001","contractCode":"CT-1001-1106","tenantryId":"1","updatetime":"2020-11-10 17:06:58","notes":null},{"contractId":"2","spaceId":"2","customerId":"1","beginDate":"2020-11-05","endDate":"2020-11-06","status":"1","contractType":"1","room":"A1002","contractCode":"CT-1002-1106","tenantryId":"1","updatetime":"2020-11-10 17:07:00","notes":null}],"customers":[{"customerId":"1","customerName":"王二","phone":"18737144551","password":"e10adc3949ba59abbe56e057f20f883e","phoneBackup":"13636363366","peopleId":"411326199309126137","company":"测试","logoUrl":"http://127.0.0.1","notes":"测试","status":"1","updateTime":"2020-11-06T11:11:24","registerType":"0"}],"rooms":[{"spaceId":"2","roomNo":"A1002","roomName":"A-1002室","floor":"10","notes":"测试","spaceType":"办公室","floorArea":"103.00","sharedArea":"19.00","insideArea":"84.00","chargeArea":"84.00","status":"1","updatetime":"2020-11-06 11:08:20"},{"spaceId":"1","roomNo":"A1001","roomName":"A-1001室","floor":"10","notes":"测试","spaceType":"办公室","floorArea":"106.00","sharedArea":"20.00","insideArea":"86.00","chargeArea":"86.00","status":"1","updatetime":"2020-11-06 11:08:20"}]},{"tenantryId":"731ab0d4aa69973fb4bf554861addc0d","tenantryName":"王柳","phone":"13265486","phoneBackup":"188546525","peopleId":"412356468795","company":"测试到","logoUrl":"sdfs","notes":"sdfs ","updatetime":"2020-11-11 14:56:30","status":"1","contracts":[],"customers":[],"rooms":[]}],"total":2,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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

    public static class DataBean extends BaseBean{
        /**
         * records : [{"tenantryId":"1","tenantryName":"王五","phone":"18601571210","phoneBackup":"18601571210","peopleId":"411326199309126137","company":"似懂非懂","logoUrl":"http://127.0.0.01","notes":"cs","updatetime":"2020-11-11 14:51:35","status":"2","contracts":[{"contractId":"1","spaceId":"1","customerId":"1","beginDate":"2020-11-05","endDate":"2020-11-06","status":"1","contractType":"1","room":"A1001","contractCode":"CT-1001-1106","tenantryId":"1","updatetime":"2020-11-10 17:06:58","notes":null},{"contractId":"2","spaceId":"2","customerId":"1","beginDate":"2020-11-05","endDate":"2020-11-06","status":"1","contractType":"1","room":"A1002","contractCode":"CT-1002-1106","tenantryId":"1","updatetime":"2020-11-10 17:07:00","notes":null}],"customers":[{"customerId":"1","customerName":"王二","phone":"18737144551","password":"e10adc3949ba59abbe56e057f20f883e","phoneBackup":"13636363366","peopleId":"411326199309126137","company":"测试","logoUrl":"http://127.0.0.1","notes":"测试","status":"1","updateTime":"2020-11-06T11:11:24","registerType":"0"}],"rooms":[{"spaceId":"2","roomNo":"A1002","roomName":"A-1002室","floor":"10","notes":"测试","spaceType":"办公室","floorArea":"103.00","sharedArea":"19.00","insideArea":"84.00","chargeArea":"84.00","status":"1","updatetime":"2020-11-06 11:08:20"},{"spaceId":"1","roomNo":"A1001","roomName":"A-1001室","floor":"10","notes":"测试","spaceType":"办公室","floorArea":"106.00","sharedArea":"20.00","insideArea":"86.00","chargeArea":"86.00","status":"1","updatetime":"2020-11-06 11:08:20"}]},{"tenantryId":"731ab0d4aa69973fb4bf554861addc0d","tenantryName":"王柳","phone":"13265486","phoneBackup":"188546525","peopleId":"412356468795","company":"测试到","logoUrl":"sdfs","notes":"sdfs ","updatetime":"2020-11-11 14:56:30","status":"1","contracts":[],"customers":[],"rooms":[]}]
         * total : 2
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
        private String countId;
        private String maxLimit;
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

        public String getCountId() {
            return countId;
        }

        public void setCountId(String countId) {
            this.countId = countId;
        }

        public String getMaxLimit() {
            return maxLimit;
        }

        public void setMaxLimit(String maxLimit) {
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

        public static class RecordsBean extends BaseBean{
            /**
             * tenantryId : 1
             * tenantryName : 王五
             * phone : 18601571210
             * phoneBackup : 18601571210
             * peopleId : 411326199309126137
             * company : 似懂非懂
             * logoUrl : http://127.0.0.01
             * notes : cs
             * updatetime : 2020-11-11 14:51:35
             * status : 2
             * contracts : [{"contractId":"1","spaceId":"1","customerId":"1","beginDate":"2020-11-05","endDate":"2020-11-06","status":"1","contractType":"1","room":"A1001","contractCode":"CT-1001-1106","tenantryId":"1","updatetime":"2020-11-10 17:06:58","notes":null},{"contractId":"2","spaceId":"2","customerId":"1","beginDate":"2020-11-05","endDate":"2020-11-06","status":"1","contractType":"1","room":"A1002","contractCode":"CT-1002-1106","tenantryId":"1","updatetime":"2020-11-10 17:07:00","notes":null}]
             * customers : [{"customerId":"1","customerName":"王二","phone":"18737144551","password":"e10adc3949ba59abbe56e057f20f883e","phoneBackup":"13636363366","peopleId":"411326199309126137","company":"测试","logoUrl":"http://127.0.0.1","notes":"测试","status":"1","updateTime":"2020-11-06T11:11:24","registerType":"0"}]
             * rooms : [{"spaceId":"2","roomNo":"A1002","roomName":"A-1002室","floor":"10","notes":"测试","spaceType":"办公室","floorArea":"103.00","sharedArea":"19.00","insideArea":"84.00","chargeArea":"84.00","status":"1","updatetime":"2020-11-06 11:08:20"},{"spaceId":"1","roomNo":"A1001","roomName":"A-1001室","floor":"10","notes":"测试","spaceType":"办公室","floorArea":"106.00","sharedArea":"20.00","insideArea":"86.00","chargeArea":"86.00","status":"1","updatetime":"2020-11-06 11:08:20"}]
             */

            private String tenantryId;
            private String tenantryName;
            private String phone;
            private String phoneBackup;
            private String peopleId;
            private String company;
            private String logoUrl;
            private String notes;
            private String updatetime;
            private String status;
            private List<ContractsBean> contracts;
            private List<CustomersBean> customers;
            private List<RoomsBean> rooms;

            public String getTenantryId() {
                return tenantryId;
            }

            public void setTenantryId(String tenantryId) {
                this.tenantryId = tenantryId;
            }

            public String getTenantryName() {
                return tenantryName;
            }

            public void setTenantryName(String tenantryName) {
                this.tenantryName = tenantryName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPhoneBackup() {
                return phoneBackup;
            }

            public void setPhoneBackup(String phoneBackup) {
                this.phoneBackup = phoneBackup;
            }

            public String getPeopleId() {
                return peopleId;
            }

            public void setPeopleId(String peopleId) {
                this.peopleId = peopleId;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getLogoUrl() {
                return logoUrl;
            }

            public void setLogoUrl(String logoUrl) {
                this.logoUrl = logoUrl;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<ContractsBean> getContracts() {
                return contracts;
            }

            public void setContracts(List<ContractsBean> contracts) {
                this.contracts = contracts;
            }

            public List<CustomersBean> getCustomers() {
                return customers;
            }

            public void setCustomers(List<CustomersBean> customers) {
                this.customers = customers;
            }

            public List<RoomsBean> getRooms() {
                return rooms;
            }

            public void setRooms(List<RoomsBean> rooms) {
                this.rooms = rooms;
            }

            public static class ContractsBean extends BaseBean{
                /**
                 * contractId : 1
                 * spaceId : 1
                 * customerId : 1
                 * beginDate : 2020-11-05
                 * endDate : 2020-11-06
                 * status : 1
                 * contractType : 1
                 * room : A1001
                 * contractCode : CT-1001-1106
                 * tenantryId : 1
                 * updatetime : 2020-11-10 17:06:58
                 * notes : null
                 */

                private String contractId;
                private String spaceId;
                private String customerId;
                private String beginDate;
                private String endDate;
                private String status;
                private String contractType;
                private String room;
                private String contractCode;
                private String tenantryId;
                private String updatetime;
                private String notes;

                public String getContractId() {
                    return contractId;
                }

                public void setContractId(String contractId) {
                    this.contractId = contractId;
                }

                public String getSpaceId() {
                    return spaceId;
                }

                public void setSpaceId(String spaceId) {
                    this.spaceId = spaceId;
                }

                public String getCustomerId() {
                    return customerId;
                }

                public void setCustomerId(String customerId) {
                    this.customerId = customerId;
                }

                public String getBeginDate() {
                    return beginDate;
                }

                public void setBeginDate(String beginDate) {
                    this.beginDate = beginDate;
                }

                public String getEndDate() {
                    return endDate;
                }

                public void setEndDate(String endDate) {
                    this.endDate = endDate;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getContractType() {
                    return contractType;
                }

                public void setContractType(String contractType) {
                    this.contractType = contractType;
                }

                public String getRoom() {
                    return room;
                }

                public void setRoom(String room) {
                    this.room = room;
                }

                public String getContractCode() {
                    return contractCode;
                }

                public void setContractCode(String contractCode) {
                    this.contractCode = contractCode;
                }

                public String getTenantryId() {
                    return tenantryId;
                }

                public void setTenantryId(String tenantryId) {
                    this.tenantryId = tenantryId;
                }

                public String getUpdatetime() {
                    return updatetime;
                }

                public void setUpdatetime(String updatetime) {
                    this.updatetime = updatetime;
                }

                public String getNotes() {
                    return notes;
                }

                public void setNotes(String notes) {
                    this.notes = notes;
                }
            }

            public static class CustomersBean extends BaseBean{
                /**
                 * customerId : 1
                 * customerName : 王二
                 * phone : 18737144551
                 * password : e10adc3949ba59abbe56e057f20f883e
                 * phoneBackup : 13636363366
                 * peopleId : 411326199309126137
                 * company : 测试
                 * logoUrl : http://127.0.0.1
                 * notes : 测试
                 * status : 1
                 * updateTime : 2020-11-06T11:11:24
                 * registerType : 0
                 */

                private String customerId;
                private String customerName;
                private String phone;
                private String password;
                private String phoneBackup;
                private String peopleId;
                private String company;
                private String logoUrl;
                private String notes;
                private String status;
                private String updateTime;
                private String registerType;

                public String getCustomerId() {
                    return customerId;
                }

                public void setCustomerId(String customerId) {
                    this.customerId = customerId;
                }

                public String getCustomerName() {
                    return customerName;
                }

                public void setCustomerName(String customerName) {
                    this.customerName = customerName;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public String getPhoneBackup() {
                    return phoneBackup;
                }

                public void setPhoneBackup(String phoneBackup) {
                    this.phoneBackup = phoneBackup;
                }

                public String getPeopleId() {
                    return peopleId;
                }

                public void setPeopleId(String peopleId) {
                    this.peopleId = peopleId;
                }

                public String getCompany() {
                    return company;
                }

                public void setCompany(String company) {
                    this.company = company;
                }

                public String getLogoUrl() {
                    return logoUrl;
                }

                public void setLogoUrl(String logoUrl) {
                    this.logoUrl = logoUrl;
                }

                public String getNotes() {
                    return notes;
                }

                public void setNotes(String notes) {
                    this.notes = notes;
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

                public String getRegisterType() {
                    return registerType;
                }

                public void setRegisterType(String registerType) {
                    this.registerType = registerType;
                }
            }

            public static class RoomsBean extends BaseBean{
                /**
                 * spaceId : 2
                 * roomNo : A1002
                 * roomName : A-1002室
                 * floor : 10
                 * notes : 测试
                 * spaceType : 办公室
                 * floorArea : 103.00
                 * sharedArea : 19.00
                 * insideArea : 84.00
                 * chargeArea : 84.00
                 * status : 1
                 * updatetime : 2020-11-06 11:08:20
                 */

                private String spaceId;
                private String roomNo;
                private String roomName;
                private String floor;
                private String notes;
                private String spaceType;
                private String floorArea;
                private String sharedArea;
                private String insideArea;
                private String chargeArea;
                private String status;
                private String updatetime;

                public String getSpaceId() {
                    return spaceId;
                }

                public void setSpaceId(String spaceId) {
                    this.spaceId = spaceId;
                }

                public String getRoomNo() {
                    return roomNo;
                }

                public void setRoomNo(String roomNo) {
                    this.roomNo = roomNo;
                }

                public String getRoomName() {
                    return roomName;
                }

                public void setRoomName(String roomName) {
                    this.roomName = roomName;
                }

                public String getFloor() {
                    return floor;
                }

                public void setFloor(String floor) {
                    this.floor = floor;
                }

                public String getNotes() {
                    return notes;
                }

                public void setNotes(String notes) {
                    this.notes = notes;
                }

                public String getSpaceType() {
                    return spaceType;
                }

                public void setSpaceType(String spaceType) {
                    this.spaceType = spaceType;
                }

                public String getFloorArea() {
                    return floorArea;
                }

                public void setFloorArea(String floorArea) {
                    this.floorArea = floorArea;
                }

                public String getSharedArea() {
                    return sharedArea;
                }

                public void setSharedArea(String sharedArea) {
                    this.sharedArea = sharedArea;
                }

                public String getInsideArea() {
                    return insideArea;
                }

                public void setInsideArea(String insideArea) {
                    this.insideArea = insideArea;
                }

                public String getChargeArea() {
                    return chargeArea;
                }

                public void setChargeArea(String chargeArea) {
                    this.chargeArea = chargeArea;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getUpdatetime() {
                    return updatetime;
                }

                public void setUpdatetime(String updatetime) {
                    this.updatetime = updatetime;
                }
            }
        }
    }
}
