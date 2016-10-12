package com.swing.model;

public class Book {
	private String bookName;
	private float price;
	private String author;
	private String bookDesc;
	private String bookTypeName;
	private Integer bookTypeId;
	private Integer id;
	public Book(String bookName, float price, String author, String bookDesc, String bookTypeName, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.bookDesc = bookDesc;
		this.bookTypeName = bookTypeName;
		this.bookTypeId = bookTypeId;
	}

	public Book() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
