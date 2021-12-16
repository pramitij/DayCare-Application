package edu.neu.csye6200.controllers;

import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.views.StudentImmunizationView;

public class StudentImmunizationController implements Controller {
	private Student model;
	private StudentImmunizationView view;

	public StudentImmunizationController(Student model, StudentImmunizationView view) {
		this.model = model;
		this.view = view;
		initView();
		initController();
	}

}
