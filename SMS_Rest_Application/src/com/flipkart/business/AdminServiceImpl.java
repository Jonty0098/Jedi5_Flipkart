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
	AdminDAO AdminDAO = new  AdminDAOImpl();
	Scanner scan = new Scanner(System.in);
	/**
     * function to approve registration
     *	@return void
     */
	public void ApproveRegistration(int id)  {
		AdminDAO.approveRegistration(id);
		
	}
	/**
     * function to assign Course to professor
     *	@return void
     */
	public void AssignCourse (int cid,int pid)  {
		
		AdminDAO.AssignCourseDAO(cid, pid);
	}
	/**
     * function to get details of all user
     *	@return void
     */
	public List<User> GetAllUsers() {
		 
		return AdminDAO.GetAllUsers();
		 
	}
	/**
     * function to Delete user
     *	@return void
     */
	public void DeleteUser(int id) {
		
		AdminDAO.DeleteUserDAO(id);
	}
	/**
     * function to Display view of the admin
     *	@return void
     */
	/*public void view(int id)  {
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
			 // this.ApproveRegistration(id);
		    break;
		  case 2:
			  //this.AssignCourse();
		    break;
		  case 3:
			  this.GetAllUsers();
			break;
		  case 4:
			  //this.DeleteUser();
			break;
		  case 5:
			  val=false;
			  break;
		}
	        
	}
	}*/
}
