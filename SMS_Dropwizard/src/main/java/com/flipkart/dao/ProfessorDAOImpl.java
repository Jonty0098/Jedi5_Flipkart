package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constants.SqlQueries;
import com.flipkart.utils.DBUtil;

public class ProfessorDAOImpl implements ProfessorDAO {
	private static Logger logger = Logger.getLogger(StudentDAOImpl.class);
    private Connection connection = DBUtil.getConnection();
    private PreparedStatement stmt = null;
    StudentDAOImpl SDAO = new StudentDAOImpl();
    /**
     * Add professor data to login and user table
     * @return boolean
     */
	public boolean registerProfessor(Professor Professor) {
        try {
        	//pushing data of student to the data base
        	//logger.info(student.getRole());
            stmt = connection.prepareStatement(SqlQueries.RegistorProfessor);
            stmt.setInt(1, Professor.getId());
            stmt.setString(2, Professor.getName());
            stmt.setString(3, Professor.getGender());
            stmt.setString(4, Professor.getDepartment());
            stmt.setString(5, Professor.getRole());
            
            int rowCount = stmt.executeUpdate();
            logger.info(Professor.getUsername());
            stmt = connection.prepareStatement(SqlQueries.AddProfessorLogin);
            stmt.setString(1, Professor.getUsername());
            stmt.setString(2, Professor.getPassword());
            stmt.setInt(3,Professor.getId());
            stmt.setInt(4, Professor.getRegistrationStatus());
            
             stmt.executeUpdate();
            if (rowCount>0){//&&rowCount1>0) {
                logger.info("Student with name : " + Professor.getName() + " was added successfully");
                DBUtil.closeStmt(stmt);
                return true;
            }
            logger.error("Student could not be registered. Please try again.");
        } catch(Exception ex){
            logger.error(ex.getMessage());
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
        return false;
    }
	/**
     * get students data under the professor from the db
     * @return list of student objects
     */
	public List<Student>ViewStudentDAO(int id) {
		List<Student> Students = new ArrayList<Student>();
		try {
        	//pushing data of student to the data base
        	//logger.info(student.getRole());
            stmt = connection.prepareStatement(SqlQueries.GetStudents);
            stmt.setInt(1, id);
            stmt.execute();	 
            ResultSet rs =stmt.executeQuery();
            while(rs.next())
            {
            	Students.add(SDAO.GetStudent(rs.getInt(1)));
            }
            } catch(Exception ex){
            logger.error(ex.getMessage());
            
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
	return Students ;
		
	}/**
     * get the courses alloted to the professor from the db
     * @return list of course objects
     */
	public List<String>ViewCourseDAO(int id) {
		List<String> Courses = new ArrayList<String>();
		try {
        	//pushing data of student to the data base
        	//logger.info(student.getRole());
            stmt = connection.prepareStatement(SqlQueries.ViewAssignCourse);
            stmt.setInt(1, id);
            stmt.execute();	 
            ResultSet rs =stmt.executeQuery();
            while(rs.next())
            {
            	Courses.add(rs.getString(1));
            }
            } catch(Exception ex){
            logger.error(ex.getMessage());
            
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
	return Courses ;
		
	}/**
     * Update the grades of a student fro a subject to the db
     * @return boolean
     */
	public boolean GradeStudentDAO(int sid,int cid,String grade)
	{
		try {
        	//pushing data of student to the data base
        	//logger.info(student.getRole());
            stmt = connection.prepareStatement(SqlQueries.GradeStudent);
            stmt.setString(1, grade);
            stmt.setInt(2, cid);
            stmt.setInt(3, sid);
            stmt.execute();	 
            stmt.executeUpdate();
            
            } catch(Exception ex){
            logger.error(ex.getMessage());
            
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
		return true;
	}
}
