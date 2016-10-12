package com.swing.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	JDesktopPane desktopPane=null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		menuBar.add(mnNewMenu);
		
		JMenu menu = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u6DFB\u52A0\u56FE\u4E66\u7C7B\u522B");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookTypeAction(e);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManage(e);
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6DFB\u52A0\u56FE\u4E66");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookAction(e);
			}
		});
		menu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookManageAction(e);
			}
		});
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IsExit(e);
			}
		});
		mnNewMenu.add(menuItem_4);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUsAction(e);
			}
		});
		menu_1.add(menuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		this.setExtendedState(MAXIMIZED_BOTH);
	}

	protected void bookManageAction(ActionEvent e) {
		BookManageFrame bkmf = new BookManageFrame();
		bkmf.setVisible(true);
		desktopPane.add(bkmf);
	}

	protected void addBookAction(ActionEvent e) {
		AddBookFrame abkf = new AddBookFrame();
		abkf.setVisible(true);
		desktopPane.add(abkf);
	}

	protected void BookTypeManage(ActionEvent e) {
		BookTypeManageFrame btmf = new  BookTypeManageFrame();
		btmf.setVisible(true);
		desktopPane.add(btmf);
		
	}

	protected void AddBookTypeAction(ActionEvent e) {
		AddBookTypeFrame AddBooktypeFrm = new AddBookTypeFrame();
		AddBooktypeFrm.setVisible(true);
		desktopPane.add(AddBooktypeFrm);
	}

	protected void IsExit(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(null, "是否退出系统？")==0){
			dispose();
		}
	}

	protected void AboutUsAction(ActionEvent e) {
		AboutUsFrame AboutUs =new AboutUsFrame();
		AboutUs.setVisible(true);
		desktopPane.add(AboutUs);
	
	}

}
