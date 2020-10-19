package com.fhx.property.bean;

public class NotifyMsgBean {


    /**
     * success : true
     * data : {"newsId":"343a8063ea8492c6421d96ee0d3e6e13","newsType":"通知","title":"关于2020年12月15日24-30层停水通知","content":"因市政部门调测水压，2020年12月15日上午9时至12时将会停水，请各楼层做好储水安排。","creator":"","createTime":"2020-10-13T01:59:59.000+00:00","notes":"","modifier":"","modifyTime":null}
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
