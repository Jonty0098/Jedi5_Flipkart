package com.flipkart.business;

import com.flipkart.bean.User;

public interface UserService {
	
	public boolean RegisterUser();
	public void GetDetails(int Id);
	public User addUser();
	public void view();
}
