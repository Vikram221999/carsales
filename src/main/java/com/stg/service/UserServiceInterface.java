package com.stg.service;

import java.util.List;

import com.stg.entity.Address;
import com.stg.entity.Car;
import com.stg.entity.User;
import com.stg.exception.UserException;

public interface UserServiceInterface {
	

	public abstract List<User> showUser();
	
	public abstract List<Car> carReadById(int userId);
	
	public abstract User readById(int id)throws UserException;
	
	public abstract Address addressReadById(int id)throws UserException;
	
	public abstract User readByMobileNumber(long mobile)throws UserException;
	
	public abstract List<User> readByName(String name)throws UserException;
	
	
	public abstract User updateName(String email,String name)throws UserException;
	
	public abstract User updatePassword(String email,String password)throws UserException;
	
	public abstract User updateMobileNumber(String email,long mobileNumber)throws UserException;

	public abstract User updateEmail(String email,String chaneEmail)throws UserException;

	public abstract User readByEmail(String email) throws UserException;
	
	public abstract String deleteUser(int id);
	
	
}
