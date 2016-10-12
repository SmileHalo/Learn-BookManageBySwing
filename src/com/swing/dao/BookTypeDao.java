package com.swing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.swing.model.BookType;
import com.swing.util.StringUtil;

public class BookTypeDao {
	/**
	 * ���ݴ�������Ͳ�ѯ �����������ʾ����
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
		StringBuffer sb= new StringBuffer("select * from t_bookType");//���ǵ�����Ҫ�õ��� like��ѯ  �����setstring����ִ�������������StringBuffer SetString��ʶ��ٷֺ�������ʺ�
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
