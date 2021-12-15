package edu.neu.csye6200.controllers;

import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.views.RegistrationView;

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
//		view.getStudentNameTextField()
//		view.getStudentFatherNameTextField()
//		view.getStudentMotherNameTextField()
//		view.getStudentPhoneTextField()
//		view.getStudentAddressTextField()
//		view.getStudentDatePicker()
		JOptionPane.showMessageDialog(null, "Successfully Registered!!", "Message Dialog", JOptionPane.PLAIN_MESSAGE);
	}
}
