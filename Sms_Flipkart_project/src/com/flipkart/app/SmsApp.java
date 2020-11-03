package com.flipkart.app;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.flipkart.business.Authentication;
import com.flipkart.business.AuthenticationImpl;
import com.flipkart.business.CourseServiceImpl;
import com.flipkart.business.UserService;
//import com.flipkart.business.StudentServiceImpl;
import com.flipkart.business.UserServiceImpl;
import com.flipkart.dao.AthenticationDAOImpl;
public class SmsApp {
	/**
     * Main Menu of the App
     *	
     */
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(SmsApp.class);
		Scanner scan = new Scanner(System.in);
		UserService userservice = new  UserServiceImpl();
		Authentication authentication =new AuthenticationImpl();
		boolean val=true;
		while(val) {
			// Basic Menu
			logger.info("press 1 to Signup User "); 
			logger.info("press 2 to login"); 
			logger.info("press 3 to exit");
			logger.info("Enter the operation");
	        int num = scan.nextInt();
	        switch (num) {
	        	case 1:
			  //call UserService
	        		boolean status=userservice.RegisterUser();
	        		if(status==false)
	        			logger.info("User Not Registered");
	        		else
	        			logger.info("User Registered Successfully");
	        		break;
	        	case 2:
	        		// create object of Authentication object
	        		//AuthenticationImpl auth = new AuthenticationImpl();
	        		int id= authentication.Interface();
	        		if(id==0)
	        			logger.info("wrong credentials or not approves");
	        		else
	        			userservice.GetDetails(id);
	        		break;
	        	case 3:
	        		val=false;  
	        		break;
	        }
	        
		}
	}
}
