package com.navi.mini.program.model.retlineup;

import com.navi.mini.program.common.model.BaseModel;
import lombok.Data;

@Data
public class RetLineUp extends BaseModel {
	private static final long serialVersionUID = 1L;
	
	/**
     *  qdate
     */
	private String qDate;
	/**
     *  qno
     */
	private Integer qNo;
	/**
     *  usrId
     */
	private String usrId;
	/**
     *  eqptNo
     */
	private String eqptNo;
	/**
	 * 等待人数
	 */
	private Integer waitNo;
	/**
	 * 码头名称
	 */
	private String eqptName;
	/**
     *  qstatus
     */
	private String qStatus;
	/**
     *  waitTime
     */
	private Integer waitTime;
	/**
     *  evtUsa
     */
	private String evtUsa;
	/**
     *  evtDatatime
     */
	private String evtDatatime;

}