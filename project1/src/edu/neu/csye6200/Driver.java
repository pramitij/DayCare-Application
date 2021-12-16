package edu.neu.csye6200;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import edu.neu.csye6200.controllers.AlertController;
import edu.neu.csye6200.controllers.InfoController;
import edu.neu.csye6200.controllers.RegistrationController;
import edu.neu.csye6200.controllers.StudentImmunizationController;
import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.models.Teacher;
import edu.neu.csye6200.views.AlertView;
import edu.neu.csye6200.views.InfoView;
import edu.neu.csye6200.views.RegistrationView;
import edu.neu.csye6200.views.StudentImmunizationView;
import javax.swing.JTable;

public class Driver {

	JFrame frame;
	StudentImmunizationView studentImmunizationView;
	RegistrationView registrationView;
	AlertView alertView;
	InfoView infoView;
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
		infoView = new InfoView();
		generateHomePage();

		// init controllers
		RegistrationController registrationController = new RegistrationController(studentModel, registrationView);
		StudentImmunizationController studentImmunizationController = new StudentImmunizationController(studentModel,
				studentImmunizationView);
		AlertController alertController = new AlertController(studentModel, alertView);
		InfoController infoController = new InfoController(studentModel, infoView);
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
		JPanel infoPanel = infoView.initialize();
		homeTabbedPane.addTab("Information", null, infoPanel, null);

		// 4. Alerts Page
		JPanel alertsPanel = alertView.initialize();
		homeTabbedPane.addTab("Alerts", null, alertsPanel, null);
	}
}
