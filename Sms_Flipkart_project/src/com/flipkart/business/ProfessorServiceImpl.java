package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.app.SmsApp;
import com.flipkart.bean.Student;
import com.flipkart.dao.ProfessorDAO;
import com.flipkart.dao.ProfessorDAOImpl;

public class ProfessorServiceImpl implements ProfessorService {
	Logger logger = Logger.getLogger(ProfessorServiceImpl.class);
	ProfessorDAO professordao = new ProfessorDAOImpl();
	Scanner scan = new Scanner(System.in);
	 /**
	     * function to get students under the professor
	     *	@return void
	     */
	public void ViewStudents(int id) {
		List<Student> Students=professordao.ViewStudentDAO(id);
		for(int i=0;i<Students.size();i++)
			logger.info(Students.get(i).getId()+"     "+Students.get(i).getName()+"     "+Students.get(i).getGender()+"     "+Students.get(i).getBranch());
	}
	/**
     * function to View Courses assign to the professor
     *	@return Void
     */
	public void ViewCourses(int id ) {
		List<String> Courses=professordao.ViewCourseDAO(id);
		for(int i=0;i<Courses.size();i++)
			logger.info(Courses.get(i));
	}
	/**
     * function to give Grades to the student
     *	@return void
     */
	public void GradesStudent(int id) {
		logger.info("Enter Student Id");
		 int sid = scan.nextInt();
		 logger.info("Enter Course Id");
		 int pid = scan.nextInt();
		 logger.info("Enter grade ");
		 String grade = scan.next();
		 professordao.GradeStudentDAO(sid, pid, grade);
	}
	/**
     * function to display view of the professor
     *	@return void
     */
	public void view(int id) {
		Logger logger = Logger.getLogger(StudentServiceImpl.class);
		Scanner scan = new Scanner(System.in);
		boolean val=true;
		while(val) {
			logger.info("press 1 to View Students under the professor ");
			logger.info("press 2 to View Courses Assigned ");
			logger.info("press 3 to Upload Grades");
			logger.info("press 4 to exit");
	        System.out.print("Enter the operation ");
	        int num = scan.nextInt();
	        switch (num) {
	        	case 1:
	        		this.ViewStudents(id);
	        		break;
	        	case 2:
	        		this.ViewCourses(id);
	        		break;
	        	case 3:
	        		this.GradesStudent(id);
	        		break;
	        	case 4:
	        		val=false;
	        		break;
	        }
	        
		}
	}
}

