package edu.neu.csye6200.models;

public class StudentFactory {
	public PersonFactoryInterface getInstance() {
		
		return new Student();
	}
}
