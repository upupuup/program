package com.navi.mini.program.model.hisretwo;

import com.navi.mini.program.common.model.BaseModel;
import lombok.Data;

@Data
public class HisRetWo extends BaseModel {
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private String id;
	
	/**
     *  唯一码
     */
	private String unqSeqId;
	/**
     *  送果单号
     */
	private String woNo;
	/**
     *  送果人
     */
	private String sendUsrId;
	/**
     *  等级
     */
	private String grade;
	/**
     *  果农
     */
	private String orchardist;
	/**
     *  质检员
     */
	private String qusrId;
	/**
     *  申请变更的码头信息
     */
	private String inWharfChanger;
	/**
     *  变更"小程序:X| WMS:W
     */
	private String opeEvtUsr;
	/**
     *  总箱数
     */
	private Integer cnt;
	/**
     *  总重量
     */
	private String wet;
	/**
     *  状态
     */
	private String status;
	/**
     *  送果码头信息
     */
	private String inWharf;
	/**
     *  evtUsr
     */
	private String evtUsr;
	/**
     *  evtTimestamp
     */
	private String evtTimestamp;
	/**
     *  startBoxTimestamp
     */
	private String startBoxTimestamp;
	/**
     *  stopBoxTimestamp
     */
	private String stopBoxTimestamp;

	/**
	 * 添加的方式：0：正常添加，1：码头更换添加，2：质检添加
	 */
	private Integer addType;

}