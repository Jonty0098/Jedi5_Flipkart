package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.constants.SqlQueries;
import com.flipkart.utils.DBUtil;

public class AdminDAOImpl implements AdminDAO {
	private static Logger logger = Logger.getLogger(StudentDAOImpl.class);
	private Connection connection = DBUtil.getConnection();
	PreparedStatement stmt =null;
	/**
     * DAO to update registration status of the user 
     * @return boolean
     */
	public boolean approveRegistration(int userid) 
	{	
	try {	
		stmt = connection.prepareStatement(SqlQueries.ApproveRegistration);
	    stmt.setInt(1, 1);
	    stmt.setInt(2, userid);
	    stmt.executeUpdate();
        }catch(Exception ex){
            logger.error(ex.getMessage());
            return false;
        }finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
	return true;   
	}
	/**
     * DAO to assign course to the professor
     * @return boolean
     */
	public boolean AssignCourseDAO(int courseid,int professorid) 
	{
	    try {
        	
	    	stmt = connection.prepareStatement(SqlQueries.AssignProfessor);
		    stmt.setInt(1, courseid);
		    stmt.setInt(2, professorid);
		    stmt.executeUpdate();
            } catch(Exception ex){
            logger.error(ex.getMessage());
            return false;
            } finally{
            //close resources
            DBUtil.closeStmt(stmt);
            }
	return true;
	    
	}
	/**
     * DAO to get all data of all users
     * @return List of user objects
     */
	public  List<User>GetAllUsers() 
	{
		List<User> Users = new ArrayList<User>();
	    try {
	    	stmt = connection.prepareStatement(SqlQueries.ViewAllUsers);
            ResultSet rs =stmt.executeQuery();
            while(rs.next())
            {	User u = new User();
            	u.setId(rs.getInt(1));
            	u.setName(rs.getString(2));
            	u.setGender(rs.getString(3));
            	u.setRole(rs.getString(4));
            	Users.add(u);
            }
            } catch(Exception ex){
            logger.error(ex.getMessage());
            //return false;
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
	return Users;    
	}
	/**
     * DAO to Delete User
     * @return void
     */
	public void DeleteUserDAO(int id)
	{
		try {
	    	stmt = connection.prepareStatement(SqlQueries.DeleteUsers);
	    	 stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt = connection.prepareStatement(SqlQueries.DeleteLogin);
	    	 stmt.setInt(1, id);
           stmt.executeUpdate();
            } catch(Exception ex){
            logger.error(ex.getMessage());
            //return false;
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
	}
	/*public void AddAdmin(User user) {
		 try {
	        	//pushing data of student to the data base
	        	//logger.info(student.getRole());
	            stmt = connection.prepareStatement(SqlQueries.RegistorStudent);
	            stmt.setInt(1, user.getId());
	            stmt.setString(2, user.getName());
	            stmt.setString(3, user.getGender());
	            stmt.setString(4, user.getBranch());
	            stmt.setString(5, user.getRole());
	            stmt.executeUpdate();
	            stmt = connection.prepareStatement(SqlQueries.AddStudentLogin);
	            stmt.setString(1, user.getUsername());
	            stmt.setString(2, user.getPassword());
	            stmt.setInt(3,user.getId());
	            stmt.setInt(4, user());
	            stmt.executeUpdate();
	        } catch(Exception ex){
	            logger.error(ex.getMessage());
	            return false;
	        } finally{
	            //close resources
	            DBUtil.closeStmt(stmt);
	        }
	        return true;
	    }
	}*/
}
