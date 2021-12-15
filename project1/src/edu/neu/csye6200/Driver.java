package edu.neu.csye6200;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import edu.neu.csye6200.controllers.AlertController;
import edu.neu.csye6200.controllers.RegistrationController;
import edu.neu.csye6200.controllers.StudentImmunizationController;
import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;
import edu.neu.csye6200.views.AlertView;
import edu.neu.csye6200.views.RegistrationView;
import edu.neu.csye6200.views.StudentImmunizationView;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class Driver {

	JFrame frame;
	StudentImmunizationView studentImmunizationView;
	RegistrationView registrationView;
	AlertView alertView;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver window = new Driver();
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
	public Driver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// init models
		Student studentModel = new Student();
		Teacher teacherModel = new Teacher();

		// init views
		// generate HomePage
		registrationView = new RegistrationView();
		studentImmunizationView = new StudentImmunizationView();
		alertView = new AlertView();
		generateHomePage();

		// init controllers
		RegistrationController registrationController = new RegistrationController(studentModel, registrationView);
		StudentImmunizationController studentImmunizationController = new StudentImmunizationController(studentModel,
				studentImmunizationView);
		AlertController alertController = new AlertController(studentModel, alertView);
	}

	/**
	 * Generate the base layout containing all the pages.
	 */
	public void generateHomePage() {
		// Base Frame
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Base Tabbed Layout
		JTabbedPane homeTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(homeTabbedPane, BorderLayout.CENTER);

		// 1. Registration Page
		JPanel RegistrationPage = registrationView.initialize();
		homeTabbedPane.addTab("Registration", null, RegistrationPage, null);

		// 2. genStudentImmunizationPage
		JPanel StudentImmunizationPage = studentImmunizationView.initialize();
		homeTabbedPane.addTab("Student Immunization", null, StudentImmunizationPage, null);

		// 3. Information Page
		JPanel infoPanel = new JPanel();		
		infoPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerifyInputWhenFocusTarget(false);
		scrollPane.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		scrollPane.setBounds(415, 100, 950, 600);
		infoPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.window);
		
		JLabel lblNewLabel = new JLabel("Patrons Information Page");
		lblNewLabel.setMinimumSize(new Dimension(155, 13));
		lblNewLabel.setMaximumSize(new Dimension(155, 13));
		lblNewLabel.setPreferredSize(new Dimension(165, 13));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel.setBounds(415, 23, 950, 53);
		infoPanel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Student Details");
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statmentShowStudentList;
				try {
					statmentShowStudentList = a.createStatement();
					ResultSet rs = statmentShowStudentList.executeQuery("select * from student");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBorder(new LineBorder(SystemColor.scrollbar, 1, true));
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnNewButton_1.setBounds(111, 300, 182, 60);
		infoPanel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Teachers Details");
		btnNewButton_1_1.setForeground(SystemColor.window);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statmentShowStudentList;
				try {
					statmentShowStudentList = a.createStatement();
					ResultSet rs = statmentShowStudentList.executeQuery("select * from teacher");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnNewButton_1_1.setBorder(new LineBorder(SystemColor.scrollbar, 1, true));
		btnNewButton_1_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1_1.setBounds(111, 400, 182, 60);
		infoPanel.add(btnNewButton_1_1);
		homeTabbedPane.addTab("Information", null, infoPanel, null);

		// 4. Alerts Page
		JPanel alertsPanel = alertView.initialize();
		homeTabbedPane.addTab("Alerts", null, alertsPanel, null);
	}
}
