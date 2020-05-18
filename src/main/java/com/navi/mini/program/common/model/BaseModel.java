package com.navi.mini.program.common.model;

import java.io.Serializable;

/**
 * 类描述： Model基类
 * @author miaojinyong
 */
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 第几页
	 */
	private int pageIndex;
	
	/**
	 * 页记录数
	 */
	private int pageSize;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
