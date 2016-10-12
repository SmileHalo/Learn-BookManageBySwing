package com.swing.model;

public class BookType {
	private String id;
	private String bookType;
	private String bookTypeDesc;
	
	public BookType() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public BookType(String bookType, String bookTypeDesc) {
		super();
		this.bookType = bookType;
		this.bookTypeDesc = bookTypeDesc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBookTypeDesc() {
		return bookTypeDesc;
	}

	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}

	
}
