package edu.neu.csye6200.models;

public class Student extends Person implements PersonFactoryInterface{
	
	private String fatherName;
	private String motherName;
	private String address;
	private int phone;

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public void PersonFactoryInterface() {
		// TODO Auto-generated method stub
		
	}
}
