package com.flipkart.business;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.dao.AthenticationDAOImpl;
import com.flipkart.dao.AuthenticationDAO;
import com.flipkart.rest.SmsUserRest;

public class AuthenticationImpl implements Authentication {
	Logger logger = Logger.getLogger(SmsUserRest.class);
	AuthenticationDAO authDAO = new AthenticationDAOImpl();
	/**
     * function to login
     *	@return Id of the user
     */
	public int login(User user) // username //custom exception
	{
		//check credentials with database
		int Id= authDAO.loginDAO(user);
		return Id;
	}/**
     * function to display view of login
     *	@return Id of the user
     */
	/*public int Interface () {
		// take input of credentials
		Scanner myObj = new Scanner(System.in);
		System.out.println("enter Username"); 
		String Username = myObj.next(); 
		System.out.println("enter Password");
		String password = myObj.next();
		//call authenticate function
		int Id=this.login(Username,password);
		return Id;
	}*/
}
