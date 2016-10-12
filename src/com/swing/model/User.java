package com.swing.model;

/**
 * 用户实体
 * 
 * @author Halo
 *
 */
public class User {
	
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	private int id;
	private String userName;
	private String password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
