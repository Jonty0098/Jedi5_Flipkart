package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.app.SmsApp;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDAO;
import com.flipkart.dao.StudentDAOImpl;
public class StudentServiceImpl implements StudentService {
	Logger logger = Logger.getLogger(SmsApp.class);
	Scanner scan = new Scanner(System.in);
	StudentDAO studentdao = new  StudentDAOImpl();
	 /**
	     * function to Display course registered by the student
	     *	@return void
	     */
	public void ViewCourse(int id) {
		List<Course> Courses =studentdao.viewCourse(id);
		for(int i=0;i<Courses.size();i++)
			System.out.println(Courses.get(i).getName() +"    " +Courses.get(i).getFee()+"     "+Courses.get(i).getDiscription());
	}
	/**
     * function to Chose course for the student
     *	@return void
     */
	public void AddCourse(int id) {
		logger.info("Enter Course Id");
		int cid = scan.nextInt();
		studentdao.addCourse(id,cid);
	}
	/**
     * function to 	remove course for the student
     *	@return void
     */
	public void RemoveCourse(int id) {
		logger.info("Enter Course Id");
		int cid = scan.nextInt();
		studentdao.RemoveCourse(id,cid);
	}/**
     * function to 	Show grades of the student
     *	@return void
     */
	public void ShowGrades(int id) {
		 Map<String, String> reportCard=studentdao.ShowGrades(id);
		 System.out.println("Subject            Grade"); 
		 for (Map.Entry<String,String> entry : reportCard.entrySet())  
	            System.out.println( entry.getKey() + "            " +entry.getValue()); 
	                              
	}
	/**
     * function to 	pay fee not implemented completely
     *	@return void
     */
	public void PayFees(int id) {
		logger.info(" total due amount " + studentdao.getFees(id)+"RS");
	}
	/**
     * function to 	display view of the student
     *	@return void
     */
	public void view(int Id) {
		Logger logger = Logger.getLogger(StudentServiceImpl.class);
		Scanner scan = new Scanner(System.in);
		boolean val=true;
		while(val) {
			logger.info("press 1 to View Course ");
			logger.info("press 2 to Add Course ");
			logger.info("press 3 to Remove Course");
			logger.info("press 4 to Show Grades");
			logger.info("press 5 to Pay Fees");
			logger.info("press 6 to exit");
			//Scanner scan = new Scanner(System.in);
	        System.out.print("Enter the operation ");
	        // This method reads the number provided using keyboard
	        int num = scan.nextInt();
	        switch (num) {
	        	case 1:
	        		this.ViewCourse(Id);
	        	break;
	        	case 2:
	        		this.AddCourse(Id);
	        	break;
	        	case 3:
	        		this.RemoveCourse(Id);
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
}
