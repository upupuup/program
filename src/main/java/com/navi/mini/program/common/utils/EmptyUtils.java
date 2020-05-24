package com.navi.mini.program.common.utils;

import com.navi.mini.program.common.constant.Constant;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class EmptyUtils {
	
	// 判断String或其他类型部分
	
	/**
	 * 判断字符串是否为空
	 * @author: miaojy
	 * @date: 2018年2月26日 上午10:55:06
	 */
	public static void isEmpty(String strName,String str) throws Exception{
		// 判空
		if(StringUtils.isBlank(str)){
			throw new Exception(strName + "为空" );
		}
	}

	/**
	 * 判读Long类型的是否为空
	 * @author: miaojy
	 * @date: 2018年2月28日 下午12:55:34
	 */
	public static void isEmpty(String strName, Long str) throws Exception{
		if(null == str){
			throw new Exception(strName + "为空" );
		}
	}

	/**
	 * 判断主键是否为空
	 * @author: miaojy
	 * @date: 2018年2月28日 下午12:59:10
	 */
	public static void primaryIsEmpty(String strName,Long id) throws Exception{
		if(null == id || Constant.DEFAULT_INT == id){
			throw new Exception(strName + "为空" );
		}
	}

	/**
	 * 对Integer格式的进行判空处理
	 * @author: miaojy
	 * @date: 2018年2月28日 下午5:32:01
	 */
	public static void isEmpty(String strName,Integer str) throws Exception{
		if(null == str){
			throw new Exception(strName + "为空" );
		}
	}

	/**
	 * Integer必传，且不为负数
	 * @param strName
	 * @param str
	 * @throws Exception
	 */
	public static void isEmptyAndNegative(String strName,Integer str) throws Exception{
		isEmpty(strName,str);
		isNegative(strName,str);
	}
	/**
	 * Integer是否为负数
	 * @param strName
	 * @param str
	 */
	public static void isNegative(String strName,Integer str) throws Exception{
		if (null != str && str < 0) {
			throw new Exception(strName + "不能小于零");
		}
	}

	/**
	 * 判断字符串的长度是否过长
	 * @author: EM
	 * @date: 2018年2月26日 上午10:46:44
	 */
	public static void isLengthTooLong(String strName, String str, int length) throws Exception{
		// 判断长度
		if (!StringUtils.isBlank(str)) {
			if(str.trim().length() > length){
				throw new Exception(strName + "的长度超过了" + length + "位");
			}
		}
	}

	/**
	 * 判断字符串的非空且长度是否过长
	 * @author: miaojy
	 * @date: 2018年2月26日 上午10:46:44
	 */
	public static void isTooLong(String strName, String str, int length) throws Exception{
		// 判空
		isEmpty(strName,str);
		// 判断长度
		if(str.trim().length() > length){
			throw new Exception(strName + "的长度超过了" + length + "位");
		}
	}

	/**
	 * 判断字符串长度是否过长
	 * @author: miaojy
	 * @date: 2018年2月26日 上午10:46:44
	 * @param strName 传入字段名
	 * @param str 传入的字段
	 * @param length 最大长度
	 * @param flag 是否必填
	 * @throws Exception
	 */
	public static void isTooLong(String strName, String str, int length, boolean flag) throws Exception{
		if(flag){
			isTooLong(strName, str, length);
			return;
		}

		// 判空
		if (StringUtils.isBlank(str)) {
			return;
		}

		// 判断长度
		if(str.length() > length){
			throw new Exception(strName + "的长度超过了" + length + "位");
		}
	}
	
	// 判断对象部分
	
	/**
	 * 判断某个对象是否为空
	 * @author: miaojy
	 * @date: 2018年2月28日 下午1:07:12
	 */
	public static void isEmpty(String strName,Object obj) throws Exception{
		if(null == obj){
			throw new Exception(strName + "为空");
		}
	}

	/**
	 * 查询的某个对象是否存在
	 * @param strName
	 * @param obj
	 * @throws Exception
	 */
	public static void isExistObj(String strName,Object obj) throws Exception {
		if(null == obj){
			throw new Exception(strName + "不存在");
		}
	}
	// Map  的相关判断
	/**
	 * Map 判空
	 * @author: miaojy
	 * @date: 2018年3月1日 下午1:50:41
	 */
	public static void isEmpty(String strName,Map<String,Object> map) throws Exception{
		if(MapUtils.isEmpty(map)){
			throw new Exception(strName + "为空");
		}
	}
	
	
	// 判断集合部分
	/**
	 * 判空
	 * @author: miaojy
	 * @date: 2018年2月26日 下午4:59:28
	 */
	public static void isEmpty(String strName,Collection<Object> coll) throws Exception{
		if(CollectionUtils.isEmpty(coll)){
			throw new Exception("根据" + strName + "查询的结果为空");
		}
	}

	// 判断集合部分
	/**
	 * 判空前端集合参数
	 * @author: caiem
	 * @date: 2018年2月26日 下午4:59:28
	 */
	public static void isEmptyList(String strName, List coll) throws Exception{
		if(CollectionUtils.isEmpty(coll)){
			throw new Exception("请添加" + strName);
		}
	}
	
	/**
	 * 判空并且判断集合的大小是否为n
	 * @author: miaojy
	 * @date: 2018年2月26日 下午4:59:22
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sizeIsN(String strName, Collection coll, int n) throws Exception{
		// 判空
		isEmpty(strName,coll);
		// 判断大小
		if(coll.size()  != n){
			throw new Exception("根据" + strName + "查询的数据大小不为" + n);
		}
	}
	
	/**
	 * 判断某个字段的唯一性要求
	 * @author: miaojy
	 * @date: 2018年2月26日 下午10:07:19
	 */
	@SuppressWarnings("rawtypes")
	public static void unique(String strName,Collection coll) throws Exception{
		// 如果为空则直接返回
		if(CollectionUtils.isEmpty(coll)){
			return;
		}
		// 不为空,则需要判断大小
		if(coll.size() == 1){
			return;
		}
		// 不为空,且不唯一则说明不蛮子此字段的唯一性要求
		throw new Exception(strName + "字段的值不唯一");
	}
	
	/**
	 * 用户名或密码错误
	 * @author: miaojy
	 * @date: 2018年2月26日 下午11:08:30
	 */
	@SuppressWarnings("rawtypes")
	public static void errorAccountNameOrPwd(Collection coll) throws Exception{
		if(!CollectionUtils.isEmpty(coll)){
			return;
		}
		throw new Exception("用户名或密码错误");
	}
	
	/**
	 * 检查集合不为空且数量为1
	 * @param collection 集合
	 * @param message 返回信息
	 * @throws Exception
	 */
	public static void checkListEmptyAndSize(Collection collection, String message) throws Exception {
		if (CollectionUtils.isEmpty(collection)) {
			throw new Exception(message + "为空");
		}

		if (collection.size() > 1) {
			throw new Exception(message + "数量大于一个");
		}
	}

	/**
	 * 校验前端传来的格式是科学计数法
	 * @param doubleNumber 校验的数字
	 * @param length 最大长度
	 * @param decimalLength 保留几位小数
	 * @throws Exception
	 */
	public static Double checkScientificCounting(Double doubleNumber, int length, int decimalLength, String message) throws Exception {
		// 整数部分
		int number = length - decimalLength;
		// 判空
		EmptyUtils.isEmpty(message, doubleNumber);
		// 转成String类型，判断长度
		NumberFormat instance = NumberFormat.getInstance();
		// 设置小数点最大的位置
		instance.setMaximumFractionDigits(4);
		// 取消科学计数法
		instance.setGroupingUsed(false);
		String doubleNumberStr = instance.format(doubleNumber);
		System.out.println(doubleNumberStr + "==" + Double.valueOf(doubleNumberStr + ""));
		doubleNumberStr = doubleNumberStr.replace(",", "");
		// 获取小数点的位置
		int position = doubleNumberStr.indexOf(".");
		// 如果有小数点，位数就要加一位
		if (position != -1) {

			if (doubleNumberStr.length() > (length + 1)) {
				throw new Exception(message + "数字部分不能大于" + length + "位");
			}

			return Double.valueOf(doubleNumberStr);
		}

		// 没有小数点，说明位数就是最大长度
		if (doubleNumberStr.length() > number) {
			throw new Exception(message + "整数部分不能大于" + number + "位");
		}

		return Double.valueOf(doubleNumberStr);
	}

	/**
	 * 判断是空，那么这是为0.0
	 * @param num 数字（Double）
	 * @return
	 */
	public static Double doubleIsNullAndSetZero(Double num) {
		return num == null ? 0.0D : num;
	}

//	/**
//	 * 判断是否为空并且只有一条数据
//	 * @param coll
//	 * @param 状态
//	 */
//	public static void listIsNullAndSizeIsOne(Collection coll, String msg) throws Exception {
//		if (CollectionUtils.isEmpty(coll)) {
//			throw new Exception(msg + "为空");
//		}
//
//		if (coll.size() > 1) {
//			throw new Exception(msg + "数据不唯一");
//		}
//	}
}
