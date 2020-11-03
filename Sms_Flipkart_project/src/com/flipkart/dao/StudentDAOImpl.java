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
import com.flipkart.exception.UserException;
import com.flipkart.utils.DBUtil;

public class StudentDAOImpl implements StudentDAO {
	private static Logger logger = Logger.getLogger(StudentDAOImpl.class);
    private Connection connection = DBUtil.getConnection();
    CourseService courseservice = new CourseServiceImpl();
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
        	if(student.getId()<1)
        		throw new UserException("negetive ID not allowed Custom Exception");
            stmt = connection.prepareStatement(SqlQueries.RegistorStudent);
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getGender());
            stmt.setString(4, student.getBranch());
            stmt.setString(5, student.getRole());
            stmt.executeUpdate();
            stmt = connection.prepareStatement(SqlQueries.AddStudentLogin);
            stmt.setString(1, student.getUsername());
            stmt.setString(2, student.getPassword());
            stmt.setInt(3,student.getId());
            stmt.setInt(4, student.getRegistrationStatus());
            stmt.executeUpdate();
        } catch(Exception ex){
            logger.error(ex.getMessage());
            return false;
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
        return true;
    }
	/**
     * Add course to the db for the student
     * @return boolean
     */
	public boolean addCourse(int id,int cid) {
		 try {
	        	//pushing data of student to the data base
	        	//logger.info(student.getRole());
	            stmt = connection.prepareStatement(SqlQueries.AddCourse);
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
	}
	/**
     * get all the registored courses of the student
     * @return boolean
     */
	public List<Course> viewCourse(int id) {
		 List<Course> courses = new ArrayList<Course>();
		try {
        	//pushing data of student to the data base
        	//logger.info(student.getRole());
			
            stmt = connection.prepareStatement(SqlQueries.ViewCourse);
            stmt.setInt(1, id);
            ResultSet result =stmt.executeQuery();
            while(result.next())
            {
            	courses.add(courseservice.GetCourse(result.getInt("courseid")));
            }
        	} catch(Exception ex){
        		logger.error(ex.getMessage());    
        	} finally{
        		//close resources
        		DBUtil.closeStmt(stmt);
        	}
	return courses;
			
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
	            logger.error(ex.getMessage());
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
	            logger.error(ex.getMessage());
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
		            {return s;}
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
		            logger.error(ex.getMessage());
		        } finally{
		            //close resources
		            DBUtil.closeStmt(stmt);
		        }
		        return s;
		    }
	 
}
