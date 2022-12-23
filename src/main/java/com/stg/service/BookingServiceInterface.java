package com.stg.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.stg.dto.BookingDto;
import com.stg.dto.MybookingDto;
import com.stg.dto.UserDto1;
import com.stg.entity.Bookings;
import com.stg.entity.User;
import com.stg.entity.Bookings.Choose;
import com.stg.exception.UserException;

public interface BookingServiceInterface {
	public String bookCar(int userId,int adId,int offerPrice)throws UserException;
	
	public List<MybookingDto>  myBooking(int userId)throws UserException;
	
	public List<MybookingDto> offers(int userId)throws UserException;
	
	public Bookings readByBookingId(int bookingId);
	
	public String sellerOption(int userId,int bookingId, Choose choose ) throws UserException;
	
	

}
