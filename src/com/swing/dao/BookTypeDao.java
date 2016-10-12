package com.swing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.swing.model.BookType;
import com.swing.util.StringUtil;

public class BookTypeDao {
	/**
	 * 根据传入的类型查询 若传入空则显示所有
	 * @param conn
	 * @param bt
	 * @return
	 * @throws Exception
	 */
	
	public int DeleteBookType(Connection conn,String id)throws Exception{
		String sql = "delete from t_bookType where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	public int UpdateBookType(Connection conn,BookType bt)throws Exception{
		String sql = "update t_bookType set bookType=? , bookTypeDesc=? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bt.getBookType());
		pstmt.setString(2, bt.getBookTypeDesc());
		pstmt.setString(3, bt.getId());
		return pstmt.executeUpdate();
	}
	public ResultSet queryBookTypes(Connection conn,BookType bt)throws Exception{
		StringBuffer sb= new StringBuffer("select * from t_bookType");//考虑到后面要用到的 like查询  如果用setstring会出现错误。所以这里用StringBuffer SetString不识别百分号里面的问号
		if(!StringUtil.isEmpty(bt.getBookType())){
			sb.append(" where bookType like '%"+bt.getBookType()+"%'");
		}
		sb.append(" order by id");
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	public int add (Connection conn,BookType booktp)throws Exception{
		String sql = "insert into t_bookType(bookType,bookTypeDesc) values (?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, booktp.getBookType());
		pstmt.setString(2, booktp.getBookTypeDesc());
		return pstmt.executeUpdate();
	}
}
