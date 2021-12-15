package edu.neu.csye6200;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTable;

import edu.neu.csye6200Backend.DBBasicConnection;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AlertFrame extends DBBasicConnection{

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlertFrame window = new AlertFrame();
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
	public AlertFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(1280, 800));
		frame.setBounds(100, 100, 747, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statmentShowStudentList;
				try {
					statmentShowStudentList = a.createStatement();
					ResultSet rs = statmentShowStudentList.executeQuery("SELECT s.studentname,s.age,s.fathername,s.mothername,s.address,s.phone,t.teachername,s.doj FROM teacher t INNER JOIN student s ON t.teacherid = s.teacherid");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(514, 50, 237, 65);
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(227, 252, 812, 371);
		frame.getContentPane().add(table);
	}
}
