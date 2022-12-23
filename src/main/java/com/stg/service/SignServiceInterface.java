package com.stg.service;
import java.util.List;
import com.stg.entity.Admin;
import com.stg.entity.User;
import com.stg.exception.UserException;

public interface SignServiceInterface {
	
	public abstract String createUserSign(User user) throws UserException; 
	
	public abstract String createAdmin(Admin admin)throws UserException; 
	
	
	
	
	public abstract List<User> showUser(); 
	
	


}
