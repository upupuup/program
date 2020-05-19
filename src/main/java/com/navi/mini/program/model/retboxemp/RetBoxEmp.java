package com.navi.mini.program.model.retboxemp;

import com.navi.mini.program.common.model.BaseModel;

public class RetBoxEmp extends BaseModel {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	/**
     *  箱号代码
     */
	private String boxNo;
	/**
     *  托号
     */
	private String palletId;
	/**
     *  申请人
     */
	private String reqUserId;
	/**
     *  确认人
     */
	private String conUserId;
	/**
     *  出货道口
     */
	private String portId;
	/**
     *  evtUsr
     */
	private String evtUsr;
	/**
     *  evtTimestamp
     */
	private String evtTimestamp;
	/**
     *  领箱单据号
     */
	private String retBoxEmpNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBoxNo(String boxNo) {
		this.boxNo = boxNo;
	}
	public String getBoxNo() {
		return this.boxNo;
	}
	public void setPalletId(String palletId) {
		this.palletId = palletId;
	}
	public String getPalletId() {
		return this.palletId;
	}
	public void setReqUserId(String reqUserId) {
		this.reqUserId = reqUserId;
	}
	public String getReqUserId() {
		return this.reqUserId;
	}
	public void setConUserId(String conUserId) {
		this.conUserId = conUserId;
	}
	public String getConUserId() {
		return this.conUserId;
	}
	public void setPortId(String portId) {
		this.portId = portId;
	}
	public String getPortId() {
		return this.portId;
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
	public void setRetBoxEmpNo(String retBoxEmpNo) {
		this.retBoxEmpNo = retBoxEmpNo;
	}
	public String getRetBoxEmpNo() {
		return this.retBoxEmpNo;
	}
}