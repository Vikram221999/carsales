package com.stg.dto;



import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserSign {

	private String userName;

	private String userPassword;

	private long mobileNumber;

	private String email;
	
	public UserSign( String userName, String userPassword, long mobileNumber, String email) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	


	
	
	
	
	
	
	

}
