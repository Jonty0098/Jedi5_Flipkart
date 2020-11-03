package com.flipkart.business;

import java.util.List;
import java.util.Map;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDAOImpl;

public interface StudentService {
	public List<Course> ViewCourse(int id);
	public void AddCourse(int sid,int cid);
	public void RemoveCourse(int sid,int cid);
	public Map<String, String> ShowGrades(int id);
	public String PayFees(int id);
	public void view(int Id);
	public String asd();
	public boolean RegistorStudent(Student student);
}
