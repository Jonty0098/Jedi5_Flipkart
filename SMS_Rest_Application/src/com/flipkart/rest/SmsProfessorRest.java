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

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.ProfessorService;
import com.flipkart.business.ProfessorServiceImpl;

/**
 * @author ShabbirMoosakhan
 *
 */
@Path("professor")
public class SmsProfessorRest {
	ProfessorService ProfessorService = new ProfessorServiceImpl();
	/**
	  * Function to get student under professor
	  * @param professor id 
	  *@return List of student type objects
	  */
	@GET
	@Path("/getstudents/{professorid}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Student> GetStudents(@PathParam("professorid") int professorid)
    {
		return ProfessorService.ViewStudents(professorid);
    }
	/**
	  * Function to get stubects assigned to professor
	  * @param professor id 
	  *@return List of string 
	  */
	@GET
	@Path("/getsubjects/{professorid}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<String> GetCourse(@PathParam("professorid") int professorid)
    {
		return ProfessorService.ViewCourses(professorid);
    }
	/**
	  * Function to assign grade to the student
	  * @param courseid id of course
	  * @param Studentid id of student
	  * @param grade
	  *@return void
	  */
	@PUT
	@Path("/grade/{studentid}/{courseid}/{grade}")
	@Produces(MediaType.APPLICATION_JSON)
    public void grade(@PathParam("studentid") int studentid,@PathParam("courseid") int courseid,@PathParam("grade") String grade)
    {
		ProfessorService.GradesStudent(studentid, courseid, grade);
    }
	/**
	  * Function to register Professor
	  * @param Professor type object
	  * @return void
	  */
	@POST
	@Path("/registorprofessor")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public void registorprofessor(Professor prof) {
      // System.out.println("trying to registor a student");
       
       //System.out.println("value of Id " +student.getId());
       
		
       ProfessorService.RegisterProfessor(prof);
		//return Response.status(201).entity(result).build();
		
	} 
}
