package com.swing.view;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.swing.dao.BookTypeDao;
import com.swing.model.BookType;
import com.swing.util.DbUtil;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManageFrame extends JInternalFrame {
	ResultSet rs=null;
	DbUtil DbUtil = new DbUtil();
	BookTypeDao btDao=new BookTypeDao();
	private JTable table;
	private JTextField bookTypeTxt;
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	private JTextField bookTypeDescTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageFrame frame = new BookTypeManageFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookTypeManageFrame() {
		setClosable(true);
		setBounds(100, 100, 538, 731);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u67E5\u8BE2\u7C7B\u522B\u540D:");
		
		bookTypeTxt = new JTextField();
		bookTypeTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryBookTypeByName(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setToolTipText("\u8868\u5355\u64CD\u4F5C");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
					.addGap(97))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(112)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bookTypeTxt, 149, 149, 149)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(22, 32, 18, 15);
		
		idTxt = new JTextField();
		idTxt.setBounds(44, 29, 66, 21);
		idTxt.setEnabled(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u7C7B\u522B\u540D\u79F0:");
		lblNewLabel.setBounds(128, 32, 54, 15);
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setBounds(200, 29, 94, 21);
		bookTypeNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		label_1.setBounds(22, 117, 60, 15);
		
		bookTypeDescTxt = new JTextField();
		bookTypeDescTxt.setBounds(92, 81, 202, 87);
		bookTypeDescTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				UpdateButtonAction(e);
			}
		});
		btnNewButton_1.setBounds(22, 197, 88, 37);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteButtonAction(e);
			}
		});
		btnNewButton_2.setBounds(218, 197, 76, 37);
		panel.setLayout(null);
		panel.add(btnNewButton_1);
		panel.add(btnNewButton_2);
		panel.add(label_1);
		panel.add(bookTypeDescTxt);
		panel.add(lblId);
		panel.add(idTxt);
		panel.add(lblNewLabel);
		panel.add(bookTypeNameTxt);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TableClickAction(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7C7B\u522Bid", "\u7C7B\u522B\u540D", "\u63CF\u8FF0"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		tableInit(new BookType());
		
	}
	protected void DeleteButtonAction(ActionEvent e) {
		Connection conn =null;
		try {
			conn=DbUtil.getConn();
			if(btDao.DeleteBookType(conn, this.idTxt.getText())>0){
				JOptionPane.showMessageDialog(null, "删除成功");
				tableInit(new BookType());
				this.idTxt.setText("");
				this.bookTypeNameTxt.setText("");
				this.bookTypeDescTxt.setText("");
			}else{
				JOptionPane.showMessageDialog(null, "删除失败");
			}
			
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}finally{
			try {
				DbUtil.closeConn(conn);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		
	}

	protected void UpdateButtonAction(ActionEvent e) {
		if(this.bookTypeNameTxt.getText()==null || this.bookTypeNameTxt.getText()==null){
			JOptionPane.showMessageDialog(null, "两条信息均不能为空！");
		}
		BookType bt = new BookType(this.bookTypeNameTxt.getText(),this.bookTypeDescTxt.getText());
		bt.setId(this.idTxt.getText());
		Connection conn =null;
		try {
			conn= DbUtil.getConn();
			if(btDao.UpdateBookType(conn, bt)>0){
				JOptionPane.showMessageDialog(null, "修改成功");
				tableInit(new BookType());
				this.idTxt.setText("");
				this.bookTypeNameTxt.setText("");
				this.bookTypeDescTxt.setText("");
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (HeadlessException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}finally{
			try {
				DbUtil.closeConn(conn);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}

	protected void TableClickAction(MouseEvent e) {
		int nowRow =table.getSelectedRow();
		this.idTxt.setText((String) table.getValueAt(nowRow, 0));
		this.bookTypeNameTxt.setText((String) table.getValueAt(nowRow, 1));
		this.bookTypeDescTxt.setText((String) table.getValueAt(nowRow, 2));
	}

	protected void queryBookTypeByName(ActionEvent e) {
		BookType bt = new BookType(this.bookTypeTxt.getText(),null);
		tableInit(bt);
	}

	private void tableInit(BookType bt){
		DefaultTableModel dtm= (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);//清空表格
		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			ResultSet rs = btDao.queryBookTypes(conn,bt);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookType"));
				v.add(rs.getString("bookTypeDesc"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			try {
				DbUtil.closeConn(conn);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
