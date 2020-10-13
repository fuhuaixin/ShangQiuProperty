package com.fhx.property.base;

public class AppUrl {
    public static final String BASEURL = "http://192.168.10.50:8083/"; //测试(测试环境)
//    public static final String BASEURL = "http://117.160.157.90:8055/"; //正式(测试环境)2

    //登录
    public static final String Login = BASEURL + "login/check";

    //获取各个监测设备最新数据
    public static final String EnvList = BASEURL + "env/list";

    //通知公告列表查询接口
    public static final String NewsList = BASEURL + "news/list";

}
