package com.fhx.property.bean;

import java.util.List;

public class AttendRulesDeptBean {


    /**
     * data : {"deptarrange":{"deptId":"25800d7c497b89af06e3a0ba9e219697","holidayids":"1,162564b6288aa64a4323e61c7abddf94","shiftids":"2908d11ddf5898ccab4a224e11c87665,29885fc9af485c19689790e1a4f61925","shiftruleId":"1","updatetime":"2020-11-05 11:23:54"},"holidays":[{"enddate":"2020-10-08","holidayName":"国庆节","holidayid":"1","isdeleted":"0","startdate":"2020-10-01","updatetime":"2020-10-30 15:33:56"},{"enddate":"2020-11-18","holidayName":"xfcdfs节","holidayid":"162564b6288aa64a4323e61c7abddf94","isdeleted":"0","startdate":"2020-10-15","updatetime":"2020-11-03 14:02:00"}],"shifts":[{"isdeleted":"0","shiftConfig":"%7B%22field_workdays%22:%5B1,2,3,4,5,6,7%5D,%22periods%22:%5B%7B%22stime%22:%2208:30%22,%22etime%22:%2212:00%22%7D,%7B%22stime%22:%2213:00%22,%22etime%22:%2218:00%22%7D%5D%7D","shiftId":"2908d11ddf5898ccab4a224e11c87665","shiftName":"测试班次15","updatetime":"2020-10-30 14:00:50","workhours":8.5},{"isdeleted":"0","shiftConfig":"%7B%22field_workdays%22:%5B1,2,3,4,5,6,7%5D,%22field_lateafter%22:10,%22field_earlybefore%22:10,%22periods%22:%5B%7B%22stime%22:%2208:00%22,%22etime%22:%2212:00%22%7D,%7B%22stime%22:%2213:00%22,%22etime%22:%2218:00%22%7D%5D%7D","shiftId":"29885fc9af485c19689790e1a4f61925","shiftName":"测试班次13","updatetime":"2020-10-30 13:56:40","workhours":9}]}
     * success : true
     */

    private DataBean data;
    private boolean success;

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
         * deptarrange : {"deptId":"25800d7c497b89af06e3a0ba9e219697","holidayids":"1,162564b6288aa64a4323e61c7abddf94","shiftids":"2908d11ddf5898ccab4a224e11c87665,29885fc9af485c19689790e1a4f61925","shiftruleId":"1","updatetime":"2020-11-05 11:23:54"}
         * holidays : [{"enddate":"2020-10-08","holidayName":"国庆节","holidayid":"1","isdeleted":"0","startdate":"2020-10-01","updatetime":"2020-10-30 15:33:56"},{"enddate":"2020-11-18","holidayName":"xfcdfs节","holidayid":"162564b6288aa64a4323e61c7abddf94","isdeleted":"0","startdate":"2020-10-15","updatetime":"2020-11-03 14:02:00"}]
         * shifts : [{"isdeleted":"0","shiftConfig":"%7B%22field_workdays%22:%5B1,2,3,4,5,6,7%5D,%22periods%22:%5B%7B%22stime%22:%2208:30%22,%22etime%22:%2212:00%22%7D,%7B%22stime%22:%2213:00%22,%22etime%22:%2218:00%22%7D%5D%7D","shiftId":"2908d11ddf5898ccab4a224e11c87665","shiftName":"测试班次15","updatetime":"2020-10-30 14:00:50","workhours":8.5},{"isdeleted":"0","shiftConfig":"%7B%22field_workdays%22:%5B1,2,3,4,5,6,7%5D,%22field_lateafter%22:10,%22field_earlybefore%22:10,%22periods%22:%5B%7B%22stime%22:%2208:00%22,%22etime%22:%2212:00%22%7D,%7B%22stime%22:%2213:00%22,%22etime%22:%2218:00%22%7D%5D%7D","shiftId":"29885fc9af485c19689790e1a4f61925","shiftName":"测试班次13","updatetime":"2020-10-30 13:56:40","workhours":9}]
         */

        private DeptarrangeBean deptarrange;
        private List<HolidaysBean> holidays;
        private List<ShiftsBean> shifts;

