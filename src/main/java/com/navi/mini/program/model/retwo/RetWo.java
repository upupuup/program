package com.navi.mini.program.model.retwo;

import com.navi.mini.program.common.model.BaseModel;

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
     *  申请变更的码头
     */
	private String inWharfChanger;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setUnqSeqId(String unqSeqId) {
		this.unqSeqId = unqSeqId;
	}
	public String getUnqSeqId() {
		return this.unqSeqId;
	}
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	public String getWoNo() {
		return this.woNo;
	}
	public void setSendUsrId(String sendUsrId) {
		this.sendUsrId = sendUsrId;
	}
	public String getSendUsrId() {
		return this.sendUsrId;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGrade() {
		return this.grade;
	}
	public void setOrchardist(String orchardist) {
		this.orchardist = orchardist;
	}
	public String getOrchardist() {
		return this.orchardist;
	}
	public void setQusrId(String qusrId) {
		this.qusrId = qusrId;
	}
	public String getQusrId() {
		return this.qusrId;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public Integer getCnt() {
		return this.cnt;
	}
	public void setWet(String wet) {
		this.wet = wet;
	}
	public String getWet() {
		return this.wet;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return this.status;
	}
	public void setInWharf(String inWharf) {
		this.inWharf = inWharf;
	}
	public String getInWharf() {
		return this.inWharf;
	}
	public void setEvtUsr(String evtUsr) {
		this.evtUsr = evtUsr;
	}
	public String getEvtUsr() {
		return this.evtUsr;
	}
	public void setEvtTimestamp(String evtTimestamp) {
		this.evtTimestamp = evtTimestamp;
	}
	public String getEvtTimestamp() {
		return this.evtTimestamp;
	}
	public void setStartBoxTimestamp(String startBoxTimestamp) {
		this.startBoxTimestamp = startBoxTimestamp;
	}
	public String getStartBoxTimestamp() {
		return this.startBoxTimestamp;
	}
	public void setStopBoxTimestamp(String stopBoxTimestamp) {
		this.stopBoxTimestamp = stopBoxTimestamp;
	}
	public String getStopBoxTimestamp() {
		return this.stopBoxTimestamp;
	}
	public void setInWharfChanger(String inWharfChanger) {
		this.inWharfChanger = inWharfChanger;
	}
	public String getInWharfChanger() {
		return this.inWharfChanger;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getApprovalStatus() {
		return this.approvalStatus;
	}
	public void setApprovalResults(String approvalResults) {
		this.approvalResults = approvalResults;
	}
	public String getApprovalResults() {
		return this.approvalResults;
	}
	public void setApprovalComments(String approvalComments) {
		this.approvalComments = approvalComments;
	}
	public String getApprovalComments() {
		return this.approvalComments;
	}
}