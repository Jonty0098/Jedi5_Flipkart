package com.flipkart.constants;

public class SqlQueries {
	//User
	 public static final String LoginUser = "select Id,Status from login where Username = ? and Password = ?";
	 public static final String GetUser = "select * from user where Id= ?";
	
	//Student
	public static String RegistorStudent="insert into User(Id,Name,Gender,Branch,Role) values (?,?,?,?,?)";
	public static String GetStudentData= "select Id,Name,Gender,Branch from user where id=?";
	public static String AddStudentLogin="insert into login(username, password,id,status) values (?,?,?,?)";
	public static String AddCourse="insert into grade(studentid,courseid) values (?,?)";
	public static String RemoveCourse="delete from grade where studentid = ? and courseid = ?";
	public static String ViewCourse="select courseid from grade where studentid =? ";
	public static String ViewGrade="select c.id, c.name, g.grade from course c join grade g on c.id = g.courseid where g.studentid = ?";
	public static String ViewFees="select c.fee from course c join grade g on c.id = g.courseid where g.studentid = ?";
	
	
	//professor
	public static String RegistorProfessor="insert into User(id,name,gender,department,role) values (?,?,?,?,?)";
	public static String AddProfessorLogin="insert into login(username, password,id,status) values (?,?,?,?)";
	public static  String GetStudents = "select g.studentid from grade g join professorcourse p on g.courseid=p.courseid where p.professorid=?";
	public static  String ViewAssignCourse = "select c.name from course c join professorcourse p on p.courseid=c.id where p.professorid=?";
	public static  String GradeStudent = "update grade SET grade=? WHERE courseid = ? AND studentid= ?";
	
	
	//Course
	 public static final String GetCourse = "select * from course where id= ?";
	 
	
	
	///Admin
	public static String AdminLoginr="insert into User(id,name,gender,department,role) values (?,?,?,?,?)";
	public static String ApproveRegistration="update login SET status=? WHERE id = ?";
	public static String AssignProfessor="insert into professorcourse (courseid,professorid) values (?,?)";
	public static String ViewAllUsers="select id,name,gender,role from user";
	public static String DeleteUsers="delete from user where id = ?";
	public static String DeleteLogin="delete from login where id = ?";
	
	
	
	
}
