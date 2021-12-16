package edu.neu.csye6200.views;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import edu.neu.csye6200.utils.Utils;
import edu.neu.csye6200Backend.DBBasicConnection;

public class AlertView implements View {
	JFrame alertFrame;
	private JScrollPane scrollPane;
	public JTable table;
	private JButton btnStudentDetails;
	private JButton btnTeacherDetails;
	private JButton btnStudentImunization;

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnStudentDetails() {
		return btnStudentDetails;
	}

	public void setBtnStudentDetails(JButton btnStudentDetails) {
		this.btnStudentDetails = btnStudentDetails;
	}

	public JButton getBtnTeacherDetails() {
		return btnTeacherDetails;
	}

	public void setBtnTeacherDetails(JButton btnTeacherDetails) {
		this.btnTeacherDetails = btnTeacherDetails;
	}

	public JButton getBtnStudentImunization() {
		return btnStudentImunization;
	}

	public void setBtnStudentImunization(JButton btnStudentImunization) {
		this.btnStudentImunization = btnStudentImunization;
	}

	@Override
	public JPanel initialize() {
		return genAlertPage();
	}

	private JPanel genAlertPage() {
		DBBasicConnection dbc = Utils.getDbConnector();

		JPanel alertPanel = new JPanel(new BorderLayout());
		JPanel headerPanel = new JPanel(new GridLayout(0, 3));

		// Student alerts
		btnStudentDetails = new JButton("Student Alerts");
		btnStudentDetails.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		btnStudentDetails.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(SystemColor.controlShadow, 1, true), BorderFactory.createEmptyBorder(5, 5, 10, 10)));
		headerPanel.add(btnStudentDetails);

		// Teacher alerts
		btnTeacherDetails = new JButton("Teacher Alerts");
		btnTeacherDetails.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		btnTeacherDetails.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(SystemColor.controlShadow, 1, true), BorderFactory.createEmptyBorder(5, 5, 10, 10)));
		headerPanel.add(btnTeacherDetails);

		// Student Immunization alerts
		btnStudentImunization = new JButton("Student Immunization Alerts");
		btnStudentImunization.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		btnStudentImunization.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(SystemColor.controlShadow, 1, true), BorderFactory.createEmptyBorder(5, 5, 10, 10)));
		headerPanel.add(btnStudentImunization);

		JPanel bodyPanel = new JPanel(new GridLayout());

		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.info);
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		scrollPane.setEnabled(false);
		scrollPane.setVerifyInputWhenFocusTarget(false);
		bodyPanel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		alertPanel.add(headerPanel, BorderLayout.NORTH);
		alertPanel.add(bodyPanel, BorderLayout.CENTER);
		return alertPanel;
	}

}
