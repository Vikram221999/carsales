package com.stg.controller;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stg.dto.BookingDto;
import com.stg.dto.MybookingDto;
import com.stg.dto.UserDto;
import com.stg.dto.UserDto1;
import com.stg.entity.Bookings;
import com.stg.entity.Bookings.Choose;
import com.stg.entity.User;
import com.stg.exception.UserException;
import com.stg.service.BookingServiceInterface;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping(value = "booking")
public class BookingController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private BookingServiceInterface bookingServiceInterface;

	@PostMapping(value = "bookCar")
	public String bookCar(@RequestBody BookingDto dto )
			throws UserException {
		System.out.println(dto);
		return bookingServiceInterface
				.bookCar(/* id,adId,offerPrice */dto.getUserId(), dto.getAdId(), dto.getOfferPrice());

	}
	
	@PutMapping(value = "sellerOption")
	public String sellerOption(@RequestParam int userId,@RequestParam int bookingId ,@RequestParam Choose choose ) throws UserException {
		return bookingServiceInterface.sellerOption(userId, bookingId, choose);
	}
	
	@GetMapping(value = "myBooking/{userId}")
	public ResponseEntity<List<MybookingDto> > myBooking(@PathVariable int userId)throws UserException{
//		User user=bookingServiceInterface.readBuyerDetails(userId);
//		UserDto dto=mapper.map(user, UserDto.class);
//		return new ResponseEntity<List<UserDto> >(dto, HttpStatus.OK);
		
		List<MybookingDto> user = bookingServiceInterface.myBooking(userId);
//		Type listType = new TypeToken<List<UserDto1>>() {
//	}.getType();
//		List<UserDto1> carDto1s = mapper.map(user, listType);
		
		return new ResponseEntity<List<MybookingDto>>(user, HttpStatus.OK);
	}
	
	//@GetMapping(value = "readSellerDetails")
	@GetMapping(value = "offers/{userId}")
	public ResponseEntity<List<MybookingDto>> offers(@PathVariable int userId)throws UserException{
		List<MybookingDto> user = bookingServiceInterface.offers(userId);
//		Type listType = new TypeToken<List<UserDto>>() {
//	}.getType();
//		List<UserDto> carDto1s = mapper.map(user, listType);
		
		return new ResponseEntity<List<MybookingDto> >(user, HttpStatus.OK);
		
		//return new ResponseEntity<List<Bookings>>(bookingServiceInterface.readSellerDetails(userId), HttpStatus.OK);
	}
//	@GetMapping(value = "readByBookingId/{userId}")
	public Bookings readByBookingId(@PathVariable int userId) {
		return bookingServiceInterface.readByBookingId(userId);
		
	}

}
