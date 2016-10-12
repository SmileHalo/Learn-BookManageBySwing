package com.swing.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Util 工具用于连接数据库
 * @author Halo
 *
 */
public class DbUtil {
	private String jdbcName="com.mysql.jdbc.Driver";
	private String DbUrl="jdbc:mysql://127.0.0.1:3306/db_book?useUnicode=true&characterEncoding=UTF-8";//?useUnicode=true&characterEncoding=UTF-8
	private String DbUserName="root";
	private String DbPassword="";
	
	/**
	 * 获取连接子程序
	 * @return 返回值为获取到的连接(Connection)
	 * @throws Exception
	 */
	public Connection getConn() throws Exception{
		Class.forName(jdbcName);
		Connection conn =DriverManager.getConnection(DbUrl, DbUserName, DbPassword);
		return conn;
	}
	/**
	 * 关闭数据库连接，connection占的资源最多。其他可以忽略不计。
	 * @param conn
	 * @throws Exception
	 */
	public void closeConn(Connection conn)throws Exception{
		if(conn!=null)conn.close(); //防止空指针异常
	}
	public static void main(String[] args) {
		DbUtil DbUtil=new DbUtil();
		try {
			DbUtil.getConn();
			System.out.println("成功");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
