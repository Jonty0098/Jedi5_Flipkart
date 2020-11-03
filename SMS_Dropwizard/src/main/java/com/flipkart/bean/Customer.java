/**
 * 
 */
package com.flipkart.bean;

/**
 * @author ShabbirMoosakhan
 *
 */
public class Customer {
	private int CustomerId;
	private String CustomerName;
	private String CustomerAddress;
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return CustomerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int CustomerId) {
		this.CustomerId = CustomerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return CustomerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
}
