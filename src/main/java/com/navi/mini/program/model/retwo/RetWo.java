package com.navi.mini.program.model.retwo;

import com.navi.mini.program.common.model.BaseModel;
import lombok.Data;

import java.util.List;

@Data
public class RetWo extends BaseModel {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
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
	 * 送果人姓名
	 */
	private String sendUserName;
	/**
     *  等级
     */
	private String grade;
	/**
     *  等级名称
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
     *  总箱数
     */
	private Integer cnt;
	/**
     *  总重量
     */
	private Double wet;
	/**
     *  状态
     */
	private String status;
	/**
	 * 存放状态list
	 */
	private List<String> statusList;
	/**
     *  状态名称
     */
	private String statusName;
	/**
     *  送果码头信息
     */
	private String inWharf;
	/**
	 * 送果码头名称
	 */
	private String inWharfName;
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
     *  申请变更的码头
     */
	private String inWharfChanger;
	/**
     *  申请变更的码头
     */
	private String inWharfChangerName;
	/**
     *  C待审批|A审批中|O审批结束
     */
	private String approvalStatus;
	/**
     *  Y:同意|N:拒绝
     */
	private String approvalResults;
	/**
     *  审批意见
     */
	private String approvalComments;

	/**
	 * 更换码头申请审批时间
	 */
	private String inWharfChangerTimestamp;
	/**
	 * 添加的方式：0：正常添加，1：码头更换添加，2：质检添加
	 */
	private Integer addType;

}