package com.swing.util;

/**
 * �ַ���������
 * @author Halo
 *
 */
public class StringUtil {
	/**
	 * �ж��ַ����Ƿ�Ϊ��  Ϊ�շ�����
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if (str==null || str.trim().equals(""))return true;
		return false;
	}
}