        public DeptarrangeBean getDeptarrange() {
            return deptarrange;
        }

        public void setDeptarrange(DeptarrangeBean deptarrange) {
            this.deptarrange = deptarrange;
        }

        public List<HolidaysBean> getHolidays() {
            return holidays;
        }

        public void setHolidays(List<HolidaysBean> holidays) {
            this.holidays = holidays;
        }

        public List<ShiftsBean> getShifts() {
            return shifts;
        }

        public void setShifts(List<ShiftsBean> shifts) {
            this.shifts = shifts;
        }

        public static class DeptarrangeBean {
            /**
             * deptId : 25800d7c497b89af06e3a0ba9e219697
             * holidayids : 1,162564b6288aa64a4323e61c7abddf94
             * shiftids : 2908d11ddf5898ccab4a224e11c87665,29885fc9af485c19689790e1a4f61925
             * shiftruleId : 1
             * updatetime : 2020-11-05 11:23:54
             */

            private String deptId;
            private String holidayids;
            private String shiftids;
            private String shiftruleId;
            private String updatetime;

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getHolidayids() {
                return holidayids;
            }

            public void setHolidayids(String holidayids) {
                this.holidayids = holidayids;
            }

            public String getShiftids() {
                return shiftids;
            }

            public void setShiftids(String shiftids) {
                this.shiftids = shiftids;
            }

            public String getShiftruleId() {
                return shiftruleId;
            }

            public void setShiftruleId(String shiftruleId) {
                this.shiftruleId = shiftruleId;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }

        public static class HolidaysBean {
            /**
             * enddate : 2020-10-08
             * holidayName : 国庆节
             * holidayid : 1
             * isdeleted : 0
             * startdate : 2020-10-01
             * updatetime : 2020-10-30 15:33:56
             */

            private String enddate;
            private String holidayName;
            private String holidayid;
            private String isdeleted;
            private String startdate;
            private String updatetime;

            public String getEnddate() {
                return enddate;
            }

            public void setEnddate(String enddate) {
                this.enddate = enddate;
            }

            public String getHolidayName() {
                return holidayName;
            }

            public void setHolidayName(String holidayName) {
                this.holidayName = holidayName;
            }

            public String getHolidayid() {
                return holidayid;
            }

            public void setHolidayid(String holidayid) {
                this.holidayid = holidayid;
            }

            public String getIsdeleted() {
                return isdeleted;
            }

            public void setIsdeleted(String isdeleted) {
                this.isdeleted = isdeleted;
            }

            public String getStartdate() {
                return startdate;
            }

            public void setStartdate(String startdate) {
                this.startdate = startdate;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }

        public static class ShiftsBean {
            /**
             * isdeleted : 0
             * shiftConfig : %7B%22field_workdays%22:%5B1,2,3,4,5,6,7%5D,%22periods%22:%5B%7B%22stime%22:%2208:30%22,%22etime%22:%2212:00%22%7D,%7B%22stime%22:%2213:00%22,%22etime%22:%2218:00%22%7D%5D%7D
             * shiftId : 2908d11ddf5898ccab4a224e11c87665
             * shiftName : 测试班次15
             * updatetime : 2020-10-30 14:00:50
             * workhours : 8.5
             */

            private String isdeleted;
            private String shiftConfig;
            private String shiftId;
            private String shiftName;
            private String updatetime;
            private double workhours;

            public String getIsdeleted() {
                return isdeleted;
            }

            public void setIsdeleted(String isdeleted) {
                this.isdeleted = isdeleted;
            }

            public String getShiftConfig() {
                return shiftConfig;
            }

            public void setShiftConfig(String shiftConfig) {
                this.shiftConfig = shiftConfig;
            }

            public String getShiftId() {
                return shiftId;
            }

            public void setShiftId(String shiftId) {
                this.shiftId = shiftId;
            }

            public String getShiftName() {
                return shiftName;
            }

            public void setShiftName(String shiftName) {
                this.shiftName = shiftName;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public double getWorkhours() {
                return workhours;
            }

            public void setWorkhours(double workhours) {
                this.workhours = workhours;
            }
        }
    }
}
