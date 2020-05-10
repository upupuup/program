package com.navi.mini.program.common;

/**
 * @Description: [java类作用描述]
 * @Author: jiangzhihong
 * @CreateDate: 2020/2/16 19:54
 */
public class Constant {
    public static String APP_ID = "";
    public static String SECRET = "";
    public static String WE_CHAT_ACCESS_TOKEN = "";
    public static String TICKET_TOKEN = "";
    public static String URL =  "https://api.weixin.qq.com/sns/jscode2session?appid=#{0}&secret=#{1}&js_code=#{2}&grant_type=authorization_code";

    /**
     * 删除状态
     */
    public interface IsDelete {
        // 未删除
        public final static Integer IS_NOT_DELETE = 0;
        // 已删除
        public final static Integer IS_DELETE = 1;
    }

}
