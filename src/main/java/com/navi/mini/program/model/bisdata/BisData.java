package com.navi.mini.program.model.bisdata;

import com.navi.mini.program.common.model.BaseModel;
import lombok.Data;

@Data
public class BisData extends BaseModel {
	private static final long serialVersionUID = 1L;
	
	/**
     *  dataSeqId
     */
	private String dataSeqId;
	/**
     *  unqSeqId
     */
	private String unqSeqId;
	/**
     *  dataCate
     */
	private String dataCate;
	/**
     *  dataId
     */
	private String dataId;
	/**
     *  dataExt
     */
	private String dataExt;
	/**
     *  dataItem
     */
	private String dataItem;
	/**
     *  ext1
     */
	private String ext1;
	/**
     *  ext2
     */
	private String ext2;
	/**
     *  ext3
     */
	private String ext3;
	/**
     *  ext4
     */
	private String ext4;
	/**
     *  ext5
     */
	private String ext5;
	/**
     *  dataDesc
     */
	private String dataDesc;
	/**
     *  evtUsr
     */
	private String evtUsr;
	/**
     *  evtTimestamp
     */
	private String evtTimestamp;
}