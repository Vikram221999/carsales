package com.stg.serviceImp;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.dto.CarDto1;
import com.stg.entity.Advertisement;
import com.stg.entity.Car;
import com.stg.entity.Premium;
import com.stg.repository.AdvertisementRepo;
import com.stg.repository.CarRepo;
import com.stg.repository.UserRepo;
import com.stg.service.AdminServiceInterface;
@Service
public class AdminServiceImpl implements AdminServiceInterface {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AdvertisementRepo advertisementRepo;
	@Autowired
	private ModelMapper mapper; 
	
	@Autowired
	private CarRepo carRepo;
	
	@Override
	public String deleteUser(int id) {
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return "User Successfully Deleted";
		}
		else {
		return "Enter the Correct User Id";
	}
	}

//	@Override
//	public List<CarDto1> readByPremium(Premium premium) {
//		List<Advertisement> advertisements = advertisementRepo.findAll();
//		List<CarDto1>cars=new ArrayList<>();
//		for (Advertisement advertisement : advertisements) {
//			if(advertisement.getCar().getPremium()==premium) {
//				Car car=advertisement.getCar();
//				CarDto1 dto=mapper.map(car, CarDto1.class); 
//				dto.setAddId(advertisement.getAdId());
//				dto.setUserId(advertisement.getUser().getUserId());
//				cars.add(dto);
//			}
//		}
//		
		
//		
//		List<Car> list=carRepo.findAllCar();
//		List<CarDto1>cars=new ArrayList<>();
//		for (Car car : list) {
//			if(car.getPremium().compareTo(premium)==0) {
//				CarDto1 dto=mapper.map(car, CarDto1.class); 
//				dto.setAddId(car.getAdvertisement().getAdId());
//				dto.setUserId(car.getAdvertisement().getUser().getUserId());
//				cars.add(dto);
//				
//			}
//		}
//	
		
//		
//		return cars;
//	}
	
	
	
	

}
