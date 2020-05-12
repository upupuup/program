package com.navi.mini.program.common.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> getResponseSuccess() {
        return getResponse(1,"操作成功");
    }

    public static Map<String, Object> getResponseFail() {
        return getResponse(-1,"操作失败");
    }

    public static Map<String, Object> getResponse(int code, String msg) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }
    public static Map<String, Object> getResponse(String dataName,Object data) {
        Map<String, Object> result = getResponseSuccess();
        result.put(dataName, data);
        return result;
    }

    public static Map<String, Object> getResponseException(String msg) {
        return getResponse(-1,msg);
    }
}
