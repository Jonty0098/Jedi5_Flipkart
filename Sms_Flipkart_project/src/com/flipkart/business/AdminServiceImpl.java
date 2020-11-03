package com.flipkart.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.dao.AdminDAO;
import com.flipkart.dao.AdminDAOImpl;

public class AdminServiceImpl implements AdminService {
	Logger logger = Logger.getLogger(StudentServiceImpl.class);
	AdminDAO admindao = new  AdminDAOImpl();
	Scanner scan = new Scanner(System.in);
	/**
     * function to approve registration
     *	@return void
     */
	public void ApproveRegistration()  {
		logger.info("enter user id");
		int id = scan.nextInt();
		admindao.approveRegistration(id);	
	}
	/**
     * function to assign Course to professor
     *	@return void
     */
	public void AssignCourse ()  {
		logger.info("enter Course id");
		int cid = scan.nextInt();
		logger.info("enter Professor id");
		int pid = scan.nextInt();
		admindao.AssignCourseDAO(cid, pid);
	}
	/**
     * function to get details of all user
     *	@return void
     */
	public void GetAllUsers() {
		 List<User> Users=admindao.GetAllUsers();
		 for(int i=0 ;i<Users.size();i++)
			 logger.info(Users.get(i).getId()+"   " +Users.get(i).getName()+"   "+Users.get(i).getGender()+"   "+Users.get(i).getRole());
	}
	/**
     * function to Delete user
     *	@return void
     */
	public void DeleteUser() {
		logger.info("enter User id to delete user");
		int id = scan.nextInt();
		admindao.DeleteUserDAO(id);
	}
	/**
     * function to Display view of the admin
     *	@return void
     */
	public void view(int id)  {
		boolean val=true;
		while(val) {
			logger.info("press 1 to Approve Registration ");
			logger.info("press 2 to Assign Course to Professor ");
			logger.info("press 3 to Get All Users");
			logger.info("press 4 to Delete a User");
			logger.info("press 5 to exit");
	        System.out.print("Enter the operation ");
	        int num = scan.nextInt();
		switch (num) {
		  case 1:
			  this.ApproveRegistration();
		    break;
		  case 2:
			  this.AssignCourse();
		    break;
		  case 3:
			  this.GetAllUsers();
			break;
		  case 4:
			  this.DeleteUser();
			break;
		  case 5:
			  val=false;
			  break;
		}
	        
	}
	}
}
