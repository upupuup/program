package com.navi.mini.program.model.retboxempno;

import com.navi.mini.program.common.model.BaseModel;
import lombok.Data;

@Data
public class RetBoxEmpNo extends BaseModel {
	private static final long serialVersionUID = 1L;
	
	/**
     *  规则：LYKX+YYYYMMDD+4位流水
     */
	private String retBoxEmpNo;
	/**
     *  申请人
     */
	private String reqUserId;
	/**
	 *  申请人姓名
	 */
	private String reqUsername;
	/**
     *  确认人
     */
	private String conUserId;
	/**
     *  出货道口
     */
	private String portId;
	/**
     *  审批状态C待审批|A审批中|O审批结束
     */
	private String approvalStatus;
	/**
	 *  审批状态名称：C待审批|A审批中|O审批结束
	 */
	private String approvalStatusName;
	/**
     *  审批结果：Y:同意|N:拒绝
     */
	private String approvalResults;
	/**
     *  审批意见
     */
	private String approvalComments;
	/**
     *  evtUsr
     */
	private String evtUsr;
	/**
     *  evtTimestamp
     */
	private String evtTimestamp;

	/**
	 * 托数
	 */
	private Integer palletNum;

	/**
	 * 箱数
	 */
	private Integer boxNum;

	/**
	 * 申请时间
	 */
	private String applyTime;

	/**
	 * 审批时间
	 */
	private String approveTime;

	/**
	 * 是否领取，Y：是，N：不是
	 */
	private String isGet;

}