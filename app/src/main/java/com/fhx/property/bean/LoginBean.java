package com.fhx.property.bean;

public class LoginBean {

    /**
     * success : true
     * data : {"user":{"userId":"1","userName":"zhangsan","password":"e10adc3949ba59abbe56e057f20f883e","createTime":null,"creator":null},"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.bFwLcjdORwcB3OhUWK1wjVe7P3gcum1xwFY2USrqo4k"}
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
         * user : {"userId":"1","userName":"zhangsan","password":"e10adc3949ba59abbe56e057f20f883e","createTime":null,"creator":null}
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.bFwLcjdORwcB3OhUWK1wjVe7P3gcum1xwFY2USrqo4k
         */

        private UserBean user;
        private String token;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserBean {
            /**
             * userId : 1
             * userName : zhangsan
             * password : e10adc3949ba59abbe56e057f20f883e
             * createTime : null
             * creator : null
             */

            private String userId;
            private String userName;
            private String password;
            private Object createTime;
            private Object creator;

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getCreator() {
                return creator;
            }

            public void setCreator(Object creator) {
                this.creator = creator;
            }
        }
    }
}
