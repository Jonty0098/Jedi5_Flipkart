package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.flipkart.constants.SqlQueries;
import com.flipkart.utils.DBUtil;

public class AthenticationDAOImpl implements AuthenticationDAO {
	private static Logger logger = Logger.getLogger(AthenticationDAOImpl.class);
	private Connection connection = DBUtil.getConnection();
	PreparedStatement stmt =null;
	/**
     * Check Credentials with Database
     * @return int  the id of the user
     */
	public int loginDAO(String Username, String Password) {
		//logger.info("Exicute");
		//boolean re=false;
		int id = 0;
        try {
        	//logger.info("Exicute");
            stmt = connection.prepareStatement(SqlQueries.LoginUser);
            stmt.setString(1, Username);
            stmt.setString(2, Password);
            ResultSet rs = stmt.executeQuery();
            //logger.info("Exicute");
            //if (rs == null) {
               // throw new UserNotFoundException("Invalid credentials. Please try again");
           // }}
            rs.next();
            id = rs.getInt("Id");
            int Status = rs.getInt("Status");
            
            //if(Status==0)
            
             id=id*Status;
        
           
        } catch(Exception ex){
            logger.error(ex.getMessage());
        } finally{
            //close resources
            DBUtil.closeStmt(stmt);
        }
       
        return id;       		
	//return re;
}
}

