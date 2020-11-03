package com.flipkart.business;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.dao.AdminDAO;
import com.flipkart.dao.AdminDAOImpl;
import com.flipkart.dao.ProfessorDAO;
import com.flipkart.dao.ProfessorDAOImpl;
import com.flipkart.dao.StudentDAO;
import com.flipkart.dao.StudentDAOImpl;
import com.flipkart.dao.UserDAOImpl;

public class UserServiceImpl implements UserService {
	StudentDAO studentdao = new StudentDAOImpl();
	ProfessorDAO professordao= new ProfessorDAOImpl();
	UserDAOImpl userdao= new UserDAOImpl();
	AdminDAO admindao = new AdminDAOImpl();
	Logger logger = Logger.getLogger(StudentServiceImpl.class);
	/**
     * Register All type of users
     * @return boolean
     */
	public boolean RegisterUser() {
		boolean registration=true;
		Logger logger = Logger.getLogger(StudentServiceImpl.class);
		Scanner scan = new Scanner(System.in);
		User u = this.addUser();
		switch (u.getRole()) {
		  case "student":
			
			logger.info("Enter Branch of the student ");
			String branch = scan.next();
			Student s = new Student();
			s.setEmail(u.getEmail());
			s.setGender(u.getGender());
			s.setId(u.getId());
			s.setName(u.getName());
			s.setUsername(u.getUsername());
			s.setPassword(u.getPassword());
			s.setRole(u.getRole());
			s.setRegistrationStatus(0);
			s.setBranch(branch);
			//Implement DAO
			registration=studentdao.registerStudent(s);
		    break;
		  case "professor":
			  logger.info("Enter Department of the Professor ");
				String Department = scan.next();
				Professor p = new Professor();
				p.setEmail(u.getEmail());
				p.setGender(u.getGender());
				p.setId(u.getId());
				p.setName(u.getName());
				p.setUsername(u.getUsername());
				p.setPassword(u.getPassword());
				p.setRole(u.getRole());
				p.setRegistrationStatus(0);
				p.setDepartment(Department);
				
				professordao.registerProfessor(p);
		    break;
		  case "admin":
			 // Admin admin = new Admin();
			 /// admin.setRegistrationStatus(0);
			 // admindao.AddAdmin(admin);
		    break;
		}
		return registration;
	}
	/**
     * function to get details of the user
     * @return void
     */
	public void GetDetails(int Id) {
		
		userdao.GetDetailsDAO(Id);
	}
	/**
     * function to create a user object and fetch values from user
     * @return User object
     */
	public User addUser() {
		//adding details to the user object
		Scanner scan = new Scanner(System.in);
		User u = new User();
		logger.info("Enter Id ");
		int Id = scan.nextInt();
		logger.info("Enter UserName ");
		String Username = scan.next();
		logger.info("Enter Name ");
		String Name = scan.next();
		logger.info("Enter Password ");
		String Pass = scan.next();
		logger.info("Enter Role admin||professor||student ");
		String Role = scan.next();
		logger.info("Enter Gender ");
		String gen = scan.next();
		u.setId(Id);
		u.setName(Name);
		u.setUsername(Username);
		u.setPassword(Pass);
		u.setRole(Role);
		u.setGender(gen);
		return u;	
	}
	/**
     * function to display view of the user service
     * @return void
     */
	public void view() {
		// fetch the data from the id from student table and assign it to a new object 
		// write operations of the student as a student menu
		Scanner scan = new Scanner(System.in);
		logger.info("Enter Student Id ");
		int Id=scan.nextInt();
		boolean val=true;
		while(val) {
			logger.info("press 1 to Registor User ");
			logger.info("press 2 to View a  User ");
			logger.info("press 3 to go Update a User");
			logger.info("press 4 to go Delete a User");
			logger.info("press 5 to exit");
	        System.out.print("Enter the operation ");
	        int num = scan.nextInt();
		switch (num) {
		  case 1:
			  this.RegisterUser();
		    break;
		  case 2:
			  this.GetDetails(Id);
		    break;
		  case 3:
			  //this.updateUser(Id);
		  case 4:
			  //this.removeUser(Id);
			  break;
		  case 5:
			  val=false;
			  break;
		}
	        
	}
		
	}
}
