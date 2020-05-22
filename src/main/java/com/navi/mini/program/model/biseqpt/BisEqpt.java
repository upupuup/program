package com.navi.mini.program.model.biseqpt;

import com.navi.mini.program.common.model.BaseModel;
import lombok.Data;

@Data
public class BisEqpt extends BaseModel {
	private static final long serialVersionUID = 1L;
	
	/**
     *  设备编码
     */
	private String eqptId;
	/**
     *  设备名称
     */
	private String eqptName;
	/**
     *  创建人
     */
	private String createUsr;

	private String createTime;
	/**
     *  更新人
     */
	private String updUsr;
	/**
     *  更新时间
     */
	private String updTime;
	/**
     *  是否弃用
     */
	private Integer enable;
}