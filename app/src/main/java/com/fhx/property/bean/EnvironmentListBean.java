package com.fhx.property.bean;

import java.util.List;

public class EnvironmentListBean {

    /**
     * success : true
     * data : [{"dt":"2020-10-10T07:48:02.000+00:00","dataCo2":"94.5288351","devicename":"一层大厅","deviceno":"1000001","dataDim":"48.6684018","dataPm25":"86.8744941","deviceid":"1","dataCo1":"91.0304632"},{"dt":"2020-10-10T07:48:22.000+00:00","dataCo2":"76.3722915","devicename":"十八层电梯厅","deviceno":"1000002","dataDim":"28.5064604","dataPm25":"72.2288087","deviceid":"2","dataCo1":"68.6117432"},{"dt":"2020-10-10T07:48:42.000+00:00","dataCo2":"78.6249169","devicename":"十九层电梯厅","deviceno":"1000003","dataDim":"20.6085643","dataPm25":"76.9926825","deviceid":"3","dataCo1":"81.9205926"}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * dt : 2020-10-10T07:48:02.000+00:00
         * dataCo2 : 94.5288351
         * devicename : 一层大厅
         * deviceno : 1000001
         * dataDim : 48.6684018
         * dataPm25 : 86.8744941
         * deviceid : 1
         * dataCo1 : 91.0304632
         */

        private String dt;
        private String dataCo2;
        private String devicename;
        private String deviceno;
        private String dataDim;
        private String dataPm25;
        private String deviceid;
        private String dataCo1;
        private String dataTemp;

        public String getDataTemp() {
            return dataTemp;
        }

        public void setDataTemp(String dataTemp) {
            this.dataTemp = dataTemp;
        }

        public String getDt() {
            return dt;
        }

        public void setDt(String dt) {
            this.dt = dt;
        }

        public String getDataCo2() {
            return dataCo2;
        }

        public void setDataCo2(String dataCo2) {
            this.dataCo2 = dataCo2;
        }

        public String getDevicename() {
            return devicename;
        }

        public void setDevicename(String devicename) {
            this.devicename = devicename;
        }

        public String getDeviceno() {
            return deviceno;
        }

        public void setDeviceno(String deviceno) {
            this.deviceno = deviceno;
        }

        public String getDataDim() {
            return dataDim;
        }

        public void setDataDim(String dataDim) {
            this.dataDim = dataDim;
        }

        public String getDataPm25() {
            return dataPm25;
        }

        public void setDataPm25(String dataPm25) {
            this.dataPm25 = dataPm25;
        }

        public String getDeviceid() {
            return deviceid;
        }

        public void setDeviceid(String deviceid) {
            this.deviceid = deviceid;
        }

        public String getDataCo1() {
            return dataCo1;
        }

        public void setDataCo1(String dataCo1) {
            this.dataCo1 = dataCo1;
        }
    }
}
