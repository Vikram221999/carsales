package com.stg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Car {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	
//	@Column(columnDefinition = "default '00000000'")
	@NotEmpty
	@Column(unique = true)
	private String carNumber;
	
	@Column(length = 10)
	private String carName;
	
	
//	@Enumerated(EnumType.STRING)
	private FuelType FuelType;
	
	private OwnerType ownerType;
	
	
	@Column(length = 4)
	private int yearOfManufacture;
	
	@Column(length = 20)
	private String carModelName;
	
	
	
	private GearTransmission  gearTransmission;
	
	
	@Column(length = 6)
	private int kmDriven;
	
	private CarStatus carStatus;
	
	@Column(length = 10)
	private int price;
	
	
	private String Description;

	
	@Enumerated(EnumType.ORDINAL)
	private Premium premium;
	
	
	
	private StateOfRegistration registration;
//	
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "car")
//	@JsonManagedReference
//	private CarAddress carAddress;
	


	
	
//	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//	@JoinColumn(name = "adId")
//	@JsonBackReference
//	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//	@JoinColumn(name = "userId")
//	@JsonBackReference(value = "userAdvertisement")
	
	@JsonBackReference(value = "userCar")
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	@JoinColumn(name = "adId")
	private Advertisement advertisement;
	
//	private int adId;

//	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//	@JoinColumn(name = "userId")
//	@JsonBackReference
//	private User user;

	public Car(int carId, @NotEmpty String carNumber, String carName, com.stg.entity.FuelType fuelType,
			OwnerType ownerType, int yearOfManufacture, String carModelName, GearTransmission gearTransmission,
			int kmDriven, int price, String description, Premium premium, StateOfRegistration registration) {
		super();
		this.carId = carId;
		this.carNumber = carNumber;
		this.carName = carName;
		FuelType = fuelType;
		this.ownerType = ownerType;
		this.yearOfManufacture = yearOfManufacture;
		this.carModelName = carModelName;
		this.gearTransmission = gearTransmission;
		this.kmDriven = kmDriven;
		this.price = price;
		Description = description;
		this.premium = premium;
		this.registration = registration;
		
	}
	
	
//	public Car(int price2, String carNumber2, String carName2, com.stg.entity.FuelType fuelType2, OwnerType ownerType2,
//			int yearOfManufacture2, String carModelName2, GearTransmission gearTransmission2, int kmDriven2, int price3,
//			String description2, Premium premium2, StateOfRegistration registration2, CarAddressDto carAddress2,
//			User user2) {
//		
//	}
	
	

}
