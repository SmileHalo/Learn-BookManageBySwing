package com.swing.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.swing.dao.BookDao;
import com.swing.dao.BookTypeDao;
import com.swing.model.Book;
import com.swing.model.BookType;
import com.swing.util.DbUtil;
import com.swing.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookManageFrame extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTable table;
	JComboBox bookTypeCombo=null;
	JComboBox UpdateTypeCombo=null;
	Connection conn = null;
	DbUtil dbUtil = new DbUtil();
	BookDao bkDao = new BookDao();
	BookTypeDao bktpDao = new BookTypeDao();
	private JTextField idTxt;
	private JTextField bookNameTxt1;
	private JTextField priceTxt;
	private JTextField authorTxt1;
	private JTextField bookDescTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageFrame frame = new BookManageFrame();
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
	public BookManageFrame() {
		setClosable(true);
		setBounds(100, 100, 846, 747);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setToolTipText("\u641C\u7D22\u6761\u4EF6");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setToolTipText("");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 780, Short.MAX_VALUE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		JLabel lblId = new JLabel("Id:");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4E66\u540D:");
		
		bookNameTxt1 = new JTextField();
		bookNameTxt1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7C7B\u522B:");
		
		UpdateTypeCombo = new JComboBox();
		
		JLabel label_4 = new JLabel("\u4EF7\u683C:");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4F5C\u8005:");
		
		authorTxt1 = new JTextField();
		authorTxt1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u63CF\u8FF0:");
		
		bookDescTxt = new JTextField();
		bookDescTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAction(e);
			}
		});
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButtonAction(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblId)
						.addComponent(label_4)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(priceTxt, Alignment.LEADING)
								.addComponent(idTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
							.addGap(47)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookNameTxt1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(authorTxt1, 189, 189, 189))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(bookDescTxt, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(51)
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(UpdateTypeCombo, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
					.addGap(72))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(bookNameTxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(UpdateTypeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(authorTxt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(69, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addContainerGap())))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		bookTypeCombo = new JComboBox();
		
		JLabel label_1 = new JLabel("\u7C7B\u522B\u9009\u62E9:");
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryButtonAction(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				ClickTableAction(e);
//			}
//		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(78, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookTypeCombo, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(scrollPane)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(bookTypeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ClickTableAction(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4EF7\u683C", "\u4F5C\u8005", "\u56FE\u4E66\u7C7B\u522B", "\u56FE\u4E66\u63CF\u8FF0"
			}
		));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		tableInit(new Book());
		bookTypeComboInit();
	}

	protected void deleteButtonAction(ActionEvent e) {
		try {
			conn=dbUtil.getConn();
			if(bkDao.deleteBook(conn, Integer.parseInt(idTxt.getText()))>0){
			JOptionPane.showMessageDialog(null, "删除成功!");
			tableInit(new Book());
			}
		} catch (NumberFormatException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
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

	protected void UpdateAction(ActionEvent e) {
		if (StringUtil.isEmpty(bookNameTxt1.getText()) ||StringUtil.isEmpty(bookDescTxt.getText()) ||StringUtil.isEmpty(priceTxt.getText())||StringUtil.isEmpty(authorTxt1.getText())){
			JOptionPane.showMessageDialog(null, "不允许空内容!");
			return;
		}
		try {
			Book book=null;
			conn=dbUtil.getConn();
			ResultSet rs = bktpDao.queryBookTypes(conn,new BookType());
			while (rs.next()) {
				if(UpdateTypeCombo.getSelectedItem().equals(rs.getString("bookType"))){
					book = new Book(bookNameTxt1.getText(), Float.parseFloat(priceTxt.getText()), authorTxt1.getText(), bookDescTxt.getText(), rs.getString("bookType"), rs.getInt("id"));
					book.setId(Integer.parseInt(idTxt.getText()));
					break;
				}	
			}
			bkDao.updateBook(conn, book);
			JOptionPane.showMessageDialog(null, "修改成功");
			tableInit(new Book());
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

	protected void ClickTableAction(MouseEvent e) {
		int row = table.getSelectedRow();
		this.idTxt.setText((String) table.getValueAt(row, 0));
		this.bookNameTxt1.setText((String) table.getValueAt(row, 1));
		this.priceTxt.setText(table.getValueAt(row, 2).toString());
		this.authorTxt1.setText((String) table.getValueAt(row,3));
		this.UpdateTypeCombo.setSelectedItem((table.getValueAt(row, 4)));
		this.bookDescTxt.setText((String) table.getValueAt(row, 5));
	}

	protected void queryButtonAction(ActionEvent e) {
		Book book=new Book();
		book.setBookName(bookNameTxt.getText());
		book.setAuthor(authorTxt.getText());
		book.setBookTypeName((String) bookTypeCombo.getSelectedItem());
		tableInit(book);
	}

	private void bookTypeComboInit() {
		ResultSet rs = null;
		try {
			conn=dbUtil.getConn();
			rs = bktpDao.queryBookTypes(conn,new BookType());
			bookTypeCombo.addItem("");
			while (rs.next()){
				bookTypeCombo.addItem(rs.getString("bookType"));
				UpdateTypeCombo.addItem(rs.getString("bookType"));
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

	private void tableInit(Book book) {
		DefaultTableModel dtm= (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);//清空表格
		try {
			conn = dbUtil.getConn();
			ResultSet rs = bkDao.queryAllBooks(conn, book);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("author"));
				v.add(rs.getString("bookType"));
				v.add(rs.getString("bookDesc"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
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
