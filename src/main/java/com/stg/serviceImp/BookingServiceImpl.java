package com.stg.serviceImp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.mapping.Map;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.dto.BookingDto;
import com.stg.dto.MybookingDto;
import com.stg.dto.UserDto;
import com.stg.dto.UserDto1;
import com.stg.entity.Advertisement;
import com.stg.entity.Bookings;

import com.stg.entity.Bookings.Choose;
import com.stg.entity.Car;
import com.stg.entity.User;
import com.stg.exception.UserException;
import com.stg.repository.AdvertisementRepo;
import com.stg.repository.BookingRepo;
import com.stg.repository.UserRepo;
import com.stg.service.BookingServiceInterface;
import com.stg.service.UserServiceInterface;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class BookingServiceImpl implements BookingServiceInterface {

	@Autowired
	private BookingRepo bookingRepo;

	@Autowired
	private AdvertisementRepo advertisementRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserServiceInterface serviceInterface;

	@Override
	public String bookCar(int userId, int adId, int offerPrice) throws UserException {
System.out.println(userId);
		if (userRepo.existsById(userId)) {
			List<Bookings> bookingss=bookingRepo.findAll();
			boolean check=false;
			for (Bookings bookings2 : bookingss) {
				if(bookings2.getAdvertisementId()==adId && bookings2.getUser().getUserId()==userId) {
					check=true;
					break;
				}
			}
			if(check==false) {
			Advertisement advertisement = advertisementRepo.findById(adId).get();

			User user = serviceInterface.readById(userId);
			Bookings bookings = new Bookings();
			bookings.setOfferPrice(offerPrice);
			bookings.setSellerId(advertisement.getUser().getUserId());
			bookings.setAdvertisement(advertisement);
			bookings.setUser(user);
			bookings.setAdvertisementId(advertisement.getAdId());
			bookings.setBuyerDetail(advertisement.getUser().getUserId() + " Seller");
			bookings.setSellerDetail(userId + " Buyer");
			bookings.setBuyerId(userId);
			bookings.setChoose(Choose.AVAILABLE);

			bookingRepo.save(bookings);

			return "\"Your profile has been sended.\"";
			}
			else {
				throw new UserException("\"You are already book this car\"");
			}
		} else {
			throw new UserException("Id is Not found");
		}

	}

	@Override
	public List<MybookingDto> offers(int userId) throws UserException {
		// By Using Buyyer id to getting seller deatails
		
		
		
		List<MybookingDto> dtos=new ArrayList<MybookingDto>();
		if (userRepo.existsById(userId)) {

			List<Bookings> bookings = bookingRepo.findAll();

			for (Bookings booking : bookings) {
				if (booking.getBuyerId() == userId) {
//					MybookingDto dto = mapper.map(booking.getUser(), MybookingDto.class);
//					MybookingDto bookingDto = mapper.map(booking, MybookingDto.class);
					MybookingDto dto = mapper.map(booking.getAdvertisement().getCar().get(0), MybookingDto.class);
					dto.setUserId(booking.getSellerId());
					dto.setUserName(booking.getUser().getUserName());
					dto.setMobileNumber(booking.getUser().getMobileNumber());
					dto.setOfferPrice(booking.getOfferPrice());
					dtos.add(dto);
					

				}
			}
		} else {
			throw new UserException("Id is Not found");
		}
		if (dtos.size()>0) {
			return dtos;

		} else {
			throw new UserException("No data Found");
		}
		
		
		
		
//		HashMap<UserDto1, BookingDto> map = new HashMap<UserDto1, BookingDto>();
//		if (userRepo.existsById(userId)) {
//
//			List<Bookings> bookings = bookingRepo.findAll();
//
//			for (Bookings booking : bookings) {
//				if (booking.getBuyerId() == userId) {
//					UserDto1 dto = mapper.map(booking.getUser(), UserDto1.class);
//					BookingDto bookingDto = mapper.map(booking, BookingDto.class);
//					map.put(dto,bookingDto);
//
//				}
//			}
//		} else {
//			throw new UserException("Id is Not found");
//		}
//		if (map.size() > 0) {
//			return map;
//
//		} else {
//			throw new UserException("No data Found");
//		}

//		List<User> list = new ArrayList<User>();
//		if (userRepo.existsById(userId)) {
//			User user = userRepo.findById(userId).get();
//			List<Bookings> booking = user.getBookings();
//			for (Bookings bookings : booking) {
//			}
//		} else {
//			throw new UserException("Id is Not found");
//		}
//		if (list.size() > 0) {
//			return list;
//		} else {
//			throw new UserException("Miss");
//		}

	}

	@Override
	public List<MybookingDto> myBooking(int userId) throws UserException {
		
		List<MybookingDto> dtos=new ArrayList<MybookingDto>();
		if (userRepo.existsById(userId)) {

			List<Bookings> bookings = bookingRepo.findAll();

			for (Bookings booking : bookings) {
				if (booking.getSellerId() == userId) {
//					MybookingDto dto = mapper.map(booking.getUser(), MybookingDto.class);
//					MybookingDto bookingDto = mapper.map(booking, MybookingDto.class);
					MybookingDto dto = mapper.map(booking.getAdvertisement().getCar().get(0), MybookingDto.class);
					dto.setUserId(booking.getSellerId());
					dto.setUserName(booking.getUser().getUserName());
					dto.setMobileNumber(booking.getUser().getMobileNumber());
					dto.setOfferPrice(booking.getOfferPrice());
					dtos.add(dto);
					

				}
			}
		} else {
			throw new UserException("Id is Not found");
		}
		if (dtos.size()>0) {
			return dtos;

		} else {
			throw new UserException("No data Found");
		}

	}

	@Override
	public Bookings readByBookingId(int bookingId) {
		Bookings bookings = bookingRepo.findById(bookingId).get();
		System.out.println(bookings.getUser().getUserId());
		System.out.println(bookings.getUser().getUserName());
		return bookings;

	}

	@Override
	public String sellerOption(int userId, int bookingId, Choose choose) throws UserException {
		String ans = "";

		if (userRepo.existsById(userId)) {
			
			
			Bookings bookings=bookingRepo.findById(bookingId).get();
			bookings.setChoose(choose);
			bookingRepo.save(bookings);
					ans = "Done";

					// }
					// list.add(serviceInterface.readById(bookings.getBuyerId()));
				
		} else {
			throw new UserException("Id is Not found");
		}
		if (ans.length() > 0) {
			return ans;

		} else {
			throw new UserException("Miss");
		}

	}

}
