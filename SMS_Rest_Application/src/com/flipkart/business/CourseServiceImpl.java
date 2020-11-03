package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.dao.CourseDAO;
import com.flipkart.dao.CourseDAOImpl;

public class CourseServiceImpl implements CourseService {
	 private static Logger logger = Logger.getLogger(CourseServiceImpl.class);
	 CourseDAO CourseDAO = new CourseDAOImpl();
	 /**
	     * function to Get full details of the course
	     *	@return Course an course object
	     */
	public Course GetCourse(int id) {
        Course course =  CourseDAO.viewCourse(id);
        if (course != null) return course;
        logger.error("Invalid Course ID");
        return null;
    }
}
