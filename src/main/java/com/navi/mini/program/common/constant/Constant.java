package com.navi.mini.program.common.constant;

/**
 * @Description: [java类作用描述]
 * @Author: jiangzhihong
 * @CreateDate: 2020/2/16 19:54
 */
public class Constant {
    public static final String ERRORMSG = "";
	public static String APP_ID = "";
    public static String SECRET = "";
    public static String WE_CHAT_ACCESS_TOKEN = "";
    public static String TICKET_TOKEN = "";
    public static String URL =  "https://api.weixin.qq.com/sns/jscode2session?appid=#{0}&secret=#{1}&js_code=#{2}&grant_type=authorization_code";

    public static final int DEFAULT_INT = 0;
    /**
     * 删除标记:0为未删除,1为已删除
     */
    private Integer isDelete = IsDelete.IS_NOT_DELETE;

    public static final int DEFAULT_OPERATE_SUCCESS = 1;

    /**
     * 删除状态
     */
    public interface IsDelete {
        // 未删除
        public final static Integer IS_NOT_DELETE = 0;
        // 已删除
        public final static Integer IS_DELETE = 1;
    }


    /**
     * 分页默认值
     *
     * @ClassName: com.selltime.test.common.constant.Constant.java
     * @author: miaojinyong
     * @date: 2018年11月27日 下午9:41:17
     */
    public interface PageHelperDefault {

        /**
         * 首页，第一页
         */
        public final static int PAGENUM = 1;

        /**
         * 每页多少条
         */
        public final static int PAGESIZE = 10;
    }

    /**
     * 用户返回到前台的Key
     *
     * @author: miaojinyong
     */
    public interface ResultInfo {
        // 后台查询的数据用户返回给前台放在model中数据的key
        public final static String PAGE = "page";
        // 用于放单个数据的Key
        public final static String DATA = "data";
        // 用于放List数据的Key
        public final static String DATALIST = "dataList";
        // 用于点击按钮时跳转页面的类型
        public final static String TYPE = "type";
        // 数据字典下拉框返回值
        public final static String DICDATA = "dicData";
        // 数据字典下拉框返回值
        public final static String MENU_LIST = "menuList";
        // 返回按钮list
        public final static String BUTTON_LIST = "button";
    }

    /**
     * 操作类型
     */
    public interface OperationType {

        /**
         * 添加操作
         */
        public final static String ADD = "add";

        /**
         * 修改操作
         */
        public final static String UPDATE = "update";

    }

    /**
     * 关于用户的信息
     */
    public interface UserConstants {
        /**
         * session有效时间（毫秒）,24小时
         */
        public static final int TIME_OUT = 86400000;

        /**
         * 小程序
         */
        String MINI = "X";
    }

    /**
     * 关于标识
     */
    public interface Flag {

        /**
         * 有效标识
         */
        public static  final String VALID_FLAG = "Y";

        /**
         * 无效标识
         */
        public static  final String INVALID_FLAG = "N";
    }

    /**
     * 关于用户类型的信息
     */
    public interface UserType {
        /**
         * 管理员
         */
        public static final String MANAGER = "1";
        /**
         * 质检员
         */
        public static final String QUALITY_INSPECTOR = "2";
        /**
         * 送果员
         */
        public static final String SEND_FRUIT = "3";
        /**
         * 码头巡检员
         */
        public static final String WHARF_PERSONB = "4";

    }

    /**
     * 关于料单
     */
    public interface RetWork {

        /**
         * 当前的码头
         */
        public static final String CURRENT_WHARF = "current_wharf";
        /**
         * 更换的码头
         */
        public static final String CHANGE_WHARF = "change_wharf";

        /**
         * 正常添加 1：码头更换添加，2：码头更换审批添加，3：质检添加
         */
        public static final Integer ADD_TYPE_NORMAL = 0;
        /**
         * 更换码头添加
         */
        public static final Integer ADD_TYPE_CHANGE = 1;

        /**
         * 码头更换审批添加
         */
        public static final Integer ADD_TYPE_CHANGE_APPROVE = 2;
        /**
         * 质检添加
         */
        public static final Integer ADD_TYPE_INSPECTION = 3;
        /**
         * 状态
         */
        public static final String STATUS = "STAT";
        /**
         * 已质检
         */
        public static final String WAIT = "WAIT";
        /**
         * 投料中
         */
        public static final String INPR = "INPR";
        /**
         * 结算中
         */
        public static final String COMP = "COMP";
        /**
         * 已结算
         */
        public static final String CLOSE = "CLOSE";


    }

    /**
     * 关于审批
     */
    public interface Approve {
        /**
         * 审批状态，C:待审批
         */
        public static final String APPROVE_WAIT_STATUS = "C";
        /**
         * 审批状态，A:审批中
         */
        public static final String APPROVE_PENDING_STATUS = "A";
        /**
         * 审批状态，O:审批结束
         */
        public static final String APPROVE_END_STATUS = "O";
    }

    /**
     * 码头
     */
    public interface Equipment {

        /**
         * 是否弃用，是
         */
        public static final Integer ENABLE = 1;
        /**
         * 是否弃用，否
         */
        public static final Integer DISENABLE = 0;
    }

    /**
     *
     */
    public interface RetBoxEmpNo {
        /**
         * 托
         */
        public static final String PALLET = "PALL";
        /**
         * 托数
         */
        public static final String PALLETNUM = "PALLETNUM";
        /**
         * 箱数
         */
        public static final String BOXNUM = "BOXNUM";

    }
}
