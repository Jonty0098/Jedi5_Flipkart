package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.ProfessorDAO;
import com.flipkart.dao.ProfessorDAOImpl;

public class ProfessorServiceImpl implements ProfessorService {
	//Logger logger = Logger.getLogger(ProfessorServiceImpl.class);
	ProfessorDAO ProfessorDAO = new ProfessorDAOImpl();
	Scanner scan = new Scanner(System.in);
	 /**
	     * function to get students under the professor
	     *	@return void
	     */
	public List<Student>  ViewStudents(int id) {
		
		return ProfessorDAO.ViewStudentDAO(id);
		
	}
	/**
     * function to View Courses assign to the professor
     *	@return Void
     */
	public List<String> ViewCourses(int id ) {
		List<String> Courses=ProfessorDAO.ViewCourseDAO(id);
		return Courses;
	}
	/**
     * function to give Grades to the student
     *	@return void
     */
	public void GradesStudent(int sid,int cid,String grade) {
		 ProfessorDAO.GradeStudentDAO(sid, cid, grade);
	}
	public void RegisterProfessor(Professor prof) {
		 ProfessorDAO.registerProfessor(prof);
	}
	/**
     * function to display view of the professor
     *	@return void
     */
	/*public void view(int id) {
		Logger logger = Logger.getLogger(StudentServiceImpl.class);
		Scanner scan = new Scanner(System.in);
		boolean val=true;
		while(val) {
			logger.info("press 1 to View Students under the professor ");
			logger.info("press 2 to View Courses Assigned ");
			logger.info("press 3 to Upload Grades");
			logger.info("press 4 to exit");
			//Scanner scan = new Scanner(System.in);
	        System.out.print("Enter the operation ");
	        // This method reads the number provided using keyboard
	        int num = scan.nextInt();
		switch (num) {
		  case 1:
			  //this.ViewStudents(id);
		    break;
		  case 2:
			  this.ViewCourses(id);
			break;
		  case 3:
			  this.GradesStudent(id);
		  case 4:
			  val=false;
			  break;
		}
	        
	}
	}*/

}

