package com.fhx.property.bean;

import java.util.List;

public class UserInfoBean  {

    /**
     * data : {"currentUser":{"createTime":"2020-10-10T11:30:48","creator":"dba","isbaned":"0","originId":"f7e725ffbe9d96f452327e7fc5910913","password":"e10adc3949ba59abbe56e057f20f883e","roleId":"GC_HEADER_001","userId":"3","userName":"manager"},"department":{"createTime":"2020-10-29 15:13:03","deptId":"129a334b6006e21433b3c30eb2a8f525","deptName":"电器工程师","deptType":"2","duty":"","leader":"","parentId":"1af2180da6985a822b85b3758f0e1ebc","updateTime":"2020-10-29 18:07:36"},"employee":{"birthday":"1980-09-02","deptId":"129a334b6006e21433b3c30eb2a8f525","dutyName":"员工","employeeId":"f7e725ffbe9d96f452327e7fc5910913","employeeName":"部门经理","employeeNo":"NO-0000045","inDate":"2019-08-02 12:32:45","mail":"1621700974@qq.com","nation":"汉族","notes":"这里是备注","phone":"187354755","phoneBackup":"16608831825","sex":"1","status":"1","systemEnable":"1","updateTime":"2020-11-09 11:42:01"},"permission":[],"roles":[]}
     * success : true
     */

    private DataBean data;
    private boolean success;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * currentUser : {"createTime":"2020-10-10T11:30:48","creator":"dba","isbaned":"0","originId":"f7e725ffbe9d96f452327e7fc5910913","password":"e10adc3949ba59abbe56e057f20f883e","roleId":"GC_HEADER_001","userId":"3","userName":"manager"}
         * department : {"createTime":"2020-10-29 15:13:03","deptId":"129a334b6006e21433b3c30eb2a8f525","deptName":"电器工程师","deptType":"2","duty":"","leader":"","parentId":"1af2180da6985a822b85b3758f0e1ebc","updateTime":"2020-10-29 18:07:36"}
         * employee : {"birthday":"1980-09-02","deptId":"129a334b6006e21433b3c30eb2a8f525","dutyName":"员工","employeeId":"f7e725ffbe9d96f452327e7fc5910913","employeeName":"部门经理","employeeNo":"NO-0000045","inDate":"2019-08-02 12:32:45","mail":"1621700974@qq.com","nation":"汉族","notes":"这里是备注","phone":"187354755","phoneBackup":"16608831825","sex":"1","status":"1","systemEnable":"1","updateTime":"2020-11-09 11:42:01"}
         * permission : []
         * roles : []
         */

        private CurrentUserBean currentUser;
        private DepartmentBean department;
        private EmployeeBean employee;
        private List<?> permission;
        private List<?> roles;

        public CurrentUserBean getCurrentUser() {
            return currentUser;
        }

        public void setCurrentUser(CurrentUserBean currentUser) {
            this.currentUser = currentUser;
        }

        public DepartmentBean getDepartment() {
            return department;
        }

        public void setDepartment(DepartmentBean department) {
            this.department = department;
        }

        public EmployeeBean getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBean employee) {
            this.employee = employee;
        }

        public List<?> getPermission() {
            return permission;
        }

        public void setPermission(List<?> permission) {
            this.permission = permission;
        }

        public List<?> getRoles() {
            return roles;
        }

        public void setRoles(List<?> roles) {
            this.roles = roles;
        }

        public static class CurrentUserBean {
            /**
             * createTime : 2020-10-10T11:30:48
             * creator : dba
             * isbaned : 0
             * originId : f7e725ffbe9d96f452327e7fc5910913
             * password : e10adc3949ba59abbe56e057f20f883e
             * roleId : GC_HEADER_001
             * userId : 3
             * userName : manager
             */

            private String createTime;
            private String creator;
            private String isbaned;
            private String originId;
            private String password;
            private String roleId;
            private String userId;
            private String userName;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreator() {
                return creator;
            }

            public void setCreator(String creator) {
                this.creator = creator;
            }

            public String getIsbaned() {
                return isbaned;
            }

            public void setIsbaned(String isbaned) {
                this.isbaned = isbaned;
            }

            public String getOriginId() {
                return originId;
            }

            public void setOriginId(String originId) {
                this.originId = originId;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getRoleId() {
                return roleId;
            }

            public void setRoleId(String roleId) {
                this.roleId = roleId;
            }

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
        }

        public static class DepartmentBean {
            /**
             * createTime : 2020-10-29 15:13:03
             * deptId : 129a334b6006e21433b3c30eb2a8f525
             * deptName : 电器工程师
             * deptType : 2
             * duty :
             * leader :
             * parentId : 1af2180da6985a822b85b3758f0e1ebc
             * updateTime : 2020-10-29 18:07:36
             */

            private String createTime;
            private String deptId;
            private String deptName;
            private String deptType;
            private String duty;
            private String leader;
            private String parentId;
            private String updateTime;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getDeptName() {
                return deptName;
            }

            public void setDeptName(String deptName) {
                this.deptName = deptName;
            }

            public String getDeptType() {
                return deptType;
            }

            public void setDeptType(String deptType) {
                this.deptType = deptType;
            }

            public String getDuty() {
                return duty;
            }

            public void setDuty(String duty) {
                this.duty = duty;
            }

            public String getLeader() {
                return leader;
            }

            public void setLeader(String leader) {
                this.leader = leader;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }

        public static class EmployeeBean {
            /**
             * birthday : 1980-09-02
             * deptId : 129a334b6006e21433b3c30eb2a8f525
             * dutyName : 员工
             * employeeId : f7e725ffbe9d96f452327e7fc5910913
             * employeeName : 部门经理
             * employeeNo : NO-0000045
             * inDate : 2019-08-02 12:32:45
             * mail : 1621700974@qq.com
             * nation : 汉族
             * notes : 这里是备注
             * phone : 187354755
             * phoneBackup : 16608831825
             * sex : 1
             * status : 1
             * systemEnable : 1
             * updateTime : 2020-11-09 11:42:01
             */

            private String birthday;
            private String deptId;
            private String dutyName;
            private String employeeId;
            private String employeeName;
            private String employeeNo;
            private String inDate;
            private String mail;
            private String nation;
            private String notes;
            private String phone;
            private String phoneBackup;
            private String sex;
            private String status;
            private String systemEnable;
            private String updateTime;

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getDutyName() {
                return dutyName;
            }

            public void setDutyName(String dutyName) {
                this.dutyName = dutyName;
            }

            public String getEmployeeId() {
                return employeeId;
            }

            public void setEmployeeId(String employeeId) {
                this.employeeId = employeeId;
            }

            public String getEmployeeName() {
                return employeeName;
            }

            public void setEmployeeName(String employeeName) {
                this.employeeName = employeeName;
            }

            public String getEmployeeNo() {
                return employeeNo;
            }

            public void setEmployeeNo(String employeeNo) {
                this.employeeNo = employeeNo;
            }

            public String getInDate() {
                return inDate;
            }

            public void setInDate(String inDate) {
                this.inDate = inDate;
            }

            public String getMail() {
                return mail;
            }

            public void setMail(String mail) {
                this.mail = mail;
            }

            public String getNation() {
                return nation;
            }

            public void setNation(String nation) {
                this.nation = nation;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
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

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSystemEnable() {
                return systemEnable;
            }

            public void setSystemEnable(String systemEnable) {
                this.systemEnable = systemEnable;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
