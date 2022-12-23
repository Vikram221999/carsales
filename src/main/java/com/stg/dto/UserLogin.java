package com.stg.dto;


import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class UserLogin {
	
	
	private String email;
	
	private String userPassword;
	
	

	public UserLogin(String email, String userPassword) {
		super();
		this.email = email;
		this.userPassword = userPassword;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	

}
