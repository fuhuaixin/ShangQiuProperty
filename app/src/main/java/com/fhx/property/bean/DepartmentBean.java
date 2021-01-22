package com.fhx.property.bean;

import java.util.List;

public class DepartmentBean {


    /**
     * data : {"childDept":[{"createTime":"2020-10-29 15:13:44","deptId":"23f31ddf735875d51b7987fe34aac187","deptLeader":{"birthday":"1980-09-02","deptId":"23f31ddf735875d51b7987fe34aac187","dutyName":"员工","employeeId":"f7e725ffbe9d96f452327e7fc5910915","employeeName":"部门员工","employeeNo":"NO-0000047","inDate":"2019-08-02 12:32:45","mail":"1621700974@qq.com","nation":"汉族","notes":"这里是备注","phone":"18737144555","phoneBackup":"16608831825","sex":"1","status":"1","systemEnable":"1","updateTime":"2020-11-03 16:32:08"},"deptName":"空水技工","deptType":"2","duty":"","leader":"f7e725ffbe9d96f452327e7fc5910915","parentId":"e8042ea78595e60bbba05dba52b55ae9","updateTime":"2020-12-17 14:41:18"},{"createTime":"2020-10-29 15:14:02","deptId":"989c509d3c61a2905fb88f2ddf98affa","deptName":"电梯技工","deptType":"2","duty":"","leader":"","parentId":"e8042ea78595e60bbba05dba52b55ae9","updateTime":"2020-10-29 18:07:22"},{"createTime":"2020-10-29 15:14:19","deptId":"a2374b5018e1c5cf96dcdcaa6073f725","deptLeader":{"address":"","birthday":"2020-10-08T16:00:00.000Z","createTime":"2020-10-30 14:18:15","deptId":"a2374b5018e1c5cf96dcdcaa6073f725","dutyName":"","employeeId":"f2a38285a0728ca90e5c399c6a4d58cb","employeeName":"LPB","employeeNo":"NO-0000099","inDate":"2020-10-29T16:00:00.000Z","mail":"super_bin@sina.cn","nation":"汉族","notes":"测试","outDate":"2020-10-30T16:00:00.000Z","phone":"18601571210","phoneBackup":"","sex":"1","systemEnable":"0","updateTime":"2020-10-30 14:20:21"},"deptName":"电工","deptType":"2","duty":"","leader":"f2a38285a0728ca90e5c399c6a4d58cb","parentId":"e8042ea78595e60bbba05dba52b55ae9","updateTime":"2020-10-30 14:25:59"},{"createTime":"2020-10-29 15:14:44","deptId":"c7d8097235e259e7e900e8a99dc6f177","deptName":"综合维修技工","deptType":"2","duty":"","leader":"","parentId":"e8042ea78595e60bbba05dba52b55ae9"}],"deptEmployee":[{"birthday":"1980-09-02","deptId":"e8042ea78595e60bbba05dba52b55ae9","dutyName":"员工","employeeId":"f7e725ffbe9d96f452327e7fc5910914","employeeName":"部门领导","employeeNo":"NO-0000046","inDate":"2019-08-02 12:32:45","mail":"1621700974@qq.com","nation":"汉族","notes":"这里是备注","phone":"1875456555","phoneBackup":"16608831825","sex":"1","status":"1","systemEnable":"1","updateTime":"2020-12-17 14:38:55"}]}
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
        private List<ChildDeptBean> childDept;
        private List<DeptEmployeeBean> deptEmployee;

        public List<ChildDeptBean> getChildDept() {
            return childDept;
        }

        public void setChildDept(List<ChildDeptBean> childDept) {
            this.childDept = childDept;
        }

        public List<DeptEmployeeBean> getDeptEmployee() {
            return deptEmployee;
        }

        public void setDeptEmployee(List<DeptEmployeeBean> deptEmployee) {
            this.deptEmployee = deptEmployee;
        }

        public static class ChildDeptBean {
            /**
             * createTime : 2020-10-29 15:13:44
             * deptId : 23f31ddf735875d51b7987fe34aac187
             * deptLeader : {"birthday":"1980-09-02","deptId":"23f31ddf735875d51b7987fe34aac187","dutyName":"员工","employeeId":"f7e725ffbe9d96f452327e7fc5910915","employeeName":"部门员工","employeeNo":"NO-0000047","inDate":"2019-08-02 12:32:45","mail":"1621700974@qq.com","nation":"汉族","notes":"这里是备注","phone":"18737144555","phoneBackup":"16608831825","sex":"1","status":"1","systemEnable":"1","updateTime":"2020-11-03 16:32:08"}
             * deptName : 空水技工
             * deptType : 2
             * duty :
             * leader : f7e725ffbe9d96f452327e7fc5910915
             * parentId : e8042ea78595e60bbba05dba52b55ae9
             * updateTime : 2020-12-17 14:41:18
             */

            private String createTime;
            private String deptId;
            private DeptLeaderBean deptLeader;
            private String deptName;
            private String deptType;
            private String duty;
            private String leader;
            private String parentId;
            private String updateTime;
            private int choose; //0 未选中 1 选中

            public int getChoose() {
                return choose;
            }

            public void setChoose(int choose) {
                this.choose = choose;
            }

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

            public DeptLeaderBean getDeptLeader() {
                return deptLeader;
            }

            public void setDeptLeader(DeptLeaderBean deptLeader) {
                this.deptLeader = deptLeader;
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

            public static class DeptLeaderBean {
                /**
                 * birthday : 1980-09-02
                 * deptId : 23f31ddf735875d51b7987fe34aac187
                 * dutyName : 员工
                 * employeeId : f7e725ffbe9d96f452327e7fc5910915
                 * employeeName : 部门员工
                 * employeeNo : NO-0000047
                 * inDate : 2019-08-02 12:32:45
                 * mail : 1621700974@qq.com
                 * nation : 汉族
                 * notes : 这里是备注
                 * phone : 18737144555
                 * phoneBackup : 16608831825
                 * sex : 1
                 * status : 1
                 * systemEnable : 1
                 * updateTime : 2020-11-03 16:32:08
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

        public static class DeptEmployeeBean {
            /**
             * birthday : 1980-09-02
             * deptId : e8042ea78595e60bbba05dba52b55ae9
             * dutyName : 员工
             * employeeId : f7e725ffbe9d96f452327e7fc5910914
             * employeeName : 部门领导
             * employeeNo : NO-0000046
             * inDate : 2019-08-02 12:32:45
             * mail : 1621700974@qq.com
             * nation : 汉族
             * notes : 这里是备注
             * phone : 1875456555
             * phoneBackup : 16608831825
             * sex : 1
             * status : 1
             * systemEnable : 1
             * updateTime : 2020-12-17 14:38:55
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
            private int choose; // 0未选中 1选中

            public int getChoose() {
                return choose;
            }

            public void setChoose(int choose) {
                this.choose = choose;
            }

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
