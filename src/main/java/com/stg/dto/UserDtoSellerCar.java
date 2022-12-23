package com.stg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoSellerCar {
	

	private String userName;

	private String userPassword;

	private long mobileNumber;

	private String email;
	
	private CarDto1 carDto;

}
