package com.navi.mini.program.common.model;

import com.navi.mini.program.common.constant.Constant.PageHelperDefault;
import lombok.Data;

import java.io.Serializable;

/**
 * 类描述： Model基类
 * @author miaojinyong
 */
@Data
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

	/**
	 * 处理分页
	 * @param pageIndex
	 * @param pageSize
	 */
	public void solvePageIndexAndPageSize(int pageIndex, int pageSize) {
		if (pageIndex == 0) {
			this.setPageIndex(PageHelperDefault.PAGENUM);
		}else{
			this.setPageIndex(pageIndex);
		}
		if (pageSize == 0) {
			this.setPageSize(PageHelperDefault.PAGESIZE);
		}
	}
}
