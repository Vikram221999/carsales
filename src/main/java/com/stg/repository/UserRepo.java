package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stg.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	public boolean existsByMobileNumber(long mobileNumber);
	//public boolean existsByUserName(String userName);
	List<User> findByUserName(String UserName);

	User findByEmail(String Email);
	public boolean existsByEmail(String email);
	public boolean existsByUserName(String name);
	public User findByMobileNumber(long mobile);


	
	

}
