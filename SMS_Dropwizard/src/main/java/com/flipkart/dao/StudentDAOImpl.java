package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.business.CourseService;
import com.flipkart.business.CourseServiceImpl;
import com.flipkart.constants.SqlQueries;
import com.flipkart.utils.DBUtil;

public class StudentDAOImpl implements StudentDAO {
	//
	private static Logger logger = Logger.getLogger(StudentDAOImpl.class);
    private Connection connection = DBUtil.getConnection();
    //CourseDAOImpl CDAO = new CourseDAOImpl();
    CourseService CSI = new CourseServiceImpl();
    private PreparedStatement stmt = null;
    /**
     * Push Student Data to database
     *
     * @param student the Student object
     * @param password the password of the student
     * @return the boolean
     */
	public boolean registerStudent(Student student) {
        try {
        	//pushing data of student to the data base
        	//logger.info(student.getRole());
            stmt = connection.prepareStatement(SqlQueries.RegistorStudent);
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getGender());
            stmt.setString(4, student.getBranch());
            stmt.setString(5, student.getRole());
            
            int rowCount = stmt.executeUpdate();
           // logger.info(student.getUsername());
            stmt = connection.prepareStatement(SqlQueries.AddStudentLogin);
            stmt.setString(1, student.getUsername());
            stmt.setString(2, student.getPassword());
            stmt.setInt(3,student.getId());
            stmt.setInt(4, student.getRegistrationStatus());
            
             stmt.executeUpdate();
            if (rowCount>0){//&&rowCount1>0) {
               // logger.info("Student with name : " + student.getName() + " was added successfully");
                DBUtil.closeStmt(stmt);
                return true;
            }
           // logger.error("Student could not be registered. Please try again.");
        } catch(Exception ex){
            logger.error(ex.getMessage());
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
        return false;
    }
	/**
     * Add course to the db for the student
     * @return boolean
     */
	public boolean addCourse(int id,int cid) {
		 try {
	        	//pushing data of student to the data base
	        	//logger.info(student.getRole());
			 //System.out.println("asasf");
	            stmt = connection.prepareStatement(SqlQueries.AddCourse);
	            stmt.setInt(1, id);
	            stmt.setInt(2, cid);
	            stmt.execute();	 
	            
	            } catch(Exception ex){
	           // logger.error(ex.getMessage());
	            	//System.out.println("asasf");
	            return false;
	        } finally{
	            //close resources
	            DBUtil.closeStmt(stmt);
	        }
		return true;
	}
	/**
     * get all the registored courses of the student
     * @return boolean
     */
	public List<Course> viewCourse(int id) {
		 List<Course> Courses = new ArrayList<Course>();
		try {
			
            stmt = connection.prepareStatement(SqlQueries.ViewCourse);
            //System.out.println("asaasdasdsf");
            stmt.setInt(1, id);
           // System.out.println("asasasf");
            ResultSet rs =stmt.executeQuery();
            //System.out.println("asasf");
            while(rs.next())
            {
            	//System.out.println("asasf");
            	//System.out.println(rs.getInt("CId"));
            	
            	Courses.add(CSI.GetCourse(rs.getInt("courseid")));
            }
		}
         catch(Exception ex){
           logger.error(ex.getMessage());
        	//System.out.println(ex.getStackTrace());
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
	//List<Course> Courses;
	return Courses;		
	}
	/**
     * Remove courses from the db for the student
     * @return boolean
     */
	public boolean RemoveCourse(int id,int cid) {
		try {
        	//pushing data of student to the data base
        	//logger.info(student.getRole());
            stmt = connection.prepareStatement(SqlQueries.RemoveCourse);
            stmt.setInt(1, id);
            stmt.setInt(2, cid);
            stmt.execute();	 
            
            } catch(Exception ex){
            logger.error(ex.getMessage());
            return false;
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
	return true;
		
	}/**
     * get grades fro a student
     * @return Map of string and string 
     */
	 public Map<String, String> ShowGrades(int id) {
	        Map<String, String> reportCard = new HashMap<>();
	        try {
	            stmt = connection.prepareStatement(SqlQueries.ViewGrade);
	            stmt.setInt(1,id);
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()) {
	                reportCard.put(rs.getString(2), rs.getString(3));
	            }
	            stmt.close();
	        } catch(Exception ex){
	          //  logger.error(ex.getMessage());
	        } finally{
	            //close resources
	            DBUtil.closeStmt(stmt);
	        }
	        return reportCard;
	    }
	 /**
	     * calculate fees of the students
	     * @return int fees
	     */
	 public int getFees(int id) {
	       int fees=0;
	        try {
	            stmt = connection.prepareStatement(SqlQueries.ViewFees);
	            stmt.setInt(1,id);
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()) {
	                fees=fees+rs.getInt(1);
	            }
	            stmt.close();
	        } catch(Exception ex){
	          //  logger.error(ex.getMessage());
	        } finally{
	            //close resources
	            DBUtil.closeStmt(stmt);
	        }
	        return fees;
	    } 
	 /**
	     * get all the data for the student 
	     * @return Student object
	     */
	 public Student GetStudent(int id) {
		      Student s = new Student();
		        try {
		            stmt = connection.prepareStatement(SqlQueries.GetStudentData);
		            stmt.setInt(1,id);
		            ResultSet rs = stmt.executeQuery();
		            if(rs==null)
		            {}
		            else
		            {
		            	rs.next();
		            	s.setId(rs.getInt(1));
		            	s.setName(rs.getString(2));
		            	s.setGender(rs.getString(3));
		            	s.setBranch(rs.getString(4));
		            }
		            
		            stmt.close();
		        } catch(Exception ex){
		          ///  logger.error(ex.getMessage());
		        } finally{
		            //close resources
		            DBUtil.closeStmt(stmt);
		        }
		        return s;
		    }
	 
}
