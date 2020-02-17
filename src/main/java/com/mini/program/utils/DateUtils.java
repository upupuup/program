
package com.mini.program.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    public static final String YYYY_YEAR_MM_MONTH_DD_DATE = "yyyy年MM月dd日";
    public static final String YYYY_BIAS_MM_BIAS_DD = "yyyy/MM/dd";
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String SS = "ss";
    
    public final static String FORMAT_YYMMDD = "yyyy-MM-dd";
    public final static String FORMAT_YYYYMMDD24HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public final static String FORMAT_NOLINE_YYMMDD = "yyyyMMdd";
    public final static String FORMAT_NOLINE_YYYYMMDD24HHMMSS = "yyyyMMddHHmmss";
    public final static String FORMAT_NOLINE_YYYYMMDD24HHMMSSSSS = "yyyyMMddHHmmssSSS";
    public final static String FORMAT_NOLINE_YYYYMMDD24HHMM = "yyyyMMddHHmm";
    public final static String FORMAT_24HHMMSS = "HH:mm:ss";
    public final static String FORMAT_24HHMM = "HH:mm";
    public final static String FORMAT_YYMM = "yyMM";
    public final static String FORMAT_YYYYMM = "yyyyMM";
    public final static String FOREVER_DATE_LINE = "2099-12-31 23:59:59";
    public final static String FORMAT_YYYY = "yyyy";
    public final static String FORMAT_MM = "MM";
    public final static String FORMAT_DD = "dd";
    public final static String FORMAT_HH = "HH";
    public final static String FORMAT_mm = "mm";
    public final static String FORMAT_YYYY_MM = "yyyy-MM";
    public final static long TWENTY_FOUR_HOURS = 86400000;

    private static SimpleDateFormat sdf = null;
    
    /**
     * 获取服务器当前默认时间
     * @author: 
     * @date: 2018年10月19日 下午2:06:43
     */
    public static Timestamp getDefaultSysDate() throws Exception {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取日期的格式
     * @author: 
     * @date: 2019年1月8日 下午1:56:55
     */
    public static SimpleDateFormat getDateFormate(String format) throws Exception{
    	if(StringUtils.isEmpty(format)){
    		format = FORMAT_YYYYMMDD24HHMMSS;
    	}
    	sdf = new SimpleDateFormat(format);
    	return sdf;
    }

    /**
     * 获取系统默认时间并按照format格式化
     * @author: 
     * @date: 2018年10月19日 下午1:55:41
     */
    public static String getDefaultSys() throws Exception {
    	return getDefaultSys(null);
    }
    
    /**
     * 获取系统默认时间并按照format格式化
     * @author: 
     * @date: 2018年10月19日 下午1:55:41
     */
    public static String getDefaultSys(String format) throws Exception {
    	// 判断format是否为空, 为空则默认的格式
    	if(StringUtils.isEmpty(format)){
    		format = FORMAT_YYYYMMDD24HHMMSS;
    	}
    	Timestamp time = getDefaultSysDate();
    	long now = time.getTime();
    	return DateFormatUtils.format(now, format);
    }

    /**
     * 时间格式转换
     * @author: 
     * @date: 2018年10月19日 下午1:55:51
     */
    public static String changeDateFormat(String dateString, String formate1, String formate2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(formate1);
        Date date = null;
        if (StringUtils.isBlank(dateString)) {
            date = new Date();
        } else {
            date = sdf.parse(dateString);
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat(formate2);
        return sdf2.format(date);
    }

   /**
    * 按照format格式化时间对象date
    * @author: 
    * @date: 2018年10月19日 下午1:56:01
    */
    public static String getFormatDate(Date date, String format) {
        if (null == date) {
        	date = new Date();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
    /**
     * 按照format格式化时间对象date
     * @author: 
     * @date: 2018年10月19日 下午1:56:01
     */
    public static Date getParseDate(Date date, String format) throws Exception {
        if (null == date) {
            date = new Date();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(date);
        return formatter.parse(dateString);
    }

    /**
     * 按照format格式化时间字符串dateString
     * @author: 
     * @date: 2018年10月19日 下午1:56:14
     */
    public static Date getFormatDate(String dateString, String format) throws ParseException {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(dateString);
    }

    /**
     * 获取指定时间类型的年-月-日时间
     * @author: 
     * @date: 2018年10月19日 下午1:56:24
     */
    public static String getYYYYMMDD(Date date) {
        return getFormatDate(date, FORMAT_YYMMDD);
    }

    /**
     * @param date
     * @return
     * @Function: com.asiainfo.busiframe.util.DateUtil::getYYMM
     * @Description: 该函数的功能描述
     * @version: v1.1.0
     */
    public static String getYYMM(Date date) {
        return getFormatDate(date, FORMAT_YYMM);
    }


    public static String getYYYYMM(Date date) {
        return getFormatDate(date, FORMAT_YYYYMM);
    }

    public static String getYYYY(Date date) {
        return getFormatDate(date, FORMAT_YYYY);
    }

    public static String getMM(Date date) {
        return getFormatDate(date, FORMAT_MM);
    }

    public static String getDD(Date date) {
        return getFormatDate(date, FORMAT_DD);
    }

   /**
    * 获取指定时间对象的[年-月-日   时：分：秒]时间
    * @author: 
    * @date: 2018年10月19日 下午1:56:45
    */
    public static String getYYYYMMDDHHMMSS(Date date) {
        return getFormatDate(date, FORMAT_YYYYMMDD24HHMMSS);
    }

    /**
     * 获取Date对象的年月日时间
     * @author: 
     * @date: 2018年10月19日 下午1:56:57
     */
    public static String getNoLineYYYYMMDD(Date date) {
        return getFormatDate(date, FORMAT_NOLINE_YYMMDD);
    }

    /**
     * 获取日期对象Date的年月日时分秒时间
     * @author: 
     * @date: 2018年10月19日 下午1:57:05
     */
    public static String getNoLineYYYYMMDDHHMISS(Date date) {
        return getFormatDate(date, FORMAT_NOLINE_YYYYMMDD24HHMMSS);
    }

    /**
     * 时：分：秒
     *
     * @param date
     * @return
     */
    public static String getHHMMSS(Date date) {
        return getFormatDate(date, FORMAT_24HHMMSS);
    }


    /**
     *  获取yyyy-MM-dd格式时间
     * @author: 
     * @date: 2018年10月19日 下午1:57:13
     */
    public static Timestamp getTimestampYYYYMMDD(String dateString) throws Exception {
        Date date = getFormatDate(dateString, FORMAT_YYMMDD);
        return new Timestamp(date.getTime());
    }

    /**
     * 获取yyyy-MM-dd格式时间
     * @author: 
     * @date: 2018年10月19日 下午1:57:19
     */
    public static Timestamp getNextTimestampByYYYYMMDD(String dateString) throws Exception {
        Date date = getFormatDate(dateString, FORMAT_YYMMDD);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        Date nextDate = cal.getTime();
        return new Timestamp(nextDate.getTime());
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss格式时间
     * @author: 
     * @date: 2018年10月19日 下午1:57:25
     */
    public static Timestamp getTimestampByYYYYMMDDHHMMSS(String dateString) throws Exception {
        Date date = getFormatDate(dateString, FORMAT_YYYYMMDD24HHMMSS);
        return new Timestamp(date.getTime());
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss格式时间
     * @author: 
     * @date: 2018年10月19日 下午1:57:36
     */
    public static Timestamp getTimestampByYYYYMMDD(String dateString) throws Exception {
        Date date = getFormatDate(dateString, FORMAT_YYMMDD);
        return new Timestamp(date.getTime());
    }

    /**
     * 获取HH:mm:ss格式时间
     * @author: 
     * @date: 2018年10月19日 下午1:57:42
     */
    public static Timestamp getTimestampByHHMMSS(String dateString) throws Exception {
        Date date = getFormatDate(dateString, FORMAT_24HHMMSS);
        return new Timestamp(date.getTime());
    }

    /**
     * 获取下月的开始时间
     * @author: 
     * @date: 2018年10月19日 下午1:57:49
     */
    public static Timestamp getDateOfNextMonthFirstDay(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(5, 1);
        rightNow.set(11, 0);
        rightNow.set(14, 0);
        rightNow.set(13, 0);
        rightNow.set(12, 0);
        rightNow.set(2, rightNow.get(2) + 1);
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 获取当前月的开始时间
     * @author: 
     * @date: 2018年10月19日 下午1:57:57
     */
    public static Timestamp getDateOfPreMonthFirstDay(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(5, 1);
        rightNow.set(11, 0);
        rightNow.set(14, 0);
        rightNow.set(13, 0);
        rightNow.set(12, 0);
        rightNow.set(2, rightNow.get(2) - 1);
        return new Timestamp(rightNow.getTimeInMillis());
    }
    
    /**
     * 获取当前月的最后时间
     * @author: 
     * @date: 2018年10月19日 下午1:58:03
     */
    public static Timestamp getDateOfCurrentMonthEndDay(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(5, rightNow.getActualMaximum(5));
        rightNow.set(11, 23);
        rightNow.set(14, 59);
        rightNow.set(13, 59);
        rightNow.set(12, 59);
        rightNow.set(2, rightNow.get(2));
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 获取当天的头一天最后时间
     * @author: 
     * @date: 2018年10月19日 下午1:58:10
     */
    public static Timestamp getPreLastDate(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(5, rightNow.get(5) - 1);
        rightNow.set(11, 23);
        rightNow.set(14, 59);
        rightNow.set(13, 59);
        rightNow.set(12, 59);
        rightNow.set(2, rightNow.get(2));
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 获取前一天的开始时间
     * @author: 
     * @date: 2018年10月19日 下午1:58:17
     */
    public static Timestamp getPreFirstDate(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(5, rightNow.get(5) - 1);
        rightNow.set(11, 0);
        rightNow.set(14, 0);
        rightNow.set(13, 0);
        rightNow.set(12, 0);
        rightNow.set(2, rightNow.get(2));
        return new Timestamp(rightNow.getTimeInMillis());
    }

    public static String timestampToString(Timestamp timestamp) throws Exception {
        Date date = timestamp;
        return DateUtils.dateToString(date);
    }


    /**
     * 获取次日最早时间
     * @author: 
     * @date: 2018年10月19日 下午1:58:26
     */
    public static Timestamp getNextDay(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(5, rightNow.get(5) + 1);
        rightNow.set(11, 0);
        rightNow.set(14, 0);
        rightNow.set(13, 0);
        rightNow.set(12, 0);
        rightNow.set(2, rightNow.get(2));
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * @Function: com.asiainfo.busiframe.util.DateUtil.java
     * @Description: 获取当前月第一天时间
     * @param:
     * @return：Timestamp
     * @throws：Exception
     * @version: v1.0.0
     * @author: zhouxin
     * @date: 2016年7月18日 下午3:19:26
     * <p>
     * <p>
     * Modification History:
     * Date           Author          Version            Description
     * ------------------------------------------------------------
     * 2016年7月18日      zhouxin         v1.1.0               修改原因
     */
    public static Timestamp getDateOfMonthFirstDay(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(5, 1);
        rightNow.set(11, 0);
        rightNow.set(14, 0);
        rightNow.set(13, 0);
        rightNow.set(12, 0);
        rightNow.set(2, rightNow.get(2));
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * @Function: com.asiainfo.busiframe.util.DateUtil.java
     * @Description: 获取当天开始时间
     * @param:
     * @return：Timestamp
     * @throws：Exception
     * @version: v1.0.0
     * @author: zhouxin
     * @date: 2016年7月18日 下午2:21:09
     * <p>
     * <p>
     * Modification History:
     * Date           Author          Version            Description
     * ------------------------------------------------------------
     * 2016年7月18日      zhouxin         v1.1.0               修改原因
     */
    public static Timestamp getTruncDate(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(11, 0);
        rightNow.set(14, 0);
        rightNow.set(13, 0);
        rightNow.set(12, 0);
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 获取当天最后时间
     * @author: 
     * @date: 2018年10月19日 下午1:58:51
     */
    public static Timestamp getDateOfCurrentEndDay(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(11, 23);
        rightNow.set(14, 59);
        rightNow.set(13, 59);
        rightNow.set(12, 59);
        rightNow.set(2, rightNow.get(2));
        return new Timestamp(rightNow.getTimeInMillis());
    }

    /**
     * 获取下月开始日期
     * @author: 
     * @date: 2018年10月19日 下午1:58:59
     */
    public static String getBeginningDateOfLastMonth(String dateString) {
        String lastYear = getLastYear(dateString);
        String lastMonth = getLastMonth(dateString);
        if ("01".equals(lastMonth)) {
            return lastYear + "-" + lastMonth + "-01 00:00:00";
        }
        return dateString.substring(0, 5) + lastMonth + "-01 " + "00:00:00";
    }

    /**
     * 获取当月结束时间
     * @author: 
     * @date: 2018年10月19日 下午1:49:18
     */
    public static int getEndDateOfCurMonth(String billingCycleId) throws ParseException, Exception {
        if ((StringUtils.isBlank(billingCycleId)) || (!(billingCycleId.matches("[0-9]{6}")))) {
            throw new Exception("");
        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date date = sdf.parse(billingCycleId);
        cal.setTime(date);
        cal.roll(5, false);
        return cal.get(5);
    }

    /**
     * 获取下一年年份
     * @author: 
     * @date: 2018年10月19日 下午1:49:25
     */
    public static String getLastYear(String dateString) {
        String currentYear = dateString.substring(0, 4);
        return String.valueOf(Integer.parseInt(currentYear) + 1);
    }

   /**
    * 获取下一月月份
    * @author: 
    * @date: 2018年10月19日 下午1:49:33
    */
    public static String getLastMonth(String dateString) {

        String currentMonth = dateString.substring(5, 7);
        if ("12".equals(currentMonth)) {
            currentMonth = "01";
        } else if (Integer.parseInt(currentMonth) > 10) {
            currentMonth = String.valueOf(Integer.parseInt(currentMonth) + 1);
        } else {
            currentMonth = "0" + String.valueOf(Integer.parseInt(currentMonth) + 1);
        }
        return currentMonth;
    }

    /**
     *  获取两个时间的相差月份
     * @author: 
     * @date: 2018年10月19日 下午1:49:43
     */
    public static int getMonthSpace(String dateString1, String dateString2) throws ParseException {

        int result = 0;

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(getFormatDate(dateString1, FORMAT_YYMMDD));
        c2.setTime(getFormatDate(dateString2, FORMAT_YYMMDD));

        if (c1.get(1) == c2.get(1)) {
            result = c2.get(2) - c1.get(2);
        } else {
            result = 12 * (c2.get(1) - c1.get(1)) + c2.get(2) - c1.get(2);
        }
        return ((result == 0) ? 0 : Math.abs(result));
    }

    /**
     *  获取两个时间的相差月份
     * @author: 
     * @date: 2018年10月19日 下午1:49:52
     */
    public static int getMonthSpace(Timestamp time1, Timestamp time2) throws ParseException {
        int result = 0;

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(time1);
        c2.setTime(time2);

        if (c1.get(1) == c2.get(1)) {
            result = c2.get(2) - c1.get(2);
        } else {
            result = 12 * (c2.get(1) - c1.get(1)) + c2.get(2) - c1.get(2);
        }
        return ((result == 0) ? 0 : Math.abs(result));
    }

    /**
     * 获取time加或减去月份之后的日期(month位正数则加，负数则减)
     * @author: 
     * @date: 2018年10月19日 下午1:50:01
     */
    public static Timestamp timeAddMonth(Timestamp time, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(2, month);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     *  获取ti加或减去年份份之后的日期
     * @author: 
     * @date: 2018年10月19日 下午1:50:13
     */
    public static Date addOrMinusYear(long ti, int i) throws Exception {
        Date rtn = null;
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(ti);
        cal.setTime(date);
        cal.add(1, i);
        rtn = cal.getTime();
        return rtn;
    }

    /**
     * 获取ti加或减去月份份之后的日期
     * @author: 
     * @date: 2018年10月19日 下午1:50:23
     */
    public static Date addOrMinusMonth(long ti, int i) throws Exception {
        Date rtn = null;
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(ti);
        cal.setTime(date);
        cal.add(2, i);
        rtn = cal.getTime();
        return rtn;
    }

    /**
     * 获取ti加或减去周之后的日期
     * @author: 
     * @date: 2018年10月19日 下午1:50:30
     */
    public static Date addOrMinusWeek(long ti, int i) {
        Date rtn = null;
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(ti);
        cal.setTime(date);
        cal.add(3, i);
        rtn = cal.getTime();
        return rtn;
    }

    /**
     * 获取ti加或减去天之后的日期
     * @author: 
     * @date: 2018年10月19日 下午1:50:40
     */
    public static Date addOrMinusDays(long ti, int i) {
        Date rtn = null;
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(ti);
        cal.setTime(date);
        cal.add(5, i);
        rtn = cal.getTime();
        return rtn;
    }

    /**
     * 获取date加或减去天之后的日期
     * @param date
     * @param format
     * @param i
     * @return
     * @throws Exception
     */
    public static String addOrMinusDays(String date,String format, int i) throws Exception {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        return getFormatDate(addOrMinusDays(getFormatDate(date, format).getTime(), i), format);
    }

    /**
     * 获取time加或减去天之后的日期
     * @author: 
     * @date: 2018年10月19日 下午1:50:48
     */
    public static Timestamp timeAddDay(Timestamp time, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(5, day);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     * 获取ti加或减去小时之后的日期
     * @author: 
     * @date: 2018年10月19日 下午1:50:56
     */
    public static Date addOrMinusHours(long ti, int i) {
        Date rtn = null;
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(ti);
        cal.setTime(date);
        cal.add(10, i);
        rtn = cal.getTime();
        return rtn;
    }

    /**
     * 获取ti加或减去分钟之后的日期
     * @author: 
     * @date: 2018年10月19日 下午1:51:07
     */
    public static Date addOrMinusMinutes(long ti, int i) {
        Date rtn = null;
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(ti);
        cal.setTime(date);
        cal.add(12, i);
        rtn = cal.getTime();
        return rtn;
    }

   /**
    * 获取ti加或减去秒之后的日期
    * @author: 
    * @date: 2018年10月19日 下午1:51:19
    */
    public static Date addOrMinusSecond(long ti, int i) {
        Date rtn = null;
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(ti);
        cal.setTime(date);
        cal.add(13, i);
        rtn = cal.getTime();
        return rtn;
    }

    /**
     * 比较2个日期（date）
     * @author: 
     * @date: 2018年10月19日 下午1:51:27
     */
    public static int compareTo(String date, String compareDate) throws Exception {
        int result;
        date = getFormatDate(getTimestampByYYYYMMDDHHMMSS(date), "yyyy-MM-dd HH:mm:ss");
        compareDate = getFormatDate(getTimestampByYYYYMMDDHHMMSS(compareDate), "yyyy-MM-dd HH:mm:ss");

        if (date.substring(0, 10).equals("2050-12-31") && compareDate.substring(0, 10).equals("2050-12-31")) {
            return 0;
        }
        result = date.compareTo(compareDate);
        return result;
    }


    /**
     * 比较日期（不带时分秒）
     * @author: 
     * @date: 2018年10月19日 下午1:51:35
     */
    public static int compareWithOutTime(String date, String compareDate) throws Exception {
        int result;
        date = getFormatDate(getTimestampByYYYYMMDD(date), "yyyy-MM-dd");
        compareDate = getFormatDate(getTimestampByYYYYMMDD(compareDate), "yyyy-MM-dd");

        if (date.equals("2050-12-31") && compareDate.equals("2050-12-31")) {
            return 0;
        }
        result = date.compareTo(compareDate);
        return result;
    }

    /**
     * 获取两个日期相差的天数
     * @author: 
     * @date: 2018年10月19日 下午1:51:44
     */
    public static int getIntervalDays(Date fromDate, Date toDate) throws Exception {
        if (fromDate == null || toDate == null) {
            return -1;
        }
        long intervalMilli = Math.abs(fromDate.getTime() - toDate.getTime());
        return (int) (intervalMilli / (24 * 60 * 60 * 1000));
    }

	/**
	 * 将date时间格式转为string时间格式
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String dateToString(Date date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.FORMAT_YYMMDD);
        return sdf.format(date);
	}

	/**
	 * 将date时间格式转为string时间格式(指定格式)
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String dateToString(Date date, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
	}

	/**
	 * 将String时间格式转为date时间格式
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date stringToDate(String date) throws Exception {
		SimpleDateFormat sdf= new SimpleDateFormat(DateUtils.FORMAT_YYMMDD);
		return sdf.parse(date);
	}

    /**
     * FORMAT_NOLINE_YYYYMMDD24HHMMSS = "yyyyMMddHHmmss"
     * @author: 
     * @date: 2018年10月19日 下午1:51:52
     */
    public static Timestamp getTimestampByNoLineYYYYMMDDHHMMSS(String dateString) throws Exception {
        try {
            Date date = getFormatDate(dateString, FORMAT_NOLINE_YYYYMMDD24HHMMSS);
            return new Timestamp(date.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * FORMAT_NOLINE_YYMMDD= "yyyyMMdd"
     * @author: 
     * @date: 2018年10月19日 下午1:52:03
     */
    public static Timestamp getTimestampByNoLineYYYYMMDD(String dateString) throws Exception {
        try {
            Date date = getFormatDate(dateString, FORMAT_NOLINE_YYMMDD);
            return new Timestamp(date.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 返回当月第一天
     * @author: 
     * @date: 2018年10月19日 下午1:52:11
     */
    public static String getDateOfMonthFirstDay(String format) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(5, 1);
        rightNow.set(11, 0);
        rightNow.set(14, 0);
        rightNow.set(13, 0);
        rightNow.set(12, 0);
        rightNow.set(2, rightNow.get(2));
        Date outDate = new Timestamp(rightNow.getTimeInMillis());
        return formatter.format(outDate);
    }

    /**
     * 返回当月最后一天
     * @author: 
     * @date: 2018年10月19日 下午1:52:19
     */
    public static String getDateOfCurrentMonthEndDay(String format) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(5, rightNow.getActualMaximum(5));
        rightNow.set(11, 23);
        rightNow.set(14, 59);
        rightNow.set(13, 59);
        rightNow.set(12, 59);
        rightNow.set(2, rightNow.get(2));
        Date outDate = new Timestamp(rightNow.getTimeInMillis());
        return formatter.format(outDate);
    }

    /**
     * 返回前一个月开始时间
     * @return
     * @throws Exception
     */
    public static String getDateOfLastMonthStartDay(String date) throws Exception {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前日期
        Calendar calendar = Calendar.getInstance();
        if (StringUtils.isNotBlank(date)) {
            Date date1 = sdf.parse(date);
            calendar.setTime(date1);
        }
        calendar.add(Calendar.MONTH, -1);
        //设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(calendar.getTime());
    }

    /**
     * 返回下个月结束时间
     * @return
     * @throws Exception
     */
    public static String getDateOfNextMonthEndDay(String date) throws Exception {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        if (StringUtils.isNotBlank(date)) {
            Date date1 = sdf.parse(date);
            calendar.setTime(date1);
        }
        // 设置后两个月
        calendar.add(Calendar.MONTH, 2);
        // 设置为月的最后一天
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return sdf.format(calendar.getTime());
    }

	/**
	 * 获取指定日期下一天
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getDateOfNextDay(String date) throws Exception {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当前日期
		Calendar calendar = Calendar.getInstance();
		if (StringUtils.isNotBlank(date)) {
			Date date1 = sdf.parse(date);
			calendar.setTime(date1);
		}
		// 设置为月的最后一天
		calendar.add(Calendar.DATE, 1);
		return sdf.format(calendar.getTime());
	}

    /**
     * 公历与农历转换方法 
     * @author: 
     * @date: 2018年10月19日 下午1:52:31
     */
    public static Date getLunarDate(Date date) throws Exception {
        String fm = "-";
        int year = Integer.parseInt(getYYYY(date));
        int month = Integer.parseInt(getMM(date));
        int day = Integer.parseInt(getDD(date));
        int[] lunar = solarToLunar(year, month, day);

        StringBuilder lunarDate = new StringBuilder();
        lunarDate.append(lunar[0]).append(fm).append(lunar[1]).append(fm)
                .append(lunar[2]);
        return getFormatDate(lunarDate.toString(), FORMAT_YYMMDD);
    }

    public static String getLunarMMDD(Date date, String format)
            throws Exception {
        Date lunarDate = getLunarDate(date);
        String fm = new String();
        if (StringUtils.isNotBlank(format)) {
            fm = format;
        }
        StringBuilder lunarStb = new StringBuilder();
        return lunarStb.append(getMM(lunarDate)).append(fm)
                .append(getDD(lunarDate)).toString();
    }

    public static String getLunarYYYYMMDD(Date date, String format)
            throws Exception {
        Date lunarDate = getLunarDate(date);
        String fm = new String();
        if (StringUtils.isNotBlank(format)) {
            fm = format;
        }
        StringBuilder lunarStb = new StringBuilder();
        return lunarStb.append(getYYYY(lunarDate)).append(fm).append(getMM(lunarDate))
                .append(fm).append(getDD(lunarDate)).toString();
    }

    /**
     * 支持转换的最小农历年份
     */
    public static final int MIN_YEAR = 1900;
    /**
     * 支持转换的最大农历年份
     */
    public static final int MAX_YEAR = 2099;

    /**
     * 公历每月前的天数
     */
    private static final int DAYS_BEFORE_MONTH[] = {0, 31, 59, 90, 120, 151,
            181, 212, 243, 273, 304, 334, 365};

    /**
     * 用来表示1900年到2099年间农历年份的相关信息，共24位bit的16进制表示，其中： 1. 前4位表示该年闰哪个月； 2.
     * 5-17位表示农历年份13个月的大小月分布，0表示小，1表示大； 3. 最后7位表示农历年首（正月初一）对应的公历日期。
     * <p>
     * 以2014年的数据0x955ABF为例说明： 1001 0101 0101 1010 1011 1111 闰九月 农历正月初一对应公历1月31号
     */
    private static final int LUNAR_INFO[] = {0x84B6BF,/* 1900 */
            0x04AE53, 0x0A5748, 0x5526BD, 0x0D2650, 0x0D9544, 0x46AAB9, 0x056A4D,
            0x09AD42, 0x24AEB6, 0x04AE4A,/* 1901-1910 */
            0x6A4DBE, 0x0A4D52, 0x0D2546, 0x5D52BA, 0x0B544E, 0x0D6A43,
            0x296D37, 0x095B4B, 0x749BC1, 0x049754,/* 1911-1920 */
            0x0A4B48, 0x5B25BC, 0x06A550, 0x06D445, 0x4ADAB8, 0x02B64D,
            0x095742, 0x2497B7, 0x04974A, 0x664B3E,/* 1921-1930 */
            0x0D4A51, 0x0EA546, 0x56D4BA, 0x05AD4E, 0x02B644, 0x393738,
            0x092E4B, 0x7C96BF, 0x0C9553, 0x0D4A48,/* 1931-1940 */
            0x6DA53B, 0x0B554F, 0x056A45, 0x4AADB9, 0x025D4D, 0x092D42,
            0x2C95B6, 0x0A954A, 0x7B4ABD, 0x06CA51,/* 1941-1950 */
            0x0B5546, 0x555ABB, 0x04DA4E, 0x0A5B43, 0x352BB8, 0x052B4C,
            0x8A953F, 0x0E9552, 0x06AA48, 0x6AD53C,/* 1951-1960 */
            0x0AB54F, 0x04B645, 0x4A5739, 0x0A574D, 0x052642, 0x3E9335,
            0x0D9549, 0x75AABE, 0x056A51, 0x096D46,/* 1961-1970 */
            0x54AEBB, 0x04AD4F, 0x0A4D43, 0x4D26B7, 0x0D254B, 0x8D52BF,
            0x0B5452, 0x0B6A47, 0x696D3C, 0x095B50,/* 1971-1980 */
            0x049B45, 0x4A4BB9, 0x0A4B4D, 0xAB25C2, 0x06A554, 0x06D449,
            0x6ADA3D, 0x0AB651, 0x095746, 0x5497BB,/* 1981-1990 */
            0x04974F, 0x064B44, 0x36A537, 0x0EA54A, 0x86B2BF, 0x05AC53,
            0x0AB647, 0x5936BC, 0x092E50, 0x0C9645,/* 1991-2000 */
            0x4D4AB8, 0x0D4A4C, 0x0DA541, 0x25AAB6, 0x056A49, 0x7AADBD,
            0x025D52, 0x092D47, 0x5C95BA, 0x0A954E,/* 2001-2010 */
            0x0B4A43, 0x4B5537, 0x0AD54A, 0x955ABF, 0x04BA53, 0x0A5B48,
            0x652BBC, 0x052B50, 0x0A9345, 0x474AB9,/* 2011-2020 */
            0x06AA4C, 0x0AD541, 0x24DAB6, 0x04B64A, 0x6a573D, 0x0A4E51,
            0x0D2646, 0x5E933A, 0x0D534D, 0x05AA43,/* 2021-2030 */
            0x36B537, 0x096D4B, 0xB4AEBF, 0x04AD53, 0x0A4D48, 0x6D25BC,
            0x0D254F, 0x0D5244, 0x5DAA38, 0x0B5A4C,/* 2031-2040 */
            0x056D41, 0x24ADB6, 0x049B4A, 0x7A4BBE, 0x0A4B51, 0x0AA546,
            0x5B52BA, 0x06D24E, 0x0ADA42, 0x355B37,/* 2041-2050 */
            0x09374B, 0x8497C1, 0x049753, 0x064B48, 0x66A53C, 0x0EA54F,
            0x06AA44, 0x4AB638, 0x0AAE4C, 0x092E42,/* 2051-2060 */
            0x3C9735, 0x0C9649, 0x7D4ABD, 0x0D4A51, 0x0DA545, 0x55AABA,
            0x056A4E, 0x0A6D43, 0x452EB7, 0x052D4B,/* 2061-2070 */
            0x8A95BF, 0x0A9553, 0x0B4A47, 0x6B553B, 0x0AD54F, 0x055A45,
            0x4A5D38, 0x0A5B4C, 0x052B42, 0x3A93B6,/* 2071-2080 */
            0x069349, 0x7729BD, 0x06AA51, 0x0AD546, 0x54DABA, 0x04B64E,
            0x0A5743, 0x452738, 0x0D264A, 0x8E933E,/* 2081-2090 */
            0x0D5252, 0x0DAA47, 0x66B53B, 0x056D4F, 0x04AE45, 0x4A4EB9,
            0x0A4D4C, 0x0D1541, 0x2D92B5 /* 2091-2099 */
    };

    /**
     * 将农历日期转换为公历日期
     *
     * @param year        农历年份
     * @param month       农历月
     * @param monthDay    农历日
     * @param isLeapMonth 该月是否是闰月 [url=home.php?mod=space&uid=7300]@return[/url]
     *                    返回农历日期对应的公历日期，year0, month1, day2.
     */
    public static final int[] lunarToSolar(int year, int month, int monthDay,
                                           boolean isLeapMonth) {
        int dayOffset;
        int leapMonth;
        int i;

        if (year < MIN_YEAR || year > MAX_YEAR || month < 1 || month > 12
                || monthDay < 1 || monthDay > 30) {
            throw new IllegalArgumentException(
                    "Illegal lunar date, must be like that:\n\t"
                            + "year : 1900~2099\n\t" + "month : 1~12\n\t"
                            + "day : 1~30");
        }

        dayOffset = (LUNAR_INFO[year - MIN_YEAR] & 0x001F) - 1;

        if (((LUNAR_INFO[year - MIN_YEAR] & 0x0060) >> 5) == 2)
            dayOffset += 31;

        for (i = 1; i < month; i++) {
            if ((LUNAR_INFO[year - MIN_YEAR] & (0x80000 >> (i - 1))) == 0)
                dayOffset += 29;
            else
                dayOffset += 30;
        }

        dayOffset += monthDay;
        leapMonth = (LUNAR_INFO[year - MIN_YEAR] & 0xf00000) >> 20;

        // 这一年有闰月
        if (leapMonth != 0) {
            if (month > leapMonth || (month == leapMonth && isLeapMonth)) {
                if ((LUNAR_INFO[year - MIN_YEAR] & (0x80000 >> (month - 1))) == 0)
                    dayOffset += 29;
                else
                    dayOffset += 30;
            }
        }

        if (dayOffset > 366 || (year % 4 != 0 && dayOffset > 365)) {
            year += 1;
            if (year % 4 == 1)
                dayOffset -= 366;
            else
                dayOffset -= 365;
        }

        int[] solarInfo = new int[3];
        for (i = 1; i < 13; i++) {
            int iPos = DAYS_BEFORE_MONTH[i];
            if (year % 4 == 0 && i > 2) {
                iPos += 1;
            }

            if (year % 4 == 0 && i == 2 && iPos + 1 == dayOffset) {
                solarInfo[1] = i;
                solarInfo[2] = dayOffset - 31;
                break;
            }

            if (iPos >= dayOffset) {
                solarInfo[1] = i;
                iPos = DAYS_BEFORE_MONTH[i - 1];
                if (year % 4 == 0 && i > 2) {
                    iPos += 1;
                }
                if (dayOffset > iPos)
                    solarInfo[2] = dayOffset - iPos;
                else if (dayOffset == iPos) {
                    if (year % 4 == 0 && i == 2)
                        solarInfo[2] = DAYS_BEFORE_MONTH[i]
                                - DAYS_BEFORE_MONTH[i - 1] + 1;
                    else
                        solarInfo[2] = DAYS_BEFORE_MONTH[i]
                                - DAYS_BEFORE_MONTH[i - 1];

                } else
                    solarInfo[2] = dayOffset;
                break;
            }
        }
        solarInfo[0] = year;

        return solarInfo;
    }

    /**
     * 将公历日期转换为农历日期，且标识是否是闰月
     * @author: 
     * @date: 2018年10月19日 下午1:52:57
     */
    public static final int[] solarToLunar(int year, int month, int monthDay) {
        int[] lunarDate = new int[4];
        Date baseDate = new GregorianCalendar(1900, 0, 31).getTime();
        Date objDate = new GregorianCalendar(year, month - 1, monthDay)
                .getTime();
        int offset = (int) ((objDate.getTime() - baseDate.getTime()) / 86400000L);

        // 用offset减去每农历年的天数计算当天是农历第几天
        // iYear最终结果是农历的年份, offset是当年的第几天
        int iYear, daysOfYear = 0;
        for (iYear = MIN_YEAR; iYear <= MAX_YEAR && offset > 0; iYear++) {
            daysOfYear = daysInLunarYear(iYear);
            offset -= daysOfYear;
        }
        if (offset < 0) {
            offset += daysOfYear;
            iYear--;
        }

        // 农历年份
        lunarDate[0] = iYear;

        int leapMonth = leapMonth(iYear); // 闰哪个月,1-12
        boolean isLeap = false;
        // 用当年的天数offset,逐个减去每月（农历）的天数，求出当天是本月的第几天
        int iMonth, daysOfMonth = 0;
        for (iMonth = 1; iMonth <= 13 && offset > 0; iMonth++) {
            daysOfMonth = daysInLunarMonth(iYear, iMonth);
            offset -= daysOfMonth;
        }
        // 当前月超过闰月，要校正
        if (leapMonth != 0 && iMonth > leapMonth) {
            --iMonth;

            if (iMonth == leapMonth) {
                isLeap = true;
            }
        }
        // offset小于0时，也要校正
        if (offset < 0) {
            offset += daysOfMonth;
            --iMonth;
        }

        lunarDate[1] = iMonth;
        lunarDate[2] = offset + 1;
        lunarDate[3] = isLeap ? 1 : 0;

        return lunarDate;
    }

    /**
     * 传回农历year年month月的总天数
     * @author: 
     * @date: 2018年10月19日 下午1:53:09
     */
    final public static int daysInMonth(int year, int month) {
        return daysInMonth(year, month, false);
    }

    /**
     * 传回农历year年month月的总天数
     * @author: 
     * @date: 2018年10月19日 下午1:53:23
     */
    public static final int daysInMonth(int year, int month, boolean leap) {
        int leapMonth = leapMonth(year);
        int offset = 0;

        // 如果本年有闰月且month大于闰月时，需要校正
        if (leapMonth != 0 && month > leapMonth) {
            offset = 1;
        }

        // 不考虑闰月
        if (!leap) {
            return daysInLunarMonth(year, month + offset);
        } else {
            // 传入的闰月是正确的月份
            if (leapMonth != 0 && leapMonth == month) {
                return daysInLunarMonth(year, month + 1);
            }
        }

        return 0;
    }

    /**
     * 传回农历 year年的总天数
     * @param year 将要计算的年份
     * @return 返回传入年份的总天数
     */
    private static int daysInLunarYear(int year) {
        int i, sum = 348;
        if (leapMonth(year) != 0) {
            sum = 377;
        }
        int monthInfo = LUNAR_INFO[year - MIN_YEAR] & 0x0FFF80;
        for (i = 0x80000; i > 0x7; i >>= 1) {
            if ((monthInfo & i) != 0)
                sum += 1;
        }
        return sum;
    }

   /**
    * 传回农历 year年month月的总天数，总共有13个月包括闰月
    * @author: 
    * @date: 2018年10月19日 下午1:53:38
    */
    private static int daysInLunarMonth(int year, int month) {
        if ((LUNAR_INFO[year - MIN_YEAR] & (0x100000 >> month)) == 0)
            return 29;
        else
            return 30;
    }

    /**
     * 传回农历 year年闰哪个月 1-12 , 没闰传回 0
     * @author: 
     * @date: 2018年10月19日 下午1:53:46
     */
    private static int leapMonth(int year) {
        return ((LUNAR_INFO[year - MIN_YEAR] & 0xF00000)) >> 20;
    }

    public static void main(String[] args) throws Exception {
    	List<String> aList = findDates("2010-10-1", "2010-10-10");
    	for (String aString : aList) {
    		System.out.println(aString);
    	}

        System.out.println(compareDateReturnHour("2019-08-01 11:10:10", "2019-08-01 12:45:11"));
	}

	/**
	 * 比较2个日期字符串，返回时间差（小时,保留两位小数）
	 * @param dateStr 开始时间
	 * @param compareDateStr 结束时间
	 * @return
	 */
	public static double compareDateReturnHour(String dateStr, String compareDateStr) {
		long time = compareDate(dateStr, compareDateStr);
		return Double.valueOf(String.format("%.1f", time / 1000.0 / 60.0 / 60.0));
	}
	
	/**
	 * 比较2个日期字符串，返回时间差（分钟,取整）
	 * @param dateStr 开始时间
	 * @param compareDateStr 结束时间
	 * @return
	 */
	public static Integer compareDateReturnMin(String dateStr, String compareDateStr) {
		if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(compareDateStr)) {
			return null;
		}
		long time = compareDate(dateStr, compareDateStr);
		return Integer.valueOf((int) Math.ceil(time / 1000 / 60D));
	}
    /**
     * 比较2个日期字符串，返回时间差
     */
    public static long compareDate(String dateStr, String compareDateStr) {
        if (StringUtils.isEmpty(dateStr) && StringUtils.isEmpty(compareDateStr)) {
            return 0;
        }
        Date currentDate = new Timestamp(System.currentTimeMillis());

        Date date;
        try {
            date = DateUtils.getTimestampByYYYYMMDDHHMMSS(dateStr);
        } catch (Exception e) {
            date = currentDate;
        }

        Date compareDate;
        try {
            compareDate = DateUtils.getTimestampByYYYYMMDDHHMMSS(compareDateStr);
        } catch (Exception e) {
            compareDate = currentDate;
        }

        return compareDate.getTime() - date.getTime();
    }

    /**
     * 比较2个日期字符串，开始时间早于结束时间则返回false
     */
    public static boolean compareHHMM(String startTime, String endTime, String format) throws Exception {
		System.out.println(startTime + "-" + endTime);
		sdf = new SimpleDateFormat(format);
		if(sdf.parse(startTime).getTime() <= sdf.parse(endTime).getTime()){
			return true;
		}
		return false;
    }

    /**
     * 获取指定时间的0点
     * Author:dongls Date:2017年1月3日 下午5:24
     * @param date
     * @return
     */
    public static Date getClearDate(Date date){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(Calendar.HOUR_OF_DAY,0);
        rightNow.set(Calendar.MINUTE,0);
        rightNow.set(Calendar.SECOND,0);
        rightNow.set(Calendar.MILLISECOND,0);
        return rightNow.getTime();
    }

    public static String getFixedDate(String date1, String date2, boolean maxFlag) throws Exception {
        if (StringUtils.isEmpty(date1)) {
            if (StringUtils.isEmpty(date2) || maxFlag) { //返回大的时间
                return date2;
            } else {//返回小的时间
                return date1;
            }
        }
        if (StringUtils.isEmpty(date2)) {
            if (maxFlag) { //返回大的时间
                return date1;
            } else {//返回小的时间
                return date2;
            }
        }

        Date compireDate = getFormatDate(date1, "yyyy-MM-dd HH:mm:ss");
        Date date = getFormatDate(date2, "yyyy-MM-dd HH:mm:ss");
        if (compireDate.compareTo(date) > 0) {
            if (maxFlag) {
                return date1;
            } else {
                return date2;
            }
        } else {
            if (maxFlag) {
                return date2;
            } else {
                return date1;
            }
        }
    }
    
    /**
     * 获取两个时间之间的毫秒数
     * @author: 
     * @date: 2018年10月19日 下午1:53:57
     */
    public static long getMillionSeconds(Timestamp startDate, Timestamp endDate) throws Exception {
    	long millionSeconds = endDate.getTime() - startDate.getTime();
        return millionSeconds;
    }
    
    /**
     *  获取指定当前日期指定年份后的日期
     * @author: 
     * @date: 2018年10月19日 下午1:54:06
     */
    public static String getNextYearsNowDay(String format,int amount) throws Exception{
        Timestamp time = getDefaultSysDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(Calendar.YEAR, amount);
        return DateFormatUtils.format(cal.getTime(), format);
    }
    
    /**
     * 获取当前日期指定月份前或后的日期
     * @author: 
     * @date: 2018年10月19日 下午1:54:20
     */
    public static String getNextMonthsNowDay(String format,int amount) throws Exception{
        Timestamp time = getDefaultSysDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(Calendar.MONTH, amount);
        return DateFormatUtils.format(cal.getTime(), format);
    }
    
    public static int getMonthNum(Date date1,Date date2) {
        Calendar cal1=Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2=Calendar.getInstance();
        cal2.setTime(date2);
        return getMonthNum(cal1, cal2);
    }
    public static int getMonthNum(Calendar cal1,Calendar cal2) {
        return (cal1.get(Calendar.YEAR)-cal2.get(Calendar.YEAR))*12+(cal1.get(Calendar.MONTH)-cal2.get(Calendar.MONTH));
    }
    
    /**
     * 根据传入的字符串获取timestamp
     * @author: 
     * @date: 2018年10月19日 下午1:54:32
     */
    public static Timestamp getTimestampByNum(String dateString)throws Exception{
    	Timestamp ts = null;
    	if(StringUtils.isNotEmpty(dateString)){
    		ts = new Timestamp(Long.valueOf(dateString));
    	}else{
        	ts = new Timestamp(System.currentTimeMillis());
    	}
    	return ts;
    }
    
   /**
    * 获取指定日期的开始时间，即 00:00:00
    * @author: 
    * @date: 2018年10月19日 下午1:54:42
    */
    public static String getDateStart(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.set(11, 0);
        rightNow.set(14, 0);
        rightNow.set(13, 0);
        rightNow.set(12, 0);
        
        Date tDate =  rightNow.getTime();
        SimpleDateFormat srcFormatter = new SimpleDateFormat(FORMAT_YYYYMMDD24HHMMSS);
        
        return srcFormatter.format(tDate);
        
    }
   
    /**
     * 获取日期对象Date的年月日时分秒毫秒时间
     * @author: 
     * @date: 2018年10月19日 下午1:54:51
     */
    public static String getNoLineYYYYMMDDHHMISSSSS(Date date){
    	return getFormatDate(date, FORMAT_NOLINE_YYYYMMDD24HHMMSSSSS);
    }

    /**
     * 根据日期字符串获取这一日是周几  周日为1
     * @param date
     * @return
     */
    public static int dateToWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取日期的年或月或日或周等
     * @param date
     * @param type
     * @return
     */
    public static int getDate(Date date,int type){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(type);
    }
    public static int getDate(String date,int type) throws Exception{
        Calendar cal = Calendar.getInstance();
        cal.setTime(getFormatDate(date, FORMAT_YYMMDD));
        return cal.get(type);
    }

    /**
     * 时间的某个字段加减操作
     * @author: EM at 2019/12/18 15:41
     * @param date
     * @param type
     * @param val
     * @return
     */
    public static Date addDate(Date date,int type,int val){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(type, val);
        return instance.getTime();
    }

    /**
     * 给日期重新设置年月日等
     * @param date
     * @param type
     * @param val
     * @return
     */
    public static Date setDate(Date date,int type,int val){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(type,val);
        return instance.getTime();
    }
    public static Date setDate(int year,int month,int day,int hour, int min){
        Calendar instance = Calendar.getInstance();
        instance.set(year,month,day,hour,min);
        return instance.getTime();
    }
    public static Date setDate(int year,int month,int day){
        Calendar instance = Calendar.getInstance();
        instance.set(year,month,day);
        return instance.getTime();
    }

    /**
     * 返回某天所在月份的第几天，0为最后一天
     * @return
     * @throws Exception
     */
    public static String getDateOfMonth(String date,int day) throws Exception {
        sdf = new SimpleDateFormat(DateUtils.FORMAT_YYMMDD);
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        if (StringUtils.isNotBlank(date)) {
            Date date1 = sdf.parse(date);
            calendar.setTime(date1);
        }

        // 设置为月的最后一天
        if (day == 0) {
            day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return sdf.format(calendar.getTime());
    }
    
    /**
     * 获取某个时间段内所有的日期
     * @author: zhengzixiang
     * @date: 2019年7月29日 下午2:48:09
     */
    public static List<String> findDates(String startString, String endString) throws Exception{
    	Date startDate = getFormatDate(startString,"yyyy-MM-dd");
    	Date endDate = getFormatDate(endString,"yyyy-MM-dd");
    	List<String> dateList = new ArrayList<String>();
    	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    	dateList.add(getYYYYMMDD(startDate));
    	Calendar calBegin = Calendar.getInstance();
    	// 使用给定的 Date 设置此 Calendar 的时间
    	calBegin.setTime(startDate);
    	Calendar calEnd = Calendar.getInstance();
    	// 使用给定的 Date 设置此 Calendar 的时间
    	calEnd.setTime(endDate);
    	// 测试此日期是否在指定日期之后
    	if (startDate.after(endDate)) {
	    	while (endDate.before(calBegin.getTime())) {
	    		// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
	    		calBegin.add(Calendar.DAY_OF_MONTH, -1);
	    		dateList.add(sd.format(calBegin.getTime()));
	    	}
    	}else {
    		while (endDate.after(calBegin.getTime())) {
	    		// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
	    		calBegin.add(Calendar.DAY_OF_MONTH, 1);
	    		dateList.add(sd.format(calBegin.getTime()));
	    	}
    	}
    	return dateList;
    }
    
    /**
     * 获取当前时间前n天的日期
     * @author: zhengzixiang
     * @date: 2019年7月29日 下午2:48:09
     */
    public static String findFormerDate(Integer n) {
    	Calendar calendar = Calendar.getInstance();
    	Date now = new Date();
    	calendar.setTime(now);
    	calendar.add(Calendar.DATE, -n);
    	String dateString = getFormatDate(calendar.getTime(),"yyyy-MM-dd");
    	return dateString;
    }

    /**
     * 获取当前时间后n天的日期
     * @author: zhengzixiang
     * @date: 2019年7月29日 下午2:48:09
     */
    public static String findLastDate(Integer n) {
    	Calendar calendar = Calendar.getInstance();
    	Date now = new Date();
    	calendar.setTime(now);
    	calendar.add(Calendar.DATE, n);
    	String dateString = getFormatDate(calendar.getTime(),"yyyy-MM-dd");
    	return dateString;
    }

    /**
     * 获取当月天数
     * @author: jiangzhihong
     * @date: 2020/1/7 10:09
     * @param year 哪一年
     * @param month 哪个月
     * @return 天数
     */
    public static int getDaysByYearAndMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取当月天数
     * @author: jiangzhihong
     * @date: 2020/1/7 10:09
     * @param year 哪一年(String)
     * @param month 哪个月(String)
     * @return 天数
     */
    public static int getDaysByYearAndMonth(String year, String month) {
        int intYear = Integer.valueOf(year);
        int intMonth = Integer.valueOf(month);
        return getDaysByYearAndMonth(intYear, intMonth);
    }
}
