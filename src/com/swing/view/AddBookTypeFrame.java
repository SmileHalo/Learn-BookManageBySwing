package com.swing.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.swing.dao.BookTypeDao;
import com.swing.model.BookType;
import com.swing.util.DbUtil;

public class AddBookTypeFrame extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private JTextField bookTypeDescTxt;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddBookTypeFrame frame = new AddBookTypeFrame();
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
	public AddBookTypeFrame() {
		setTitle("\u6DFB\u52A0\u56FE\u4E66\u7C7B\u522B");
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextField();
		bookTypeDescTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0:");
		
		JButton button = new JButton("\u6DFB\u52A0\u56FE\u4E66\u7C7B\u522B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddBookTypeAction(e);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(bookTypeDescTxt, Alignment.LEADING)
							.addComponent(bookTypeNameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
					.addContainerGap(157, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(55)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	/**
	 * 添加图书类别
	 * @param e
	 * @throws Exception
	 */
	protected void AddBookTypeAction(ActionEvent e) throws Exception{
		if(this.bookTypeNameTxt.getText()==null || this.bookTypeNameTxt.getText()==null){
			JOptionPane.showMessageDialog(null, "两条信息均不能为空！");
		}
		BookType tmpbooktp=new BookType();
		BookTypeDao booktpdao=new BookTypeDao();
		DbUtil dbUtil = new DbUtil();
		Connection conn=dbUtil.getConn();
		BookType booktp=new BookType(this.bookTypeNameTxt.getText(),this.bookTypeDescTxt.getText());
		if(booktpdao.add(conn, booktp)>0){
			JOptionPane.showMessageDialog(null, "添加成功");
		}else{
			JOptionPane.showMessageDialog(null, "添加失败");
		}
		//		tmpbooktp.setBookType(bookType);
		
	}
}
