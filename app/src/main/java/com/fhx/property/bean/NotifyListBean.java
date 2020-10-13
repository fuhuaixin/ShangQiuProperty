package com.fhx.property.bean;

import com.fhx.property.base.BaseBean;

import java.util.List;

public class NotifyListBean extends BaseBean {


    /**
     * success : true
     * data : {"records":[{"newsId":"343a8063ea8492c6421d96ee0d3e6e13","newsType":"通知","title":"关于2020年12月15日24-30层停水通知","content":"因市政部门调测水压，2020年12月15日上午9时至12时将会停水，请各楼层做好储水安排。","creator":"","createTime":"2020-10-13T01:59:59.000+00:00","notes":"","modifier":"","modifyTime":null},{"newsId":"6f0f401e790e0059e989bd0e518f8e10","newsType":"通知","title":"2020年冬季暖气费预收缴通知","content":"2020年冬季暖气费预收缴通知，望各业主在收到通知之日，至2020年12月31号前在财务部进行收纳","creator":"","createTime":"2020-10-13T01:49:20.000+00:00","notes":"支持微信支付宝及现金付费","modifier":"","modifyTime":null},{"newsId":"b680b2d1c46b8e20b30be6fbda85e49f","newsType":"通知","title":"关于2020年12月13日消防演练的通知","content":"2020年12月13日将在大堂广场举行消防演练，届时会有警报响起，请各楼层人员不必惊慌，警报时间大约持续5分钟。","creator":"","createTime":"2020-10-13T01:58:41.000+00:00","notes":"","modifier":"","modifyTime":null},{"newsId":"db8761511908821c505334e13a9d8eaf","newsType":"通知","title":"2020年第4季度物业费用缴纳通知","content":"2020年第4季度物业费用缴纳通知，望各业主在收到通知之日，至2020年12月31号前在财务部进行收纳","creator":"","createTime":"2020-10-13T01:31:50.000+00:00","notes":"支持微信支付宝及现金付费","modifier":"","modifyTime":null},{"newsId":"ffca0d1fbca564f361ee33b679df414b","newsType":"通知","title":"关于2021年元旦放假通知","content":"2021年元旦放假3天，具体为2021年1月1日至2021年1月3日","creator":"","createTime":"2020-10-13T01:56:17.000+00:00","notes":"","modifier":"","modifyTime":null}],"total":5,"size":5,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
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
         * records : [{"newsId":"343a8063ea8492c6421d96ee0d3e6e13","newsType":"通知","title":"关于2020年12月15日24-30层停水通知","content":"因市政部门调测水压，2020年12月15日上午9时至12时将会停水，请各楼层做好储水安排。","creator":"","createTime":"2020-10-13T01:59:59.000+00:00","notes":"","modifier":"","modifyTime":null},{"newsId":"6f0f401e790e0059e989bd0e518f8e10","newsType":"通知","title":"2020年冬季暖气费预收缴通知","content":"2020年冬季暖气费预收缴通知，望各业主在收到通知之日，至2020年12月31号前在财务部进行收纳","creator":"","createTime":"2020-10-13T01:49:20.000+00:00","notes":"支持微信支付宝及现金付费","modifier":"","modifyTime":null},{"newsId":"b680b2d1c46b8e20b30be6fbda85e49f","newsType":"通知","title":"关于2020年12月13日消防演练的通知","content":"2020年12月13日将在大堂广场举行消防演练，届时会有警报响起，请各楼层人员不必惊慌，警报时间大约持续5分钟。","creator":"","createTime":"2020-10-13T01:58:41.000+00:00","notes":"","modifier":"","modifyTime":null},{"newsId":"db8761511908821c505334e13a9d8eaf","newsType":"通知","title":"2020年第4季度物业费用缴纳通知","content":"2020年第4季度物业费用缴纳通知，望各业主在收到通知之日，至2020年12月31号前在财务部进行收纳","creator":"","createTime":"2020-10-13T01:31:50.000+00:00","notes":"支持微信支付宝及现金付费","modifier":"","modifyTime":null},{"newsId":"ffca0d1fbca564f361ee33b679df414b","newsType":"通知","title":"关于2021年元旦放假通知","content":"2021年元旦放假3天，具体为2021年1月1日至2021年1月3日","creator":"","createTime":"2020-10-13T01:56:17.000+00:00","notes":"","modifier":"","modifyTime":null}]
         * total : 5
         * size : 5
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

        public static class RecordsBean {
            /**
             * newsId : 343a8063ea8492c6421d96ee0d3e6e13
             * newsType : 通知
             * title : 关于2020年12月15日24-30层停水通知
             * content : 因市政部门调测水压，2020年12月15日上午9时至12时将会停水，请各楼层做好储水安排。
             * creator :
             * createTime : 2020-10-13T01:59:59.000+00:00
             * notes :
             * modifier :
             * modifyTime : null
             */

            private String newsId;
            private String newsType;
            private String title;
            private String content;
            private String creator;
            private String createTime;
            private String notes;
            private String modifier;
            private Object modifyTime;

            public String getNewsId() {
                return newsId;
            }

            public void setNewsId(String newsId) {
                this.newsId = newsId;
            }

            public String getNewsType() {
                return newsType;
            }

            public void setNewsType(String newsType) {
                this.newsType = newsType;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getModifier() {
                return modifier;
            }

            public void setModifier(String modifier) {
                this.modifier = modifier;
            }

            public Object getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(Object modifyTime) {
                this.modifyTime = modifyTime;
            }
        }
    }
}
