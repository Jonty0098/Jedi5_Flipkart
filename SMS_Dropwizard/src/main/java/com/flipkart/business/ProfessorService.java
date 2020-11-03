package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface ProfessorService {
	public List<Student> ViewStudents(int id);
	public List<String> ViewCourses(int id );
	public void GradesStudent(int sid,int cid,String grade);
	//public void view(int id);
	public void RegisterProfessor(Professor prof);
}
