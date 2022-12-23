package com.stg.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.dto.UserDto1;
import com.stg.entity.Admin;
import com.stg.entity.User;
import com.stg.repository.AdminRepo;
import com.stg.repository.UserRepo;
import com.stg.service.LoginServiceInterface;


@Service
public class LoginServiceImp implements LoginServiceInterface {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public User userLogin(String email) {
		List<User> list=userRepo.findAll();
		User dto1=userRepo.findByEmail(email);
		String ans="";
		UserDto1 user =new UserDto1();
		
//		for (User users : list) {
//			if(email.equalsIgnoreCase(users.getEmail())) {
//				if(password.equals(users.getUserPassword())) {
//					user.setUserId(users.getUserId());
//					user.setUserName(users.getUserName());
//					user.setEmail(users.getEmail());
//					user.setMobileNumber(users.getMobileNumber());
//				}
//			}
//			else {
//				ans="Enter the correct MAILID";
//			}
//		}
		return dto1;
	}

	@Override
	public String adminLogin(String emailId, String password) {
		
		List<Admin> list=adminRepo.findAll();
		String ans="";
		for (Admin admin : list) {
			if(emailId.equalsIgnoreCase(admin.getAdminEmail())) {
				if(password.equals(admin.getAdminPassword())) {
					ans="Successfully Logined ";
					break;
				}
			}
			else {
				ans="Enter the correct MAILID";
			}
		}
		return ans;
	}
	
	
	
	

}
