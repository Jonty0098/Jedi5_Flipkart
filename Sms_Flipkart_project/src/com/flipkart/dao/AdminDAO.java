package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.User;

public interface AdminDAO {

	public boolean approveRegistration(int id) ;
	public boolean AssignCourseDAO(int cid,int pid);
	public  List<User>GetAllUsers();
	public void DeleteUserDAO(int id);	
	//public void AddAdmin(User user);
}

