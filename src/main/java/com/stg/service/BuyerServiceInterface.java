package com.stg.service;

import java.util.List;

import com.stg.dto.CarDto1;
import com.stg.entity.Car;
import com.stg.entity.FuelType;
import com.stg.entity.OwnerType;
import com.stg.exception.UserException;


public interface BuyerServiceInterface {
	
	
	public List<Car> searchByCity(String city)throws UserException;
	
	public List<Car> serchByCityYearBrand(String city,String brandName,int year)throws UserException;
	
	public List<Car> serchByCityBrandNameFuelType(String city,String brandName,FuelType fuelType)throws UserException;

	public List<Car> serchByCityBrandNameOwner(String city,String brandName,OwnerType ownerType)throws UserException;
	
	public List<CarDto1> serchByOwnerType(OwnerType ownerType)throws UserException;
	
	public List<CarDto1> serchByPrice(int price)throws UserException;
	
	public List<CarDto1> serchByFuelType(FuelType fuelType)throws UserException;
}
