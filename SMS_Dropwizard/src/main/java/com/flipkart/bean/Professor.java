package com.flipkart.bean;



public class Professor extends User  {


	private String Department;
	private int RegistrationStatus;

	/**
	 * @return the registrationStatus
	 */
	public int getRegistrationStatus() {
		return RegistrationStatus;
	}

	/**
	 * @param registrationStatus the registrationStatus to set
	 */
	public void setRegistrationStatus(int registrationStatus) {
		RegistrationStatus = registrationStatus;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return Department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		Department = department;
	}
	
	
	
	
}
