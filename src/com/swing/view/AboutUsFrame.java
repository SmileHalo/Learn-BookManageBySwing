package com.swing.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AboutUsFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUsFrame frame = new AboutUsFrame();
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
	public AboutUsFrame() {
		setClosable(true);
		setTitle("\u5173\u4E8E\u6211\u4EEC!");
		setBounds(100, 100, 450, 300);
		
		JLabel lblTestBy = new JLabel("Test By \u6C6A\u6D0B");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(171)
					.addComponent(lblTestBy)
					.addContainerGap(191, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(120)
					.addComponent(lblTestBy)
					.addContainerGap(136, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
