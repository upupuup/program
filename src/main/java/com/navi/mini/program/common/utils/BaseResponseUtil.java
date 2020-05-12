package com.navi.mini.program.common.utils;

import com.navi.mini.program.common.response.BaseResponse;

import java.util.Map;

/**
 * 获取一个公共返回的类
 * @author: miaojinyong
 */
public class BaseResponseUtil {
    public static BaseResponse getBaseResponse(String success, String tipMsg, Map<String, Object> data){
    	return new BaseResponse(success, tipMsg, data);
    }
    
}
