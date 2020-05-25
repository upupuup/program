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
	 *  送果人
	 */
	private String sendUserName;
	/**
     *  等级
     */
	private String grade;
	/**
	 * 等级名称
	 */
	private String gradeName;
	/**
     *  果农
     */
	private String orchardist;
	/**
	 * 果农名称
	 */
	private String orchardistName;
	/**
     *  质检员
     */
	private String qusrId;
	/**
     *  申请变更的码头信息
     */
	private String inWharfChanger;
	/**
	 *  申请变更的码头名称
	 */
	private String inWharfChangerName;
	/**
	 * 码头名称
	 */
	private String inWharfName;
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
	 * 状态名称
	 */
	private String statusName;
	/**
     *  送果码头信息
     */
	private String inWharf;
	/**
     *  evtUsr
     */
	private String evtUsr;
	/**
     *  evtUsrName
     */
	private String evtUsrName;
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
	 * 添加的方式：0：正常添加，1：码头更换添加，2：码头更换审批添加，3：质检添加
	 */
	private Integer addType;

	/**
	 * 更换码头申请时间
	 */
	private String inWharfChangerTimestamp;

	/**
	 * 审批意见
	 */
	private String approvalComments;
	/**
	 * 审批结果
	 */
	private String approvalResults;
	/**
	 * 审批状态
	 */
	private String approvalStatus;

}