package com.swing.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Util ���������������ݿ�
 * @author Halo
 *
 */
public class DbUtil {
	private String jdbcName="com.mysql.jdbc.Driver";
	private String DbUrl="jdbc:mysql://127.0.0.1:3306/db_book?useUnicode=true&characterEncoding=UTF-8";//?useUnicode=true&characterEncoding=UTF-8
	private String DbUserName="root";
	private String DbPassword="";
	
	/**
	 * ��ȡ�����ӳ���
	 * @return ����ֵΪ��ȡ��������(Connection)
	 * @throws Exception
	 */
	public Connection getConn() throws Exception{
		Class.forName(jdbcName);
		Connection conn =DriverManager.getConnection(DbUrl, DbUserName, DbPassword);
		return conn;
	}
	/**
	 * �ر����ݿ����ӣ�connectionռ����Դ��ࡣ�������Ժ��Բ��ơ�
	 * @param conn
	 * @throws Exception
	 */
	public void closeConn(Connection conn)throws Exception{
		if(conn!=null)conn.close(); //��ֹ��ָ���쳣
	}
	public static void main(String[] args) {
		DbUtil DbUtil=new DbUtil();
		try {
			DbUtil.getConn();
			System.out.println("�ɹ�");
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
