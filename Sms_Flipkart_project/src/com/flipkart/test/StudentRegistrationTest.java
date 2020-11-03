/**
 * 
 */
package com.flipkart.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.flipkart.bean.Student;
import com.flipkart.business.UserServiceImpl;
import com.flipkart.dao.StudentDAOImpl;

/**
 * @author ShabbirMoosakhan
 *
 */
class StudentRegistrationTest {
	@Test
	void test1() {
		UserServiceImpl usi= new UserServiceImpl();
		assertEquals(true,usi.RegisterUser());
	}
	@Test
	void test2() {
		//fail("Not yet implemented");
		StudentDAOImpl studentdao = new StudentDAOImpl();
		  List<Student> student = new ArrayList<Student>();
		  List<Integer> Id = Arrays.asList(1, 12,3);
		  List<String> Name = Arrays.asList("Burhan", "Hitesh","Neha");
		  List<String> Gender = Arrays.asList("Male", "Male","Female");
		  List<String> Branch = Arrays.asList("Cse", "Ece","Cse");
		  List<String> Role = Arrays.asList("student", "student","student");
		  List<String> Password = Arrays.asList("adfadf", "adfadf","afdaf");
		  for(int i=0;i<3;i++)
		  {
			  Student s = new Student();
			  s.setId(Id.get(i));
			  s.setName(Name.get(i));
			  s.setGender(Gender.get(i));
			  s.setBranch(Branch.get(i));
			  s.setRole(Role.get(i));
			  student.add(s);
			  studentdao.registerStudent(student.get(i));
		  }
		 
	}
	

}
