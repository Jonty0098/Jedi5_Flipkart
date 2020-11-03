package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.constants.SqlQueries;
import com.flipkart.utils.DBUtil;

public class CourseDAOImpl implements CourseDAO {
	 private static Logger logger = Logger.getLogger(CourseDAOImpl.class);
	    private Connection connection = DBUtil.getConnection();
	    private PreparedStatement stmt = null;
	    /**
	     * get course data from db
	     * @return Course Object
	     */
	    public Course viewCourse(int Id) {
	        //List<Course> courseList = new ArrayList<>();
	    	Course course = new Course();
	        try {
	            stmt = connection.prepareStatement(SqlQueries.GetCourse );
	            stmt.setInt(1, Id);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                course=createCourse(rs);
	            }
	        } catch(Exception ex){
	            logger.error(ex.getMessage());
	        } finally{
	            //close resources
	            DBUtil.closeStmt(stmt);
	        }
	        return course;
	    }
	    /**
	     * create a course object to return to the service
	     * @return Course object
	     */
	    public Course createCourse(ResultSet rs)  {
	    	Course course = new Course();
	        try {
	        	course.setId(rs.getInt("id"));
		        course.setName(rs.getString("name"));
		        course.setDiscription(rs.getString("description"));
		        course.setFee(rs.getInt("fee"));
	        } catch(Exception ex){
	            logger.error(ex.getMessage());
	        }
	        return course;
	    }
	    
}
