package com.stg.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.stg.dto.CarBooking;
import com.stg.dto.CarDto1;
import com.stg.entity.Advertisement;
import com.stg.entity.Car;
import com.stg.entity.CarAddress;
import com.stg.entity.CarStatus;
import com.stg.entity.OwnerType;

import com.stg.exception.UserException;

public interface CarServiceInterface {

	public Car createCar(Car car,int userId)throws UserException;

	public List<CarBooking> readAllCar();

	public CarBooking  readByCarNumber(String carNumber)throws UserException;
	
	public Car  readByCarId(int carId)throws UserException;

	public List<CarDto1> readByCarName(String carName)throws UserException;

	public List<CarDto1> readByYear(int year)throws UserException;
	

	public Car upadateCarStatus(int id, String CarNumber, CarStatus carStatus)throws UserException;
	
	public Car updateCarName(int id, String CarNumber, String changeName)throws UserException;
	
	public Car updateDescription(int id, String CarNumber,String description)throws UserException;

	public Car upadateYearOfManufacture(int id, String CarNumber, int year)throws UserException;

	public Car upadateCarModel(int id, String CarNumber, String changeModelName)throws UserException;

	public Car updateOwnerType(int id, String CarNumber, OwnerType ownerType)throws UserException;
	
public int advertisementId(String carNumber);

public Advertisement advertisementIdByCarNumber( String carNumber);
public Advertisement advertisementIdBycarId(int adId);

}
