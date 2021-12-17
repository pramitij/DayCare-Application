package edu.neu.csye6200.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

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
		int studentId = Integer.parseInt(view.getStudentIdTextField().getText());
		String vaccineName = view.getVaccineTypeComboBox().getSelectedItem().toString();
		String vaccineDose = view.getVaccineDoseComboBox().getSelectedItem().toString();
		Date selectedDate = (Date) view.getDatePicker().getModel().getValue();
		java.sql.Date sqlSelectedDate = new java.sql.Date(selectedDate.getTime());

//	    java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
//	    System.out.println(localDate);

		dbc.addVaccinationDetails(vaccineName, Integer.parseInt(vaccineDose), sqlSelectedDate, studentId);

		// view student vaccine details on table
		Statement statmentShowStudentList;
		try {
			statmentShowStudentList = dbc.a.createStatement();
//			ResultSet rs = statmentShowStudentList.executeQuery("select * from student");

			ResultSet rs = statmentShowStudentList.executeQuery(
					"select s.studentname, i.vaccinationname, i.doseno, i.datetaken from immunizations i inner join student s on i.studentid = s.studentid where i.studentid="
							+ studentId);

			view.getVaccineInfoTable().setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
