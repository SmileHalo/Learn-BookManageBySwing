package com.swing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.swing.model.User;

/**
 * 用户 Dao
 * @author Halo
 *
 */
public class UserDao {
	/**
	 * 登录验证
	 * @param conn 传入的连接
	 * @param user 传入的用户
	 * @return 查询到的用户 弱没有查询到则为空
	 * @throws Exception
	 */
	public User Login(Connection conn,User user)throws Exception{
		User resultUser = null;
		String sql="select * from t_user where userName=? and password=?";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()){
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
}
