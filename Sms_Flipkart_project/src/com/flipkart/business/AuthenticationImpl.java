package com.flipkart.business;

import java.util.Scanner;

import com.flipkart.dao.AthenticationDAOImpl;
import com.flipkart.dao.AuthenticationDAO;

public class AuthenticationImpl implements Authentication {
	AuthenticationDAO authenticationdao = new AthenticationDAOImpl();
	/**
     * function to login
     *	@return Id of the user
     */
	public int login(String Username,String Password) // username //custom exception
	{
		//check credentials with database
		 
		
		int Id= authenticationdao.loginDAO(Username, Password);
		return Id;
	}/**
     * function to display view of login
     *	@return Id of the user
     */
	public int Interface () {
		// take input of credentials
		Scanner myObj = new Scanner(System.in);
		System.out.println("enter Username"); 
		String Username = myObj.next(); 
		System.out.println("enter Password");
		String password = myObj.next();
		//call authenticate function
		int Id=this.login(Username,password);
		return Id;
	}
}
