package com.navi.mini.program.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {
    /**
     * 属性值复制，默认不复制null
     * @param source 源
     * @param target 目标
     * @author: ermeng
     */

	public static Object copyProperties(Object source, Object target, String... ignoreProperties) {
		if (source == null) {
			return target;
		}
		BeanUtils.copyProperties(source, target, ignoreProperties);
		return target;
	}

	public static <T> List<T> copyList(List sources, Class<T> clazz) {
		return copyList(sources, clazz, null);
	}

	public static <T> List<T> copyList(List sources, Class<T> clazz, Callback<T> callback) {
		List<T> targetList = new ArrayList<>();
		if (sources != null) {
			try {
				for (Object source : sources) {
					T target = clazz.newInstance();
					copyProperties(source, target);
					if (callback != null) {
						callback.set(source, target);
					}
					targetList.add(target);
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return targetList;
	}

	public static interface Callback<T> {
		void set(Object source, T target);
	}

    /**
     * 属性值复制
     * @param source 源
     * @param target 目标
     * @param withNull 是否复制值为null的属性
     * @author: ermeng
     */
    public static void copyProperties(Object source, Object target,boolean withNull) throws NullPointerException, IllegalArgumentException, IllegalAccessException {
        if (source == target) {
            return;
        }
        if (source != null) {
            // 得到类对象
            Class sourceClass = source.getClass();
            Class targetClass = target.getClass();

            /**
             * 得到类中的所有属性集合
             */
            Field[] sPros = sourceClass.getDeclaredFields();
            Field[] tPros = targetClass.getDeclaredFields();
            for (int i = 0; i < sPros.length; i++) {
                Field s = sPros[i];

                s.setAccessible(true); // 设置些属性是可以访问的
                Object sVal = s.get(source);// 得到此属性的值

                for (int j = 0; j < tPros.length; j++) {
                    Field t = tPros[j];

                    t.setAccessible(true); // 设置些属性是可以访问的
                    // 属性名称和属性类型必须全部相同，才能赋值，且不为final修饰
                    if (s.getName().equals(t.getName())
                            && s.getType().toString().equals(t.getType().toString())
                            && !Modifier.isFinal(t.getModifiers())) {
                        if (withNull) {
                            t.set(target, sVal);
                        } else if (sVal != null) {
                            t.set(target, sVal);
                        }
                    }
                }
            }
        } else {
            throw new NullPointerException("source is null");
        }
    }

    /**\
     * 将主键字符串转成List
     * @param str
     * @return
     */
    public static List<Long> StrToList(String str) {
        // 将字符串的用户主键转化成list形式
        if (str != null && str != "") {
            List<Long> idList = new ArrayList<>();
            String[] userArr = str.split(",");
            for (int i = 0, size = userArr.length; i < size; i++) {
                idList.add(Long.valueOf(userArr[i].trim()));
            }
            return idList;
        }
        return null;
    }
    
    /**
     * 判断一个实体类是否每一项（不包含父类的属性）都为""或null，
     * 全都为""或null则返回true，否则返回false
     * @author: zhengzixiang
     * @date: 2020年1月2日 下午1:05:14
     */
    public static boolean isObjectFieldEmpty(Object obj) throws Exception {
    	Class<?> clazz = obj.getClass();  // 得到类对象
    	Field[] fs = clazz.getDeclaredFields(); // 得到属性集合
    	for (Field field : fs){            // 遍历属性
    		field.setAccessible(true); // 设置属性是可以访问的（私有的也可以）
    		if (field.get(obj) != null && field.get(obj) != ""){
    			if ("serialVersionUID".equals(field.getName())) {
    				continue;
    			}
    			return false;
    		}
    	}
    	return true;
    }

    /**
     * 两个数（Double）相加
     * @param num 第一个数
     * @param addNum 第二个数
     * @return
     */
    public static Double addTwoNum(Double num, Double addNum) {
        num = (num==null ? 0.0D : num);
        addNum = (addNum==null ? 0.0D : addNum);
        return BigDecimal.valueOf(num).add(BigDecimal.valueOf(addNum)).doubleValue();
    }

    /**
     * 两个数（Double）相减
     * @param num 第一个数
     * @param addNum 第二个数
     * @return
     */
    public static Double subTwoNum(Double num, Double addNum) {
        num = (num==null ? 0.0D : num);
        addNum = (addNum==null ? 0.0D : addNum);
        return BigDecimal.valueOf(num).subtract(BigDecimal.valueOf(addNum)).doubleValue();
    }

    /**
     * 处理整数求百分比
     * @Author: jiangzhihong
     * @CreateDate: 2020/4/22 22:56
     * @param num 一个整数
     * @param anotherNum 另一个整数
     * @return
     */
    public static Double solveIntegerPercent(Integer num, Integer anotherNum) throws Exception {
        num = (num==null ? 0 : num);
        // 判断分母不为空或者0
        if (anotherNum == null) {
            return 0.0;
        }
        if (anotherNum == 0) {
        	return 0.0;
		}

        return Double.valueOf(Math.round(1.0 * num / anotherNum * 10000.0)) / 100;
    }

	/**
	 * 处理整数相除
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/4/22 22:56
	 * @param num 一个整数
	 * @param anotherNum 另一个整数
	 * @return
	 */
    public static Double solveIntegerDiv(Integer num, Integer anotherNum) throws Exception {
        num = (num==null ? 0 : num);
        // 判断分母不为空或者0
        if (anotherNum == null) {
            return 0.0;
        }
        if (anotherNum == 0) {
        	return 0.0;
		}

        return solveDoubleDiv(1.0 * num, 1.0 * anotherNum);
    }

    /**
     * 处理double的数字求百分比
     * @param num 除数，分子
     * @param anotherNum 被除数，分母
     * @return
     * @throws Exception
     */
    public static Double solveDoublePercent(Double num, Double anotherNum) throws Exception {
        num = (num==null ? 0 : num);
        // 判断分母不为空或者0
        if (anotherNum == null) {
        	return 0.0;
            // throw new Exception("被除数不能为空");
        }

        if (anotherNum == 0) {
        	return 0.0;
			// throw new Exception("被除数不能为0");
		}

        return Double.valueOf(Math.round(1.0 * num / anotherNum * 10000.0)) / 100;
    }

	/**
	 * 处理double的数字相除
	 * @param num
	 * @param anotherNum
	 * @return
	 * @throws Exception
	 */
	public static Double solveDoubleDiv(Double num, Double anotherNum) throws Exception {
        num = (num==null ? 0 : num);
        // 判断分母不为空或者0
        if (anotherNum == null) {
        	return 0.0;
            // throw new Exception("被除数不能为空");
        }

        if (anotherNum == 0) {
        	return 0.0;
			// throw new Exception("被除数不能为0");
		}

        return Double.valueOf(Math.round(1.0 * num / anotherNum));
    }

    /**
     * 处理double的数字求百分比
     * @param num 除数，分子
     * @param anotherNum 被除数，分母
     * @param isCheckAnotherNum 是否在被除数为0或者null的时候抛异常，true：抛异常，false：直接返回0
     * @return
     * @throws Exception
     */
    public static Double solveDoublePercent(Double num, Double anotherNum, boolean isCheckAnotherNum) throws Exception {
        num = (num==null ? 0.0 : num);

        // 是否在被除数为0或者null的时候抛异常
        if (!isCheckAnotherNum) {
            return solveDoublePercent(num, anotherNum);
        }

        // 被除数为null或者为0，则这届返回0
        if (anotherNum == null) {
			throw new Exception("被除数不能为空");
        }

        if (anotherNum == 0) {
			throw new Exception("被除数不能为空");
		}
        return Double.valueOf(Math.round(num / anotherNum * 10000.0)) / 100;
    }

    /**
     * 两个数字相乘
     * @param num
     * @param anotherNum
     * @return
     * @throws Exception
     */
    public static Double solveTwoNumMultiply(Double num, Double anotherNum) throws Exception {
    	if (num == null) {
			return 0.0;
		}
		if (anotherNum == null) {
			return 0.0;
		}
        // 如果有一个数字有问题就返回0
        if (num == 0 || anotherNum == 0) {
            return 0.0D;
        }
        return BigDecimal.valueOf(num).multiply(BigDecimal.valueOf(anotherNum)).doubleValue();
    }

    /**
     * 两数（double）相加
     * @param num
     * @param anotherNum
     * @return
     * @throws Exception
     */
    public static Double solveTwoNumAdd(Double num, Double anotherNum) throws Exception {
        // 数字为空则用0来填充
        if (num == null) {
            num = 0.0D;
        }
        if (anotherNum == null) {
            anotherNum = 0.0D;
        }
        return BigDecimal.valueOf(num).add(BigDecimal.valueOf(anotherNum)).doubleValue();
    }

    /**
     * 两数（double）相减
     * @param num
     * @param anotherNum
     * @return
     * @throws Exception
     */
    public static Double solveTwoNumSubtract(Double num, Double anotherNum) throws Exception {
        // 数字为空则用0来填充
        if (num == null) {
            num = 0.0D;
        }
        if (anotherNum == null) {
            anotherNum = 0.0D;
        }
        return BigDecimal.valueOf(num).subtract(BigDecimal.valueOf(anotherNum)).doubleValue();
    }

    public static void main(String[] args) throws Exception {
//		System.out.println(solveDoublePercent(null, null, true));
		System.out.println(solveIntegerPercent(null, null));
		System.out.println(solveIntegerPercent(0, null));
		System.out.println(solveIntegerPercent(0, 0));
		System.out.println(solveIntegerPercent(null, 0));
		System.out.println(solveIntegerPercent(1, 2));

		System.out.println(solveDoublePercent(null, null, false));
		System.out.println(solveDoublePercent(null, null));
		System.out.println(solveDoublePercent(null, 0.0, false));
		System.out.println(solveDoublePercent(null, 0.0));
		System.out.println(solveDoublePercent(0.0, 0.0, false));
		System.out.println(solveDoublePercent(0.0, 0.0));
		System.out.println(solveDoublePercent(0.0, null, false));
		System.out.println(solveDoublePercent(0.0, null));
		System.out.println(solveDoublePercent(1.0, 2.0, false));
		System.out.println(solveDoublePercent(1.0, 2.0));

		System.out.println(solveTwoNumMultiply(null, null));
		System.out.println(solveTwoNumMultiply(null, 0.0));
		System.out.println(solveTwoNumMultiply(0.0, null));
		System.out.println(solveTwoNumMultiply(1.0, 2.0));
		System.out.println(solveTwoNumMultiply(0.0, 0.0));

		System.out.println(solveTwoNumAdd(null, null));
		System.out.println(solveTwoNumAdd(0.0, null));
		System.out.println(solveTwoNumAdd(null, 0.0));
		System.out.println(solveTwoNumAdd(0.0, 0.0));
		System.out.println(solveTwoNumAdd(1.0, 2.0));

		System.out.println(solveTwoNumMultiply(null, null));
		System.out.println(solveTwoNumMultiply(0.0, null));
		System.out.println(solveTwoNumMultiply(null, 0.0));
		System.out.println(solveTwoNumMultiply(0.0, 0.0));
		System.out.println(solveTwoNumMultiply(1.0, 2.0));
		System.out.println(solveStrNull("12"));

		String date = "2020-12";
		Integer day = Integer.valueOf(date.substring(date.length() - 2));
		System.out.println(day);

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.set(0, 3);
		for (int i = 0, length = list.size(); i < length; i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * 如果为null返回""
	 * @param str
	 * @return
	 */
	public static String solveStrNull(String str) {
		return str == null ? "" : str;
	}

	/**
	 * 如果为null返回0.0
	 * @param num
	 * @return
	 */
	public static Double solveDoubleNull(Double num) {
		return num == null ? 0.0D : num;
	}

	/**
	 * 如果为null返回0
	 * @param num
	 * @return
	 */
	public static Integer solveIntegerNull(Integer num) {
		return num == null ? 0 : num;
	}
}
