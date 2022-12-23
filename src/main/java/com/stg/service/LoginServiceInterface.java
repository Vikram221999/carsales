package com.stg.service;

import com.stg.dto.UserDto1;
import com.stg.entity.User;

public interface LoginServiceInterface  {
	
	
	public User userLogin(String emailId);
	
	public String adminLogin(String emailId, String pasword);

//	public String userLogin(String email, String password);
	

}
