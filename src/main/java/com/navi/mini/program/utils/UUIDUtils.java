package com.navi.mini.program.utils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UUIDUtils {

	 public static String getUUID(){
         return UUID.randomUUID().toString().replace("-", "");
     }
	 
	 /**
	  * 产生主键
	  * @author:
	  * @date: 2018年11月27日 下午9:23:46
	  */
	 public static synchronized Long generatePrimaryKey() throws Exception{
		 // 生产yyyyMMddHHmmssSSS格式的时间
		 String formatDate = DateUtils.getFormatDate(new Date(), DateUtils.FORMAT_NOLINE_YYYYMMDD24HHMMSSSSS);
		 return 100L * Long.parseLong(formatDate) + Math.round(Math.random()*9000000000L +10000000000L);
	 }

	 // 获取验证码(字母和数字)
	 public static String getStringRandom(int length) {
		 String val = "";
		 Random random = new Random();

		 //参数length，表示生成几位随机数
		 for(int i = 0; i < length; i++) {

			 String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			 //输出字母还是数字
			 if( "char".equalsIgnoreCase(charOrNum) ) {
				 //输出是大写字母还是小写字母
				 int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				 val += (char)(random.nextInt(26) + temp);
			 } else if( "num".equalsIgnoreCase(charOrNum) ) {
				 val += String.valueOf(random.nextInt(10));
			 }
		 }
		 return val;
	 }

	// 获取验证码(数字)
	public static String getRandom(int length) {
		String val = "";
		Random random = new Random();

		//参数length，表示生成几位随机数
		for(int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}
}
