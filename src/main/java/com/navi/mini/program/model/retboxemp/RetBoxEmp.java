package com.navi.mini.program.model.retboxemp;

import com.navi.mini.program.common.model.BaseModel;
import lombok.Data;

@Data
public class RetBoxEmp extends BaseModel {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 是否归还
	 */
	private String validFlg;
	
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

}