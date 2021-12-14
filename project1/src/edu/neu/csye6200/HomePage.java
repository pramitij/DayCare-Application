package edu.neu.csye6200;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JComboBox;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import edu.neu.csye6200.utils.Constants;
import edu.neu.csye6200.utils.Utils;

import javax.swing.BorderFactory;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.Properties;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	private JPanel genStudentRegPage() {
		// 1.1 Student Registration Tab
		JPanel studentRegPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Student Registration title
		JLabel studentTitleLabel = new JLabel("STUDENT REGISTRATION", JLabel.CENTER);
		studentTitleLabel.setFont(Constants.TITLE_FONT);
		gbc.insets = new Insets(8, 8, 30, 8);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		studentRegPanel.add(studentTitleLabel, gbc);

		gbc.insets = new Insets(8, 8, 8, 8);

		// NAME
		JLabel studentNameLabel = new JLabel("Student's Name: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentNameLabel, gbc);

		JTextField studentNameTextField = new JTextField();
		studentNameTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentNameTextField, gbc);

		// AGE
		JLabel studentAgeLabel = new JLabel("DOB: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentAgeLabel, gbc);

		JDatePickerImpl datePicker = Utils.genJDatePicker();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(datePicker, gbc);

		// FATHER'S NAME
		JLabel studentFatherNameLabel = new JLabel("Father's Name: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentFatherNameLabel, gbc);

		JTextField studentFatherNameTextField = new JTextField();
		studentFatherNameTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentFatherNameTextField, gbc);

		// MOTHER'S NAME
		JLabel studentMotherNameLabel = new JLabel("Mother's Name: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentMotherNameLabel, gbc);

		JTextField studentMotherNameTextField = new JTextField();
		studentMotherNameTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentMotherNameTextField, gbc);

		// PHONE NUMBER
		JLabel studentPhoneLabel = new JLabel("Phone Number: ");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentPhoneLabel, gbc);

		JTextField studentPhoneTextField = new JTextField();
		studentPhoneTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentPhoneTextField, gbc);

		// ADDRESS
		JLabel studentAddressLabel = new JLabel("Address: ");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentAddressLabel, gbc);

		JTextArea studentAddressTextField = new JTextArea(5, 5);
		studentAddressTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentAddressTextField, gbc);

		// Submit button
		JButton studentRegSubmitButton = new JButton("SUBMIT");
		studentRegSubmitButton.setPreferredSize(new Dimension(90, 40));
		studentRegSubmitButton.setFont(Constants.BUTTON_FONT);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(30, 8, 8, 50);
		studentRegPanel.add(studentRegSubmitButton, gbc);

		return studentRegPanel;
	}

	private JPanel genTeacherRegPage() {
		// 1.2 Teacher Registration Tab
		JPanel teacherRegPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Teacher Registration title
		JLabel teacherTitleLabel = new JLabel("TEACHER REGISTRATION", JLabel.CENTER);
		teacherTitleLabel.setFont(Constants.TITLE_FONT);
		gbc.insets = new Insets(8, 8, 30, 8);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		teacherRegPanel.add(teacherTitleLabel, gbc);

		gbc.insets = new Insets(8, 8, 8, 8);

		// NAME
		JLabel teacherNameLabel = new JLabel("Name: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		teacherRegPanel.add(teacherNameLabel, gbc);

		JTextField teacherNameTextField = new JTextField();
		teacherNameTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		teacherRegPanel.add(teacherNameTextField, gbc);

		// CONTACT
		JLabel teacherMobileLabel = new JLabel("Contact: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		teacherRegPanel.add(teacherMobileLabel, gbc);

		JTextField teacherMobileTextField = new JTextField();
		teacherMobileTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		teacherRegPanel.add(teacherMobileTextField, gbc);

		// EMAIL
		JLabel teacherEmailLabel = new JLabel("Email: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		teacherRegPanel.add(teacherEmailLabel, gbc);

		JTextField teacherEmailTextField = new JTextField();
		teacherEmailTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		teacherRegPanel.add(teacherEmailTextField, gbc);

		// CATAGORY
		JLabel teacherCatagoryLabel = new JLabel("Catagory: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		teacherRegPanel.add(teacherCatagoryLabel, gbc);

		JTextField teacherCatagoryTextField = new JTextField();
		teacherCatagoryTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		teacherRegPanel.add(teacherCatagoryTextField, gbc);

		// Submit button
		JButton teacherRegSubmitButton = new JButton("SUBMIT");
		teacherRegSubmitButton.setPreferredSize(new Dimension(90, 40));
		teacherRegSubmitButton.setFont(Constants.BUTTON_FONT);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(30, 8, 8, 8);
		teacherRegPanel.add(teacherRegSubmitButton, gbc);

		return teacherRegPanel;
	}

	private JPanel genRegistrationPage() {
		// 1. Registration Page
		JPanel RegistrationPanel = new JPanel(new BorderLayout());
		JTabbedPane RegTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		RegistrationPanel.add(RegTabbedPane, BorderLayout.CENTER);

		// 1.1 Student Registration Tab
		JPanel studentRegPanel = genStudentRegPage();
		RegTabbedPane.addTab("Student", null, studentRegPanel, null);

		// 1.2 Teacher Registration Tab
		JPanel teacherRegPanel = genTeacherRegPage();
		RegTabbedPane.addTab("Teacher", null, teacherRegPanel, null);

		return RegistrationPanel;
	}

	private JPanel genAddImmunizationPage() {
		// 2.1 Teacher Registration Tab
		JPanel addImmunizationPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Student Registration title
		JLabel ImmunizationTitleLabel = new JLabel("ADD/MODIFY IMMUNIZATION", JLabel.CENTER);
		ImmunizationTitleLabel.setFont(Constants.TITLE_FONT);
		gbc.insets = new Insets(8, 8, 30, 8);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		addImmunizationPanel.add(ImmunizationTitleLabel, gbc);

		gbc.insets = new Insets(8, 8, 8, 8);

		// STUDENT ID
		JLabel studentIdLabel = new JLabel("Student Id: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		addImmunizationPanel.add(studentIdLabel, gbc);

		JTextField studentIdTextField = new JTextField();
		studentIdTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		addImmunizationPanel.add(studentIdTextField, gbc);

		// VACCINE TYPE
		JLabel vaccineTypeLabel = new JLabel("Vaccine Type: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		addImmunizationPanel.add(vaccineTypeLabel, gbc);

		String vaccineTypes[] = { "Hib", "DTap", "Polio", "Hepatitis B", "MMR", "Varicella" };
		JComboBox vaccineTypeComboBox = new JComboBox(vaccineTypes);
		vaccineTypeComboBox.setPreferredSize(Constants.COMBO_BOX_DIM);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		addImmunizationPanel.add(vaccineTypeComboBox, gbc);

		// VACCINE DOSE COUNT
		JLabel vaccineDoseNoLabel = new JLabel("Dose No: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		addImmunizationPanel.add(vaccineDoseNoLabel, gbc);

		String vaccineDoseTypes[] = { "1", "2", "3", "4" };
		JComboBox vaccineDoseComboBox = new JComboBox(vaccineDoseTypes);
		vaccineDoseComboBox.setPreferredSize(Constants.COMBO_BOX_DIM);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		addImmunizationPanel.add(vaccineDoseComboBox, gbc);

		// VACCINE DATE
		JLabel vaccineDateLabel = new JLabel("Date: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		addImmunizationPanel.add(vaccineDateLabel, gbc);

		JDatePickerImpl datePicker = Utils.genJDatePicker();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		addImmunizationPanel.add(datePicker, gbc);

		// Submit button
		JButton vaccineSubmitButton = new JButton("Add/Update");
		vaccineSubmitButton.setPreferredSize(new Dimension(110, 40));
		vaccineSubmitButton.setFont(Constants.BUTTON_FONT);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(30, 8, 8, 50);
		addImmunizationPanel.add(vaccineSubmitButton, gbc);

		return addImmunizationPanel;
	}

	private JPanel genViewImmunizationPage() {
		// 2.1 Teacher Registration Tab
		JPanel viewImmunizationPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Immunization Details title
		JLabel ImmunizationDetailsTitleLabel = new JLabel("STUDENT IMMUNIZATION DETAILS", JLabel.CENTER);
		ImmunizationDetailsTitleLabel.setFont(Constants.TITLE_FONT);
		gbc.insets = new Insets(8, 8, 30, 8);
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		viewImmunizationPanel.add(ImmunizationDetailsTitleLabel, gbc);

		// table rows
		String[][] data = { { "23", "Hib", "1", "2021-09-03" }, { "23", "DTap", "1", "2021-09-03" },
				{ "23", "Polio", "1", "2021-09-03" }, { "23", "MMR", "1", "2021-09-03" },
				{ "23", "Varicella", "1", "2021-09-03" }, { "23", "Hepatitis B", "1", "2021-09-03" } };

		// table column names
		String[] columnNames = { "Student ID", "Vaccine Type", "Dose No", "Date" };
		JTable vaccineInfoTable = new JTable(data, columnNames);
		vaccineInfoTable.setEnabled(false);

		// Increase table content font size
		vaccineInfoTable.setFont(Constants.TABLE_CONTENT_FONT);

		// Increase table header font size
		JTableHeader tableHeader = vaccineInfoTable.getTableHeader();
		tableHeader.setFont(Constants.TABLE_HEADER_FONT);

		JScrollPane scrollPane = new JScrollPane(vaccineInfoTable);

		gbc.insets = new Insets(8, 8, 8, 8);
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		viewImmunizationPanel.add(scrollPane, gbc);

		return viewImmunizationPanel;
	}

	private JPanel genStudentImmunizationPage() {
		// 2. Immunization Page
		JPanel ImmunizationPanel = new JPanel(new GridLayout(1, 0));
		JPanel tab2Panel = new JPanel();

//		JTabbedPane RegTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
//		RegistrationPanel.add(RegTabbedPane, BorderLayout.CENTER);

		// 2.1 Add/Modify Immunization
		JPanel addImmunizationPanel = genAddImmunizationPage();
		ImmunizationPanel.add(addImmunizationPanel);

		// 2.1 View Immunization
		JPanel viewImmunizationPanel = genViewImmunizationPage();
		ImmunizationPanel.add(viewImmunizationPanel);

		return ImmunizationPanel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Base Frame
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Base Tabbed Layout
		JTabbedPane homeTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(homeTabbedPane, BorderLayout.CENTER);

		// 1. Registration Page
		JPanel RegistrationPage = genRegistrationPage();
		homeTabbedPane.addTab("Registration", null, RegistrationPage, null);

		// 2. genStudentImmunizationPage
		JPanel StudentImmunizationPage = genStudentImmunizationPage();
		homeTabbedPane.addTab("Student Immunization", null, StudentImmunizationPage, null);

		// 3. Information Page
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.orange);
		homeTabbedPane.addTab("Information", null, infoPanel, null);

		// 4. Alerts Page
		JPanel alertsPanel = new JPanel();
		alertsPanel.setBackground(Color.MAGENTA);
		homeTabbedPane.addTab("Alerts", null, alertsPanel, null);

	}

}
