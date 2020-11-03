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
	private static Logger logger = Logger.getLogger(AthenticationDAOImpl.class);
	private Connection connection = DBUtil.getConnection();
	PreparedStatement stmt =null;
public void GetDetailsDAO(int Id) {
	StudentServiceImpl ssi = new StudentServiceImpl();
	AdminService asi = new AdminServiceImpl();
	ProfessorServiceImpl psi = new ProfessorServiceImpl();
	 try {
		 	stmt = connection.prepareStatement(SqlQueries.GetUser);
		    stmt.setInt(1, Id);
		    ResultSet rs1 = stmt.executeQuery();
		    rs1.next();
		    int id =rs1.getInt("id");
		    String role = rs1.getString("role");
		    switch(role) {
		    case "P":
		    	//psi.view(id);
		    	break;
		    case "S":
		    	//ssi.view(id);
		    	
		    	break;
		    case "A":
		    	//asi.view(id);
		    	
		    	break;
		    }
			
        
	 }catch(Exception ex){
         logger.error(ex.getMessage());
     } finally{
         //close resources
         DBUtil.closeStmt(stmt);
     }
	
}
}
