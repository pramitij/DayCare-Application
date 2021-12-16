package edu.neu.csye6200.models;

public class Teacher extends Person implements PersonFactoryInterface{
	
	private String phone;
	private String email;
	private int Catagory;


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCatagory() {
		return Catagory;
	}

	public void setCatagory(int catagory) {
		Catagory = catagory;
	}

	@Override
	public void PersonFactoryInterface() {
		// TODO Auto-generated method stub
		
	}
}
