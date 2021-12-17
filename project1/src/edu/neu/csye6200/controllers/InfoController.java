package edu.neu.csye6200.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.utils.Utils;
import edu.neu.csye6200.views.InfoView;
import edu.neu.csye6200.views.RegistrationView;
import edu.neu.csye6200Backend.DBBasicConnection;
import net.proteanit.sql.DbUtils;

public class InfoController implements Controller {
	private Student model;
	private InfoView view;
	private DBBasicConnection dbc;

	public InfoController(Student model, InfoView view) {
		this.model = model;
		this.view = view;
		dbc = Utils.getDbConnector();
		initView();
		initController();
	}

	// code for setting the actions to be performed when the user interacts to the
	// view.
	@Override
	public void initController() {
		view.getBtnStudentDetails().addActionListener(e -> fetchStudentDetails());
		view.getBtnTeacherDetails().addActionListener(e -> fetchTeacherDetails());
	}

	private void fetchStudentDetails() {
		JTable table = view.getTable();
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

	private void fetchTeacherDetails() {
		JTable table = view.getTable();
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

}
