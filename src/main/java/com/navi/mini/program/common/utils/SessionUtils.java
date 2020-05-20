package com.navi.mini.program.common.utils;

import com.navi.mini.program.common.constant.UserConstants;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Map;

/**
 * @Author: jiangzhihong
 * @CreateDate: 2019/7/15 9:40
 * @Version: 1.0
 * @Description: 用户登录之后要用的信息
 */
public class SessionUtils {

	public static HttpServletRequest getRequest(){
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	public static Object getCurrentUser() {
		return getSession().getAttribute(UserConstants.LOGIN_USER);
	}

	public static void setUserSession(Object user) {
		getSession().setAttribute(UserConstants.LOGIN_USER, user);
	}

	@SuppressWarnings("unchecked")
	public static Object getCurrentPermissions() {
		return getSession().getAttribute(UserConstants.USER_PERMISSIONS);
	}

	public static void setPermissionSession(Object list) {
		getSession().setAttribute(UserConstants.USER_PERMISSIONS, list);
	}

	public static Map<String, Object> currentUserToMap() {
		Object currentUser = getCurrentUser();
		if (null != currentUser) {
			// 返回map对象
			return BeanMap.create(currentUser);
		}
		return null;
	}

	/**
	 * 获取登录人id
	 * @return
	 */
	public static String getCurrentUserId() {
		Map<String, Object> map = currentUserToMap();
		// 判空
		if (CollectionUtils.isEmpty(map)) {
			return null;
		}
		return (String) map.get("usrId");
	}

	/**
	 * 获取当前用户
	 * @return
	 */
	public static String getCurrentUserName() {
		Map<String, Object> map = currentUserToMap();
		// 判空
		if (CollectionUtils.isEmpty(map)) {
			return null;
		}
		return (String) map.get("usrName");
	}

	/**
	 * 获取公司id
	 * @return
	 */
	public static Long getCompanyId() {
		Map<String, Object> map = currentUserToMap();
		// 判空
		if (CollectionUtils.isEmpty(map)) {
			return null;
		}
		return (Long) map.get("companyId");
	}

	/**
	 * 获取公司编号
	 * @return
	 */
	public static String getCompanyCode() {
		Map<String, Object> map = currentUserToMap();
		// 判空
		if (CollectionUtils.isEmpty(map)) {
			return null;
		}
		return (String) map.get("companyCode");
	}

	/**
	 * 获取公司名称
	 * @return
	 */
	public static String getCompanyName(){
		Map<String, Object> map = currentUserToMap();
		// 判空
		if (CollectionUtils.isEmpty(map)) {
			return null;
		}
		return (String) map.get("companyName");
	}

	/**
	 * 获取车间主键
	 * @return
	 */
	public static Long getShopId(){
		Map<String, Object> map = currentUserToMap();
		// 判空
		if (CollectionUtils.isEmpty(map)) {
			return null;
		}
		return (Long) map.get("shopId");
	}

	/**
	 * 获取班次主键
	 * @return
	 */
	public static Long getShiftId(){
		Map<String, Object> map = currentUserToMap();
		// 判空
		if (CollectionUtils.isEmpty(map)) {
			return null;
		}
		return (Long) map.get("shiftId");
	}
}
