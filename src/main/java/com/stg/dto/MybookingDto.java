package com.stg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MybookingDto {
	
	
	private String carName;
	
	private int yearOfManufacture;
	
	private String carModelName;
	
	private int userId;
	
	private String userName;

	private long mobileNumber;
	
	private int offerPrice;

	

}
