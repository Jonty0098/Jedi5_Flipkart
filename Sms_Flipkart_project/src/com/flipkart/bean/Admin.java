package com.flipkart.bean;



public class Admin extends User {
	int RegistrationStatus;

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
