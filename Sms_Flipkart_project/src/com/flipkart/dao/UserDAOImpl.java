/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceImpl;
import com.flipkart.business.ProfessorServiceImpl;
import com.flipkart.business.StudentServiceImpl;
import com.flipkart.constants.SqlQueries;
import com.flipkart.utils.DBUtil;

/**
 * @author ShabbirMoosakhan
 *
 */
public class UserDAOImpl {
	StudentServiceImpl studentservice = new StudentServiceImpl();
	AdminService adminservice = new AdminServiceImpl();
	ProfessorServiceImpl professorservice = new ProfessorServiceImpl();
	private static Logger logger = Logger.getLogger(AthenticationDAOImpl.class);
	private Connection connection = DBUtil.getConnection();
	PreparedStatement stmt =null;
	public void GetDetailsDAO(int Id) {
		try {
		 	stmt = connection.prepareStatement(SqlQueries.GetUser);
		    stmt.setInt(1, Id);
		    ResultSet result = stmt.executeQuery();
		    result.next();
		    int id =result.getInt("Id");
		    String role = result.getString("Role");
		    switch(role) {
		    case "professor":
		    	professorservice.view(id);
		    	break;
		    case "student":
		    	studentservice.view(id);
		    	
		    	break;
		    case "admin":
		    	adminservice.view(id);	
		    	break;
		    }  
	 }catch(Exception ex){
         logger.error(ex.getMessage());
     } finally{
         DBUtil.closeStmt(stmt);
     }
	}
}
