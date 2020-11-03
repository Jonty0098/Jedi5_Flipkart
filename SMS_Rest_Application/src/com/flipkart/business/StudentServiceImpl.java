package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;


import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDAO;
import com.flipkart.dao.StudentDAOImpl;
public class StudentServiceImpl implements StudentService {
	Logger logger = Logger.getLogger( StudentServiceImpl.class);
	Scanner scan = new Scanner(System.in);
	StudentDAO StudentDAO = new  StudentDAOImpl();
	 /**
	     * function to Display course registered by the student
	     *	@return void
	     */
	public List<Course> ViewCourse(int id) {
		//logger.info("SSI");
		//this.asd();
		List<Course> Courses =StudentDAO.viewCourse(id);
		return Courses;
	}
	/**
     * function to Chose course for the student
     *	@return void
     */
	public void AddCourse(int sid,int cid) {
		//logger.info("Enter Course Id");
		//int cid = scan.nextInt();
		StudentDAO.addCourse(sid,cid);
	}
	/**
     * function to 	remove course for the student
     *	@return void
     */
	public void RemoveCourse(int sid,int cid) {
		//logger.info("Enter Course Id");
		//int cid = scan.nextInt();
		StudentDAO.RemoveCourse(sid,cid);
	}/**
     * function to 	Show grades of the student
     *	@return void
     */
	public Map<String, String> ShowGrades(int id) {
		 Map<String, String> reportCard=StudentDAO.ShowGrades(id);
		  return reportCard;                         
	}
	/**
     * function to 	pay fee not implemented completely
     *	@return void
     */
	public String PayFees(int id) {
		return " total due amount " + StudentDAO.getFees(id)+"RS";
	}
	
	public boolean RegistorStudent(Student student){
		
		return StudentDAO.registerStudent(student);
		
	}
	/**
     * function to 	display view of the student
     *	@return void
     */
	public void view(int Id) {
		//Logger logger = Logger.getLogger(StudentServiceImpl.class);
		Scanner scan = new Scanner(System.in);
		boolean val=true;
		while(val) {
			//logger.info("press 1 to View Course ");
			//logger.info("press 2 to Add Course ");
			//logger.info("press 3 to Remove Course");
			//logger.info("press 4 to Show Grades");
			//logger.info("press 5 to Pay Fees");
			//logger.info("press 6 to exit");
			//Scanner scan = new Scanner(System.in);
	        System.out.print("Enter the operation ");
	        // This method reads the number provided using keyboard
	        int num = scan.nextInt();
		switch (num) {
		  case 1:
			  this.ViewCourse(Id);
		    break;
		  case 2:
			  //this.AddCourse(Id);
		    break;
		  case 3:
			  //this.RemoveCourse(Id);
			  break;
		  case 4:
			  this.ShowGrades(Id);
			  break;
		  case 5:
			  this.PayFees(Id);
			  break;
		  case 6:
			  val=false;
			  break;
		}
	        
	}
	}
	public String asd(){
		return "Afadfad";
	}
}
