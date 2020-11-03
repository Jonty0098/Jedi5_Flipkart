package com.flipkart.dao;

import java.util.List;
import java.util.Map;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public interface StudentDAO {
	public boolean registerStudent(Student student);
	public boolean addCourse(int id,int cid);
	public List<Course> viewCourse(int id);
	public boolean RemoveCourse(int id,int cid) ;
	public Map<String, String> ShowGrades(int id);
	public int getFees(int id);
	public Student GetStudent(int id);
}
