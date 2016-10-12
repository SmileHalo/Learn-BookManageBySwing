package com.swing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.swing.model.Book;
import com.swing.util.StringUtil;

public class BookDao {
	
	public int add(Connection conn,Book book)throws Exception{
		String sql="insert into t_book(bookName,price,author,bookTypeId,bookDesc) values (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setFloat(2, book.getPrice());
		pstmt.setString(3, book.getAuthor());
		pstmt.setInt(4, book.getBookTypeId());
		pstmt.setString(5,book.getBookDesc());
		return pstmt.executeUpdate();
	}

	public ResultSet queryAllBooks(Connection conn,Book book)throws Exception{
		StringBuffer sql = new StringBuffer("select  tb.id,tb.bookName,tb.price,tb.author,tbt.bookType,tb.bookDesc from t_book tb,t_bookType tbt where tb.bookTypeId=tbt.id");
		if (!StringUtil.isEmpty(book.getBookName())){
			sql.append(" and bookName like '%"+book.getBookName()+"%'");
		}
		if(!StringUtil.isEmpty(book.getAuthor())){
			sql.append(" and author like '%"+book.getAuthor()+"%'");
		}
		if(!StringUtil.isEmpty(book.getBookTypeName())){
			sql.append(" and tbt.bookType like '%"+book.getBookTypeName()+"%'");
		}
		sql.append(" order by tb.id");
		PreparedStatement pstmt=conn.prepareStatement(sql.toString());
		return pstmt.executeQuery();
		
	}
	public int deleteBook(Connection conn,Integer id)throws Exception{
		String sql = "delete from t_book where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeUpdate();
	}
	public int updateBook(Connection conn,Book book)throws Exception{
		String sql = "update t_book set bookName=?,price=?,author=?,bookTypeId=?,bookDesc=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setFloat(2, book.getPrice());
		pstmt.setString(3, book.getAuthor());
		pstmt.setInt(4, book.getBookTypeId());
		pstmt.setString(5,book.getBookDesc());
		pstmt.setInt(6,book.getId());
		return pstmt.executeUpdate();
	}
}
