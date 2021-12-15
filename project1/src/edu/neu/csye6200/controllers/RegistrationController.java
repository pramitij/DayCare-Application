package edu.neu.csye6200.controllers;

import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.views.RegistrationView;
import edu.neu.csye6200Backend.DBBasicConnection;

import javax.swing.JOptionPane;

public class RegistrationController implements Controller {
	private Student model;
	private RegistrationView view;

	public RegistrationController(Student model, RegistrationView view) {
		this.model = model;
		this.view = view;
		initView();
		initController();
	}

	// code for setting the actions to be performed when the user interacts to the
	// view.
	@Override
	public void initController() {
		view.getStudentRegSubmitButton().addActionListener(e -> registerStudent());
	}

	private void registerStudent() {
		String name = view.getStudentNameTextField().getText();
		String fatherName = view.getStudentFatherNameTextField().getText();
		String motherName = view.getStudentMotherNameTextField().getText();
		String phone = view.getStudentPhoneTextField().getText();
		String address = view.getStudentAddressTextField().getText();
		
		DBBasicConnection dbc = new DBBasicConnection();
		boolean is_successful = dbc.addStudent(name, 15, fatherName, motherName, address, phone);
		if (is_successful)
			JOptionPane.showMessageDialog(null, "Successfully Registered!!", "Message Dialog", JOptionPane.PLAIN_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Failed to Registered", "Message Dialog", JOptionPane.PLAIN_MESSAGE);
	}
}
