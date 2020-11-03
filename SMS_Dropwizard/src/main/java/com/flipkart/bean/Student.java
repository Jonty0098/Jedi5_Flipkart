package com.flipkart.bean;



public class Student extends User {

	
	public String Branch;
	int RegistrationStatus;
	/**
	 * @return the branch
	 */
	public String getBranch() {
		return Branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		Branch = branch;
	}
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
	
	
	
	

}
