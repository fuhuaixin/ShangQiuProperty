package com.fhx.property.bean;

import java.util.List;

public class RulesGroupBean {


    /**
     * field_workdays : [1,2,3,4,5,6,7]
     * field_lateafter : 10
     * field_earlybefore : 10
     * periods : [{"stime":"08:00","etime":"12:00"},{"stime":"13:00","etime":"18:00"}]
     */
    private String rulesTitle;
    private int field_lateafter;
    private int field_earlybefore;
    private boolean field_checkLateAfter;
    private boolean field_checkEarlyBefore;
    private List<Integer> field_workdays;
    private List<PeriodsBean> periods;

    public String getRulesTitle() {
        return rulesTitle;
    }

    public void setRulesTitle(String rulesTitle) {
        this.rulesTitle = rulesTitle;
    }

    public boolean isField_checkLateAfter() {
        return field_checkLateAfter;
    }

    public void setField_checkLateAfter(boolean field_checkLateAfter) {
        this.field_checkLateAfter = field_checkLateAfter;
    }

    public boolean isField_checkEarlyBefore() {
        return field_checkEarlyBefore;
    }

    public void setField_checkEarlyBefore(boolean field_checkEarlyBefore) {
        this.field_checkEarlyBefore = field_checkEarlyBefore;
    }

    public int getField_lateafter() {
        return field_lateafter;
    }

    public void setField_lateafter(int field_lateafter) {
        this.field_lateafter = field_lateafter;
    }

    public int getField_earlybefore() {
        return field_earlybefore;
    }

    public void setField_earlybefore(int field_earlybefore) {
        this.field_earlybefore = field_earlybefore;
    }

    public List<Integer> getField_workdays() {
        return field_workdays;
    }

    public void setField_workdays(List<Integer> field_workdays) {
        this.field_workdays = field_workdays;
    }

    public List<PeriodsBean> getPeriods() {
        return periods;
    }

    public void setPeriods(List<PeriodsBean> periods) {
        this.periods = periods;
    }

    public static class PeriodsBean {
        /**
         * stime : 08:00
         * etime : 12:00
         */

        private String stime;
        private String etime;

        public String getStime() {
            return stime;
        }

        public void setStime(String stime) {
            this.stime = stime;
        }

        public String getEtime() {
            return etime;
        }

        public void setEtime(String etime) {
            this.etime = etime;
        }
    }

    @Override
    public String toString() {
        return "RulesGroupBean{" +
                "rulesTitle='" + rulesTitle + '\'' +
                ", field_lateafter=" + field_lateafter +
                ", field_earlybefore=" + field_earlybefore +
                ", field_checkLateAfter=" + field_checkLateAfter +
                ", field_checkEarlyBefore=" + field_checkEarlyBefore +
                ", field_workdays=" + field_workdays +
                ", periods=" + periods +
                '}';
    }
}
