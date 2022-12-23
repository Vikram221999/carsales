package com.stg.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor


public class AdminLoginDto {

	private String adminPassword;
	private String adminEmail;

}
