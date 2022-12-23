package com.stg.dto;
import com.stg.entity.CarAddress;
import com.stg.entity.FuelType;
import com.stg.entity.GearTransmission;
import com.stg.entity.OwnerType;
import com.stg.entity.Premium;
import com.stg.entity.StateOfRegistration;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CarDto {

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

	public CarDto(int userId, String carNumber, String carName, com.stg.entity.FuelType fuelType, OwnerType ownerType,
			int yearOfManufacture, String carModelName, GearTransmission gearTransmission, int kmDriven, int price,
			String description,Premium premium, StateOfRegistration registration) {
		super();
		this.userId = userId;
		this.carNumber = carNumber;
		this.carName = carName;
		FuelType = fuelType;
		this.ownerType = ownerType;
		this.yearOfManufacture = yearOfManufacture;
		this.carModelName = carModelName;
		this.gearTransmission = gearTransmission;
		this.kmDriven = kmDriven;
		this.price = price;
		this.Description = description;
		

	}

	
	

}
