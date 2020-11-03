package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.User;

public interface AdminService {
	public void ApproveRegistration(int id);
	public void AssignCourse (int cid,int pid);
	public List<User> GetAllUsers();
	public void DeleteUser(int id);
	//public void view(int id);
}
