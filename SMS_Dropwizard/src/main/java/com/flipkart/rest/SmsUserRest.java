/**
 * 
 */
package com.flipkart.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.business.Authentication;
import com.flipkart.business.AuthenticationImpl;

/**
 * @author ShabbirMoosakhan
 *
 */
@Path("user")
public class SmsUserRest {
	Logger logger = Logger.getLogger(SmsUserRest.class);
	Authentication auth = new AuthenticationImpl();
	/**
	  * Function to login a user
	  * @param user object
	  *@string of greeting message
	  */
	@PUT
	@Path("/login")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
    public String GetCourse(User user)
    {	
		
		int id=auth.login(user);
		if(id==0)
			return "wrong Credentials or not approves";
		else
			return "Welcome user "+id;
    }
}
