/**
 * 
 */
package com.flipkart.rest;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
//import com.flipkart.bean.Customer;
import com.flipkart.bean.Student;
import com.flipkart.business.StudentService;
import com.flipkart.business.StudentServiceImpl;

/**
 * @author ShabbirMoosakhan
 *
 */
@Path("/student")
public class SmsStudentRest {
	Logger logger = Logger.getLogger(SmsStudentRest.class);
	StudentService Studentservice = new StudentServiceImpl();  
	/**
	  * Function to view courses registered
	  * @param student id 
	  *@return List of objects of type course
	  */
	@GET
	@Path("/viewcourse/{id}") // put all the parameters and lin
	@Produces(MediaType.APPLICATION_JSON)
    public List<Course> ViewCourse(@PathParam("id") int id)
    {
		List<Course> Courses=Studentservice.ViewCourse(id);
		return Courses;
    }
	/**
	  * Function to add course 
	  * @param student id 
	  * @param course id 
	  *@return void
	  */
	@PUT
	@Path("/addcourse/{studentid}/{courseid}")
	@Produces(MediaType.APPLICATION_JSON)
    public void AddCourse(@PathParam("studentid") int studentid,@PathParam("courseid") int courseid)
    {
		Logger logger = Logger.getLogger(SmsStudentRest.class);
		//logger.info(Sservice.asd());
		//logger.info(id);
		Studentservice.AddCourse(studentid,courseid);
		
    }
	/**
	  * Function to remove course
	  * @param student id 
	  * @param course id 
	  *@return void
	  */
	@DELETE
	@Path("/removecourse/{studentid}/{courseid}")
	@Produces(MediaType.APPLICATION_JSON)
    public String RemoveCourse(@PathParam("studentid") int sid,@PathParam("courseid") int cid)
    {
		
		//logger.info(Sservice.asd());
		//logger.info(id);
		Studentservice.RemoveCourse(sid,cid);
		return "check database of update";
		
    }
	/**
	  * Function to register Student
	  * @param Student type object
	  * @return void
	  */
	@POST
	@Path("/registorstudent")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public void createCustomer(Student student) {
        System.out.println("trying to registor a student");
        
        System.out.println("value of Id " +student.getId());
        
		
		Studentservice.RegistorStudent(student);
		//return Response.status(201).entity(result).build();
		
	} 
	/**
	  * Function to view grade
	  * @param Student id
	  * @return map with subjects and grade
	  */
	@GET
	@Path("viewgrade/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> viewGrades(@PathParam("id") int id) {
		return Studentservice.ShowGrades(id);
	}
	/**
	  * Function to generate fees
	  * @param Student id
	  * @return a string with due fees
	  */
	@GET
	@Path("/fees/{id}")
    public String  Pay(@PathParam("id") int id)
    {	
         return Studentservice.PayFees(id);
    }
}
