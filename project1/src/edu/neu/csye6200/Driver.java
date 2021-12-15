package edu.neu.csye6200;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import edu.neu.csye6200.controllers.RegistrationController;
import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;
import edu.neu.csye6200.views.RegistrationView;
import edu.neu.csye6200.views.StudentImmunizationView;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Driver extends AlertFrame{

	JFrame frame;
	StudentImmunizationView studentImmunizationView;
	RegistrationView registrationView;

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
		generateHomePage();

		// init controllers
		RegistrationController registrationController = new RegistrationController(studentModel, registrationView);
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
		JPanel StudentImmunizationPage = (studentImmunizationView = new StudentImmunizationView()).initialize();
		homeTabbedPane.addTab("Student Immunization", null, StudentImmunizationPage, null);

		// 3. Information Page
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.orange);
		homeTabbedPane.addTab("Information", null, infoPanel, null);
		
		JButton btnNewButton = new JButton("Click for Upcoming Alert's");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlertFrame alertPage = new AlertFrame();
				alertPage.alertFrame.setVisible(true);
			}
		});
		homeTabbedPane.addTab("Alerts", null, btnNewButton, null);

	}

}
