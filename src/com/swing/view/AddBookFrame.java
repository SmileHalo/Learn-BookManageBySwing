package com.swing.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.swing.dao.BookDao;
import com.swing.dao.BookTypeDao;
import com.swing.model.Book;
import com.swing.model.BookType;
import com.swing.util.DbUtil;
import com.swing.util.StringUtil;

public class AddBookFrame extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField priceTxt;
	private JTextField authorTxt;
	private JTextField bookDescTxt;
	JComboBox bookTypeCombo=null;
	BookDao bkDao=new BookDao();
	BookTypeDao booktpdao=new BookTypeDao();
	DbUtil dbUtil = new DbUtil();
	Connection conn = null;
	ResultSet rs=null;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddBookFrame frame = new AddBookFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddBookFrame() {
		setTitle("\u6DFB\u52A0\u56FE\u4E66");
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u4E66\u540D:");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4EF7\u683C:");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4F5C\u8005:");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		bookDescTxt = new JTextField();
		bookDescTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u63CF\u8FF0:");
		
		bookTypeCombo = new JComboBox();
		
		JLabel label_3 = new JLabel("\u9009\u62E9\u7C7B\u522B:");
		
		JButton addBook = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookAction(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1)
						.addComponent(lblNewLabel)
						.addComponent(label)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(bookDescTxt)
						.addComponent(authorTxt)
						.addComponent(priceTxt)
						.addComponent(bookNameTxt, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(label_3)
							.addGap(18)
							.addComponent(bookTypeCombo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(36))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addComponent(addBook, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(label_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(addBook, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		initBookTypeCombo(bookTypeCombo);
	}

	protected void addBookAction(ActionEvent e) {
		if (StringUtil.isEmpty(bookNameTxt.getText()) ||StringUtil.isEmpty(bookDescTxt.getText()) ||StringUtil.isEmpty(priceTxt.getText())||StringUtil.isEmpty(authorTxt.getText())){
			JOptionPane.showMessageDialog(null, "不允许空内容!");
			return;
		}
		try {
			Book book=null;
			conn=dbUtil.getConn();
			rs = booktpdao.queryBookTypes(conn,new BookType());
			while (rs.next()) {
				if(bookTypeCombo.getSelectedItem().equals(rs.getString("bookType"))){
					book = new Book(bookNameTxt.getText(), Float.parseFloat(priceTxt.getText()), authorTxt.getText(), bookDescTxt.getText(), rs.getString("bookType"), rs.getInt("id"));
					break;
				}	
			}
			bkDao.add(conn, book);
			JOptionPane.showMessageDialog(null, "添加成功");
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}finally{
			try {
				dbUtil.closeConn(conn);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		
	}

	private void initBookTypeCombo(JComboBox bookTypeCombo) {
//		BookTypeDao booktpdao=new BookTypeDao();
//		DbUtil dbUtil = new DbUtil();
//		Connection conn = null;
		try {
			conn=dbUtil.getConn();
			rs = booktpdao.queryBookTypes(conn,new BookType());
			while (rs.next()){
				bookTypeCombo.addItem(rs.getString("bookType"));
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeConn(conn);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
}
