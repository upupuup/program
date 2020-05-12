package com.navi.mini.program.common.controller;

import com.navi.mini.program.common.utils.BaseResponseUtil;
import com.navi.mini.program.common.response.BaseResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述： Controller基类
 * @author: miaojinyong
 */
@Scope("prototype")
public class BaseController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 成功标记
 	 */
	public String code;

	/**
	 * 信息返回
	 */
	private String msg;

	/**
	 * 数据集合
	 */
	public volatile Map<String, Object> data = new HashMap<String,Object>();
	
    protected synchronized BaseResponse returnBaseResponse(){
    	synchronized(this.data){
    		if (StringUtils.isEmpty(code)){
        		code = "0000";
        	}
        	if (StringUtils.isEmpty(msg)){
        		msg = "成功";
        	} 
        	return BaseResponseUtil.getBaseResponse(code,msg,data);
    	}
    }
    
    /**
     * 设置默认的值，如操作用户编号，更新时间戳等
     * @param tipMsg
     */
    protected synchronized void error(String tipMsg) {
    	this.code = "9999";
    	this.msg = tipMsg;
    }

	/**
	 * 清空数据
	 */
	protected synchronized void clear(){
		synchronized(this.data){
			this.data.clear();
	    	this.code = null;
	    	this.msg = null;
		}
    }
    
}
