package com.navi.mini.program.base;

import com.navi.mini.program.common.Constant;

import java.io.Serializable;

/**
 * 类描述： Model基类
 * @author
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
	
	/**
	 * 删除标记:0为未删除,1为已删除
	 */
	private Integer isDelete = Constant.IsDelete.IS_NOT_DELETE;

	/**
	 * 创建人
	 */
	private Long createUserId;

	/**
	 * 创建时间
	 */
//	@JSONField(format =  "yyyy-MM-dd HH:mm:ss")
	private String createTime;
	
	/**
	 * 修改人
	 */
	private Long updateUserId;
	
	/**
	 * 修改时间
	 */
//	@JSONField(format =  "yyyy-MM-dd HH:mm:ss")
	private String updateTime;
	
	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 创建人名字
	 */
	private String createUserName;
	
	/**
	 * 修改人名称
	 */
	private String updateUserName;
	
	/**
	 * 查询时间
	 */
//	@JSONField(format =  "yyyy-MM-dd")
	private String creStartTime;
	
	/**
	 * 结束时间
	 */
//	@JSONField(format =  "yyyy-MM-dd")
	private String creEndTime;

	/**
	 * 公司主键
	 */
	private Long companyId;
	
	/**
	 * @return the createUserName
	 */
	public String getCreateUserName() throws Exception{
		return createUserName;
	}

	/**
	 * @param createUserName the createUserName to set
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	/**
	 * @return the updateUserName
	 */
	public String getUpdateUserName() throws Exception{
		return updateUserName;
	}

	/**
	 * @param updateUserName the updateUserName to set
	 */
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}


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

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Long getCreateUserId() throws Exception{
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Long getUpdateUserId() throws Exception{
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreStartTime() {
		return creStartTime;
	}

	public void setCreStartTime(String creStartTime) {
		this.creStartTime = creStartTime;
	}

	public String getCreEndTime() {
		return creEndTime;
	}

	public void setCreEndTime(String creEndTime) {
		this.creEndTime = creEndTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
