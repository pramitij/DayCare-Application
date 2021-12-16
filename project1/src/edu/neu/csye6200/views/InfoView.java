package edu.neu.csye6200.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import edu.neu.csye6200.utils.Utils;
import edu.neu.csye6200Backend.DBBasicConnection;
import net.proteanit.sql.DbUtils;

public class InfoView implements View {
	private JTable table;
	private JButton btnStudentDetails;
	private JButton btnTeacherDetails;

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

	@Override
	public JPanel initialize() {
		return genInfoPage();
	}

	private JPanel genInfoPage() {
		DBBasicConnection dbc = Utils.getDbConnector();
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

		// Student Details Button
		btnStudentDetails = new JButton("Student Details");
		btnStudentDetails.setForeground(SystemColor.window);
		btnStudentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statmentShowStudentList;
				try {
					statmentShowStudentList = dbc.a.createStatement();
					ResultSet rs = statmentShowStudentList.executeQuery("select * from student");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStudentDetails.setBorder(new LineBorder(SystemColor.scrollbar, 1, true));
		btnStudentDetails.setBackground(new Color(135, 206, 235));
		btnStudentDetails.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnStudentDetails.setBounds(111, 300, 182, 60);
		infoPanel.add(btnStudentDetails);

		// Teacher Details Button
		btnTeacherDetails = new JButton("Teachers Details");
		btnTeacherDetails.setForeground(SystemColor.window);
		btnTeacherDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statmentShowStudentList;
				try {
					statmentShowStudentList = dbc.a.createStatement();
					ResultSet rs = statmentShowStudentList.executeQuery("select * from teacher");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTeacherDetails.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnTeacherDetails.setBorder(new LineBorder(SystemColor.scrollbar, 1, true));
		btnTeacherDetails.setBackground(new Color(135, 206, 235));
		btnTeacherDetails.setBounds(111, 400, 182, 60);
		infoPanel.add(btnTeacherDetails);

		return infoPanel;
	}

}
