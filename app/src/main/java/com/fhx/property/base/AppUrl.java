package com.fhx.property.base;

public class AppUrl {
    public static final String BASEURL = "http://192.168.10.50:8083/"; //测试(测试环境)
//    public static final String BASEURL = "http://192.168.10.241:8083/"; //正式(测试环境)2

    //通知公告 资讯 baseUrl
    public static final String NEWSTITLEURL ="http://192.168.10.50:8055/smartbuilding_light/#/newsshow?id=";


    //登录
    public static final String Login = BASEURL + "login/check";
    //退出
    public static final String Logout = BASEURL + "login/out";
    //查询个人信息
    public static final String UserInfo = BASEURL + "login/getLoginUserInfo";


    //获取各个监测设备最新数据
    public static final String EnvList = BASEURL + "env/list";

    //通知公告列表查询接口 内部通告: innerAnnounce  内部新闻: innerNews
    public static final String NewsList = BASEURL + "news/list";
    //通知公告列表详情接口
    public static final String NewsMsg = BASEURL + "news/detail";
    //报修类型列表查询接口
    public static final String RepairTypeList = BASEURL + "repairType/list";
    //添加报修信息
    public static final String RepairAdd = BASEURL + "repair/add";
    //撤回重新提交报修信息
    public static final String RepairReSubmit = BASEURL + "repair/reSubmit";
    //报修列表查询接口
    public static final String RepairList = BASEURL + "repair/list";
    //根据id获得报修及工单处理详情
    public static final String RepairDetail = BASEURL + "repair/detail";
    //删除报修信息
    public static final String RepairDel = BASEURL + "repair/del";
    //撤回报修信息
    public static final String RepairCancel = BASEURL + "repair/cancel";;
    //添加报修图片报修内容
    public static final String RepairModifyRepairInfo = BASEURL + "repair/modifyRepairInfo";
    //添加投诉图片报修内容
    public static final String ComplainModifyRepairInfo = BASEURL + "complaint/modifyComplaintInfo";

    //提交评价
    public static final String EvaluteSubmit = BASEURL + "evalute/submit";
    //查询评价
    public static final String EvaluteGet = BASEURL + "evalute/getDetailByOriginId";
    //部门父子结构整理
    public static final String DeptreeList = BASEURL + "dept/treeList";
    //根据部门id获得员工列表
    public static final String EmployeeFindDept = BASEURL + "employee/findListByDeptId";
    //根据id员工详情
    public static final String EmployeeDetail = BASEURL + "employee/detail";
    //填写请假单
    public static final String LeaveSubmit = BASEURL + "leave/submitLeaveBill";
    //获取请假单列表
    public static final String LeaveList = BASEURL + "leave/applicationList";
    //车辆列表分页查询接口
    public static final String CarList = BASEURL + "car/list";
    //根据车辆id获得详情
    public static final String CarDetail = BASEURL + "car/detail";

    //查询租户分页列表
    public static final String TenantByPage = BASEURL + "tenant/getTenantByPage";


    //考勤打卡
    public static final String AttendSign = BASEURL + "attend/record/sign";
    //考勤记录
    public static final String AttendRecordList = BASEURL + "attend/record/list";
    //考勤统计-员工
    public static final String AttendRecordStat = BASEURL + "attend/record/stat_emp";
    //考勤规则查询
    public static final String AttendRulesDept = BASEURL + "attend/rules/deptarrange";

    //图片上传功能
    public static final String ImageUpLoad = BASEURL + "news/upload";

    //查询与我相关工单列表
    public static final String MyProcess = BASEURL + "activiti/getMyProcess";
    //获取部门下级机构列表
    public static final String Department = BASEURL + "dept/getNextDepartments";
    //工单转派(至客服，部门经理，领班,工程师)
    public static final String OrderTransfer = BASEURL + "order/transferOrder";

    //



}
