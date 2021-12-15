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
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;

public class AlertFrame extends DBBasicConnection{

	JFrame alertFrame;
	public JTable table;
	private JScrollPane scrollPane;
	private JButton btnTeacherDetails;
	private JButton btnStudentImunization;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlertFrame window = new AlertFrame();
					window.alertFrame.setVisible(true);
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
		alertFrame = new JFrame();
		alertFrame.setMinimumSize(new Dimension(1280, 800));
		alertFrame.setBounds(100, 100, 747, 502);
		alertFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		alertFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Student Details");
		btnNewButton.setBorder(new LineBorder(SystemColor.controlShadow, 1, true));
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statmentShowStudentList;
				try {
					statmentShowStudentList = a.createStatement();
					ResultSet rs = statmentShowStudentList.executeQuery("select * from student where doj=current_date-355");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(128, 51, 237, 65);
		alertFrame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerifyInputWhenFocusTarget(false);
		scrollPane.setBackground(SystemColor.info);
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		scrollPane.setBounds(10, 190, 1246, 540);
		alertFrame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnTeacherDetails = new JButton("Teacher Details");
		btnTeacherDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Statement statmentShowStudentList;
				try {
					statmentShowStudentList = a.createStatement();
					ResultSet rs = statmentShowStudentList.executeQuery("select * from teacher where doj>=current_date-357");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTeacherDetails.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnTeacherDetails.setBorder(new LineBorder(SystemColor.controlShadow, 1, true));
		btnTeacherDetails.setBounds(891, 51, 237, 65);
		alertFrame.getContentPane().add(btnTeacherDetails);
		
		btnStudentImunization = new JButton("Student Imunization");
		btnStudentImunization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statmentShowStudentList;
				try {
					statmentShowStudentList = a.createStatement();
					ResultSet rs = statmentShowStudentList.executeQuery("select s.studentname, i.vaccinationname, i.doseno from immunizations i inner join student s on i.studentid = s.studentid");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnStudentImunization.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnStudentImunization.setBorder(new LineBorder(SystemColor.controlShadow, 1, true));
		btnStudentImunization.setBounds(509, 51, 237, 65);
		alertFrame.getContentPane().add(btnStudentImunization);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 10, 1246, 166);
		alertFrame.getContentPane().add(panel);
	}
}
