package com.stg.dto;

import com.stg.entity.Advertisement;
import com.stg.entity.FuelType;
import com.stg.entity.GearTransmission;
import com.stg.entity.OwnerType;
import com.stg.entity.Premium;
import com.stg.entity.StateOfRegistration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto2 {

private int carId;

private int addId;

private int userId;

private String carNumber;

	private String carName;

	private FuelType FuelType;

	private OwnerType ownerType;

	private int yearOfManufacture;

	private String carModelName;

	private GearTransmission gearTransmission;

	private int kmDriven;

	private int price;

	private String Description;
	
	private Premium premium;

	private StateOfRegistration registration;
	
	
	
	

}
