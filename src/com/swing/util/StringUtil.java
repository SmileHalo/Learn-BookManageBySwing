package com.swing.util;

/**
 * 字符串工具类
 * @author Halo
 *
 */
public class StringUtil {
	/**
	 * 判断字符串是否为空  为空返回真
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if (str==null || str.trim().equals(""))return true;
		return false;
	}
}
