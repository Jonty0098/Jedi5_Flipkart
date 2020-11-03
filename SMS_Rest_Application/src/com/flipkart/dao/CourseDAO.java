package com.flipkart.dao;

import java.sql.ResultSet;

import com.flipkart.bean.Course;

public interface CourseDAO {
	public Course viewCourse(int Id);
	public Course createCourse(ResultSet rs);
	
}
