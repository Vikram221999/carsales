package com.stg.dto;

import java.util.List;

import com.stg.entity.Advertisement;
import com.stg.entity.Bookings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private int userId;
	private String userName;

	private String userPassword;

	private long mobileNumber;

	private String email;

	// private String adId;
	// private List<Advertisement> advertisements;

	private List<Bookings> bookings;

}
