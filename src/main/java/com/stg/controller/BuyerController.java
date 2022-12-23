package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.dto.CarDto1;
import com.stg.entity.Car;
import com.stg.entity.FuelType;
import com.stg.entity.OwnerType;
import com.stg.exception.UserException;
import com.stg.service.BuyerServiceInterface;
import com.stg.service.CarServiceInterface;

import net.bytebuddy.description.modifier.Ownership;

@RestController
@RequestMapping(value = "buyer")
public class BuyerController {
	
	@Autowired
	private CarServiceInterface carServiceInterface;
	
	@Autowired
	private BuyerServiceInterface buyerServiceInterface;
	
	@GetMapping(value = "readAllCar")
	public List<CarDto1> readAllCar() {
		List<CarDto1> cars = carServiceInterface.readAllCar();
		

		return cars;
	}

	//@GetMapping(value = "readByCarName")
	public List<CarDto1> readByCarName(@RequestParam String carName) throws UserException {
		return carServiceInterface.readByCarName(carName);
	}
	
	@GetMapping(value = "serchBy/OwnerType")
	public List<CarDto1> serchByOwnerType(@RequestParam OwnerType ownership) throws UserException {
		return buyerServiceInterface.serchByOwnerType(ownership);
	}
	@GetMapping(value = "serchBy/fuelType")
	public List<CarDto1> serchByFuelType(@RequestParam FuelType fuelType) throws UserException {
		return buyerServiceInterface.serchByFuelType(fuelType);
	}


	//@GetMapping(value = "readByYear")
	public List<CarDto1> readByYear(@RequestParam int year) throws UserException {
		return carServiceInterface.readByYear(year);
		
	}
		@GetMapping(value = "serchBy/city")
		public List<Car> serchByCity(@RequestParam String city) throws UserException {
			return buyerServiceInterface.searchByCity(city);
		}
		@GetMapping(value = "serchBy/price")
		public List<CarDto1> serchByPrice(@RequestParam int price) throws UserException {
			return buyerServiceInterface.serchByPrice(price);
		}
		
		@GetMapping(value = "serchBy/city/year/fuelType")
		public List<Car> serchByCityYearFuelType(@RequestParam String city,@RequestParam String brandName,@RequestParam FuelType fuelType) throws UserException {
			return buyerServiceInterface.serchByCityBrandNameFuelType(city,brandName,fuelType);
		}
		@GetMapping(value = "serchBy/city/brandName/owner")
		public List<Car> serchByCityYearOwner(@RequestParam String city,@RequestParam String brandName,@RequestParam OwnerType ownership) throws UserException {
			return buyerServiceInterface.serchByCityBrandNameOwner(city,brandName,ownership);
		}
		
		
//		@GetMapping(value = "serchBy/city")
//		public List<Car> serchByCity(@RequestParam String city) throws UserException {
//			return buyerServiceInterface.searchByCity(city);
//		}
	
	
	
	
	
	
	

}
