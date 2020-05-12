package com.navi.mini.program.model.bisuser;

import com.navi.mini.program.common.model.BaseModel;

public class BisUser extends BaseModel {
	private static final long serialVersionUID = 1L;
	
	/**
     *  用户代码
     */
	private String usrId;
	/**
     *  唯一码
     */
	private String unqSeqId;
	/**
     *  密码
     */
	private String usrKey;
	/**
     *  姓名
     */
	private String usrName;
	/**
     *  部门代码
     */
	private String deptIdFk;
	/**
     *  1.管理员 2.质检员 3.送果人
     */
	private String usrHeadFlg;
	/**
     *  有效标识
     */
	private String validFlg;
	/**
     *  电话号码
     */
	private String usrPhs;
	/**
     *  微信昵称
     */
	private String wechat;
	/**
     *  微信身份码
     */
	private String token;
	/**
     *  evtUsr
     */
	private String evtUsr;
	/**
     *  evtTimestamp
     */
	private String evtTimestamp;
	
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getUsrId() {
		return this.usrId;
	}
	public void setUnqSeqId(String unqSeqId) {
		this.unqSeqId = unqSeqId;
	}
	public String getUnqSeqId() {
		return this.unqSeqId;
	}
	public void setUsrKey(String usrKey) {
		this.usrKey = usrKey;
	}
	public String getUsrKey() {
		return this.usrKey;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getUsrName() {
		return this.usrName;
	}
	public void setDeptIdFk(String deptIdFk) {
		this.deptIdFk = deptIdFk;
	}
	public String getDeptIdFk() {
		return this.deptIdFk;
	}
	public void setUsrHeadFlg(String usrHeadFlg) {
		this.usrHeadFlg = usrHeadFlg;
	}
	public String getUsrHeadFlg() {
		return this.usrHeadFlg;
	}
	public void setValidFlg(String validFlg) {
		this.validFlg = validFlg;
	}
	public String getValidFlg() {
		return this.validFlg;
	}
	public void setUsrPhs(String usrPhs) {
		this.usrPhs = usrPhs;
	}
	public String getUsrPhs() {
		return this.usrPhs;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getWechat() {
		return this.wechat;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getToken() {
		return this.token;
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
}