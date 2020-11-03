package com.flipkart.bean;



public class Course {
	
	private String name;
	private String Discription;
	private int Id;
	private int Fee;
	/**
	 * @return the fee
	 */
	public int getFee() {
		return Fee;
	}
	/**
	 * @param fee the fee to set
	 */
	public void setFee(int fee) {
		Fee = fee;
	}
	/**
	 * @return the discription
	 */
	public String getDiscription() {
		return Discription;
	}
	/**
	 * @param discription the discription to set
	 */
	public void setDiscription(String discription) {
		Discription = discription;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
