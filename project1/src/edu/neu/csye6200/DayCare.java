package edu.neu.csye6200;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JMenuBar;

public class DayCare {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DayCare window = new DayCare();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DayCare() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// FIRST NAME
		JLabel lblNewLabel = new JLabel("First Name: ");
		lblNewLabel.setBounds(80, 73, 90, 16);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(196, 68, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// Last Name
		lblNewLabel_1 = new JLabel("Last Name: ");
		lblNewLabel_1.setBounds(80, 104, 90, 16);
		frame.getContentPane().add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(196, 99, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(143, 149, 117, 29);
		frame.getContentPane().add(btnNewButton);

//		JButton btnNewButton = new JButton("Submit");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		
//		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}
}
