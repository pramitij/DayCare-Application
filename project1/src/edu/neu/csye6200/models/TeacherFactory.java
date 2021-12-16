package edu.neu.csye6200.models;

public class TeacherFactory {
	
	public PersonFactoryInterface getInstance() {
		
			return new Teacher();
		
	}
}
