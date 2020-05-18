package com.navi.mini.program.common.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则相关校验类
 * 
 * @author 周强
 *
 */
public class MatchUtils {

	/**
	 * 正则表达式：验证用户名
	 */
	public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,20}$";

	/**
	 * 正则表达式：验证密码
	 */
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";

	/**
	 * 正则表达式：验证手机号
	 */
	public static final String REGEX_MOBILE = "^1[3-9]\\d{9}$";

	/**
	 * 正则表达式：验证邮箱
	 */
	public static final String REGEX_EMAIL = "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$";

	
	/**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";
 
    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
 
    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
 
    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
	/**
	 * 公司编号校验，四位大写字母
	 */
	public static final String REGEX_COMPANY_CODE = "^[A-Z]{4}$";
	/**
	 * 正则表达式：价值，两位小数
	 */
	public static final String REGEX_WORTH = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$";

	/**
	 * 正则表达式： 科学计数法
	 */
	public static final  String REFEXSCIENTIFICNOTATION  = "^((-?\\d+.?\\d*)[Ee]{1}(-?\\d+))$";

	/**
	 * 正则表达式： 0-99之间整数
	 */
	public static final  String ZERO_NINETY_NINE  = "^([1-9]\\d|\\d|-1)$";

	/**
	 * 正在表达式：校验年月
	 */
	public static final String YYYY_MM_DATE = "^\\d{4}-\\d{2}$";

	/**
	 * @param regex
	 *            正则表达式字符串
	 * @param str
	 *            要匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 */
	public static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 校验年月
	 * @param str 年月
	 * @param b 是否必传
	 * @throws Exception
	 */
	public static void matchYearAndMonth(String str, boolean b) throws Exception {
		if (b) {
			EmptyUtils.isEmpty("", str);
		}
		if (!match(YYYY_MM_DATE, str)){
			throw new Exception("日期格式不正确");
		}
	}

	/**
	 * 验证手机号格式  b是否必传
	 */
	public static void matchTelephone( String str,boolean b) throws Exception{
		if (b){
			EmptyUtils.isEmpty("手机号",str);
		}
		if(StringUtils.isBlank(str)){
			return;
		}
		if (!match(REGEX_MOBILE,str)){
			throw new Exception("手机号码格式不正确");
		}
	}

	/**
	 * 验证邮箱格式  b是否必传
	 */
	public static void matchEmail( String str,boolean b) throws Exception{
		if (b){
			EmptyUtils.isEmpty("邮箱",str);
		}
		if(StringUtils.isBlank(str)){
			return;
		}
		if (!match(REGEX_EMAIL,str)){
			throw new Exception("邮箱格式不正确");
		}
	}

	/**
	 * 验证0-99z之间整数  (工龄)
	 * @param i
	 * @param b
	 * @throws Exception
	 */
	public static void matchDigital( Integer i,boolean b) throws Exception{
		if (b){
			EmptyUtils.isEmpty("工龄",i);
		}
		if(i == null){
			return;
		}
		if (!match(ZERO_NINETY_NINE,String.valueOf(i))){
			throw new Exception("工龄格式不正确,请输入0-99之间数字");
		}
	}

	/**
	 * 验证科学计数法
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static boolean matchScientificNotation( String str) throws Exception{
		return match(REFEXSCIENTIFICNOTATION,str);
	}

	/**
	 * 截取小数点后两位
	 * @author: jiangzhihong
	 * @date: 2020/1/8 14:03
	 * @param number 传入的参数
	 * @return
	 */
	public static Double subStringTwoDigitsAfterTheDecimalPoint (Double number) {
		return subStringSomeDigitsAfterTheDecimalPoint(number, 2);
	}

	/**
	 * 截取小数点后n位
	 * @author: jiangzhihong
	 * @date: 2020/1/8 14:03
	 * @param number 传入的参数
	 * @param someDigits 截取小数点后几位
	 * @return
	 */
	public static Double subStringSomeDigitsAfterTheDecimalPoint (Double number, int someDigits) {
		String numberStr = String.valueOf(number) + "00";
		int index = numberStr.indexOf(".");
		// 说明没有小数点
		if (index == -1) {
			return number;
		}
		// 截取字符串
		numberStr = numberStr.substring(0, index + 1 + someDigits);
		// 转成double
		return Double.valueOf(numberStr);
	}
}
