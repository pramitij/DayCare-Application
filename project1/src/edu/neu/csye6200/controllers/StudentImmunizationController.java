package edu.neu.csye6200.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.utils.Utils;
import edu.neu.csye6200.views.StudentImmunizationView;
import edu.neu.csye6200Backend.DBBasicConnection;
import net.proteanit.sql.DbUtils;

public class StudentImmunizationController implements Controller {
	private Student model;
	private StudentImmunizationView view;
	private DBBasicConnection dbc;

	public StudentImmunizationController(Student model, StudentImmunizationView view) {
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
		view.getVaccineSubmitButton().addActionListener(e -> getStudentVaccineDetails());
	}

	// get student vaccine details
	private void getStudentVaccineDetails() {
		// add new student vaccine detail to db
		
		
		// view student vaccine details on table
		Statement statmentShowStudentList;
		try {
			statmentShowStudentList = dbc.a.createStatement();
			ResultSet rs = statmentShowStudentList.executeQuery("select * from student");
			view.getVaccineInfoTable().setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
