package edu.neu.csye6200.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.utils.Utils;
import edu.neu.csye6200.views.AlertView;
import edu.neu.csye6200Backend.DBBasicConnection;
import net.proteanit.sql.DbUtils;

public class AlertController implements Controller {
	private Student model;
	private AlertView view;
	private DBBasicConnection dbc;

	public AlertController(Student model, AlertView view) {
		this.model = model;
		this.view = view;
		this.dbc = Utils.getDbConnector();
		initView();
		initController();
	}

	// code for setting the actions to be performed when the user interacts to the
	// view.
	@Override
	public void initController() {
		view.getBtnStudentDetails().addActionListener(e -> getStudentAlerts());
		view.getBtnTeacherDetails().addActionListener(e -> getTeacherAlerts());
		view.getBtnStudentImunization().addActionListener(e -> getStudentImunizationAlerts());
	}

	// fetch student alerts from db and populate table
	private void getStudentAlerts() {
		JTable table = view.getTable();
		Statement statmentShowStudentList;
		try {
			statmentShowStudentList = dbc.a.createStatement();
			ResultSet rs = statmentShowStudentList.executeQuery("select * from student where doj=current_date-355");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	// fetch teacher alerts from db and populate table
	private void getTeacherAlerts() {
		JTable table = view.getTable();
		Statement statmentShowStudentList;
		try {
			statmentShowStudentList = dbc.a.createStatement();
			ResultSet rs = statmentShowStudentList.executeQuery("select * from teacher where doj>=current_date-357");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	// fetch student immunization alerts from db and populate table
	private void getStudentImunizationAlerts() {
		JTable table = view.getTable();
		Statement statmentShowStudentList;
		try {
			statmentShowStudentList = dbc.a.createStatement();
			ResultSet rs = statmentShowStudentList.executeQuery("select s.studentname, i.vaccinationname, i.doseno from immunizations i inner join student s on i.studentid = s.studentid");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
