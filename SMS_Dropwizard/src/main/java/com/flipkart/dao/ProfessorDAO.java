package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface ProfessorDAO {

	public boolean registerProfessor(Professor Professor);
	public List<Student>ViewStudentDAO(int id);
	public List<String>ViewCourseDAO(int id);
	public boolean GradeStudentDAO(int sid,int cid,String grade);
}
