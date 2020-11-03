/**
 * 
 */
package com.flipkart.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceImpl;

/**
 * @author ShabbirMoosakhan
 *
 */
@Path("/admin")
public class SmsAdminRest {
	AdminService AdminService = new AdminServiceImpl();
	 Logger logger = Logger.getLogger(SmsStudentRest.class);
	 /**
	  * Function to approve registration
	  * @param id of user
	  *@return String 
	  */
	@PUT
	@Path("/approveregistration/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public String ApproveRegistration(@PathParam("id") int id)
    {
		AdminService.ApproveRegistration(id);
		return "Check Database for result";
    }
	/**
	  * Function to assign Course
	  * @param courseid id of course
	  * @param professorid id of professor
	  *@return String 
	  */
	@PUT
	@Path("/assigncourse/{courseid}/{professorid}")
	@Produces(MediaType.APPLICATION_JSON)
    public String ApproveRegistration(@PathParam("courseid") int courseid,@PathParam("professorid") int professorid)
    {
		AdminService.AssignCourse(courseid, professorid);
		return "Course Assigned";
    }
	/**
	  * Function to get all user
	  * 
	  *@return list of user Object
	  */
	@GET
	@Path("/viewalluser")
	@Produces(MediaType.APPLICATION_JSON)
    public List<User> ViewCourse()
    {
		return AdminService.GetAllUsers();	
    }
	/**
	  * Function to delete user
	  * @param  id of user
	  *@return void
	  */
	@DELETE
	@Path("/deleteuser/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public void DeleteUser(@PathParam("id") int id)
    {
		
		//logger.info(Sservice.asd());
		//logger.info(id);
		AdminService.DeleteUser(id);
		
    }
	
}
