package com.navi.mini.program.model.retcurrentno;

import com.navi.mini.program.common.model.BaseModel;
import lombok.Data;

@Data
public class RetCurrentNo extends BaseModel {
	private static final long serialVersionUID = 1L;
	
	/**
     *  eqptNo
     */
	private String eqptNo;
	/**
	 * 当前日期
	 */
	private String todayDate;
	/**
	 * 码头名称
	 */
	private String eqptName;
	/**
     *  curNo
     */
	private Integer curNo;
	/**
     *  等待人数
     */
	private Integer waitNo;
	/**
     *  evtDatatime
     */
	private String evtDatatime;
	
}