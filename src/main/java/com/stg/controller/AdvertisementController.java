package com.stg.controller;

import java.lang.reflect.Type;
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
import org.springframework.web.bind.annotation.RestController;

import com.stg.dto.AddressDto;
import com.stg.dto.CarBooking;
import com.stg.dto.CarDto;
import com.stg.dto.CarDto1;
import com.stg.dto.CarDto2;
import com.stg.dto.CarDto3;
import com.stg.entity.Address;
import com.stg.entity.Advertisement;
import com.stg.entity.Car;
import com.stg.entity.CarStatus;
import com.stg.entity.GearTransmission;
import com.stg.entity.OwnerType;
import com.stg.entity.Premium;
import com.stg.entity.StateOfRegistration;
import com.stg.entity.User;
import com.stg.exception.UserException;
import com.stg.service.AddressServiceInterface;
import com.stg.service.CarServiceInterface;
import com.stg.service.UserServiceInterface;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping(value = "Advertisement")
public class AdvertisementController {

	@Autowired
	private AddressServiceInterface addressServiceInterface;
	@Autowired
	private CarServiceInterface carServiceInterface;

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserServiceInterface serviceInterface;

	@PostMapping(value = "create/Advertisement")
//	public ResponseEntity<CarDto2> createCar(@RequestParam int userId, @RequestParam String carNumber,
//			@RequestParam String carName, @RequestParam com.stg.entity.FuelType fuelType,
//			@RequestParam OwnerType ownerType, @RequestParam int yearOfManufacture, @RequestParam String carModelName,
//			@RequestParam GearTransmission gearTransmission, @RequestParam int kmDriven, @RequestParam int price,
//			String description ,@RequestParam Premium premium, @RequestParam StateOfRegistration registration) throws UserException {
	public ResponseEntity<CarDto2> createCar(@RequestBody CarDto3 car) throws UserException {
		User user = serviceInterface.readByEmail(car.getEmail());
		Car car2 = new Car(car.getPrice(), car.getCarNumber(), car.getCarName(), car.getFuelType(), car.getOwnerType(),
				car.getYearOfManufacture(), car.getCarModelName(), car.getGearTransmission(), car.getKmDriven(),
				car.getPrice(), car.getDescription(), car.getPremium(), car.getRegistration());
		Car car1 = carServiceInterface.createCar(car2, user.getUserId());

		CarDto2 dto = mapper.map(car, CarDto2.class);
		dto.setAddId(car1.getAdvertisement().getAdId());
		dto.setUserId(user.getUserId());

		// int adId=carServiceInterface.advertisementId(carNumber);

		// dto.setAdId(adId);

		return new ResponseEntity<CarDto2>(dto, HttpStatus.OK);

	}

	@GetMapping(value = "AdvertisementIdByCarId")
	public Advertisement advertisementIdBycarId(@RequestParam int carId) {
		return carServiceInterface.advertisementIdBycarId(carId);

	}

	@GetMapping(value = "AdvertisementIdByCarNumber")
	public Advertisement advertisementIdByCarNumber(@RequestParam String carNumber) {
		return carServiceInterface.advertisementIdByCarNumber(carNumber);

	}

	@GetMapping(value = "readAllCar")
	public List<CarBooking> readAllCar() {
		List<CarBooking> cars = carServiceInterface.readAllCar();
//		Type listType = new TypeToken<List<CarDto1>>() {
//		}.getType();
//		List<CarDto1> carDto1s = mapper.map(cars, listType);

		return cars;

	}

	@GetMapping(value = "readByCarNumber/{carNumber}")
	public CarBooking readByCarNumber(@PathVariable String carNumber) throws UserException {
		CarBooking car = carServiceInterface.readByCarNumber(carNumber);
//		CarDto1 dto = mapper.map(car, CarDto1.class);
		return car;
	}
	@GetMapping(value = "readByCarId/{carId}")
	public CarDto1 readByCarId(@PathVariable int carId) throws UserException {
		Car car = carServiceInterface.readByCarId(carId);
		CarDto1 dto = mapper.map(car, CarDto1.class);
		return dto;
	}

	// @GetMapping(value = "readByCarName")
	public List<CarDto1> readByCarName(@RequestParam String carName) throws UserException {

		List<CarDto1> cars = carServiceInterface.readByCarName(carName);
		Type listType = new TypeToken<List<CarDto1>>() {
		}.getType();
		List<CarDto1> carDto1s = mapper.map(cars, listType);

		return carDto1s;

//		Car car=carServiceInterface.readByCarName(carName);
//		CarDto1 dto=mapper.map(car, CarDto1.class);
//		return dto;
		// return carServiceInterface.readByCarName(carName);
	}

	@GetMapping(value = "readByYear")
	public List<CarDto1> readByYear(@RequestParam int year) throws UserException {
		return carServiceInterface.readByYear(year);
	}

	@PutMapping(value = "upadateCarStatus")
	public ResponseEntity<CarDto1> upadateCarStatus(@RequestParam int id, @RequestParam String carNumber,
			@RequestParam CarStatus carStatus) throws UserException {
		Car car = carServiceInterface.upadateCarStatus(id, carNumber, carStatus);
		CarDto1 dto = mapper.map(car, CarDto1.class);
		return new ResponseEntity<CarDto1>(dto, HttpStatus.OK);
	}

	@PutMapping(value = "upadateCarName")
	public ResponseEntity<CarDto1> updateCarName(@RequestParam int id, @RequestParam String carNumber,
			@RequestParam String changeName) throws UserException {
		Car car = carServiceInterface.updateCarName(id, carNumber, changeName);
		CarDto1 dto = mapper.map(car, CarDto1.class);
		return new ResponseEntity<CarDto1>(dto, HttpStatus.OK);

	}

	@PutMapping(value = "upadateYearOfManufacture")
	public ResponseEntity<CarDto1> updateYearOfManufacture(@RequestParam int id, @RequestParam String carNumber,
			@RequestParam int year) throws UserException {
		Car car = carServiceInterface.upadateYearOfManufacture(id, carNumber, year);
		CarDto1 dto = mapper.map(car, CarDto1.class);
		return new ResponseEntity<CarDto1>(dto, HttpStatus.OK);

	}

	@PutMapping(value = "upadateCarModel")
	public ResponseEntity<CarDto1> upadateCarModel(@RequestParam int id, @RequestParam String carNumber,
			@RequestParam String carModel) throws UserException {
		Car car = carServiceInterface.upadateCarModel(id, carNumber, carModel);
		CarDto1 dto = mapper.map(car, CarDto1.class);
		return new ResponseEntity<CarDto1>(dto, HttpStatus.OK);

	}

	@PutMapping(value = "upadateOwner")
	public ResponseEntity<CarDto1> updateOwnerType(@RequestParam int id, @RequestParam String carNumber,
			@RequestParam OwnerType ownerType) throws UserException {
		Car car = carServiceInterface.updateOwnerType(id, carNumber, ownerType);
		CarDto1 dto = mapper.map(car, CarDto1.class);
		return new ResponseEntity<CarDto1>(dto, HttpStatus.OK);

	}

	@PutMapping(value = "upadateDescription")
	public ResponseEntity<CarDto1> updateDescription(@RequestParam int id, @RequestParam String carNumber,
			@RequestParam String description) throws UserException {
		Car car = carServiceInterface.updateDescription(id, carNumber, description);
		CarDto1 dto = mapper.map(car, CarDto1.class);
		return new ResponseEntity<CarDto1>(dto, HttpStatus.OK);

	}

	@PostMapping(value = "createAddress")
	public ResponseEntity<Address> createAddress(@RequestBody AddressDto addDto) throws UserException {

		return new ResponseEntity<Address>(addressServiceInterface.createAddress(addDto), HttpStatus.OK);

	}

	@GetMapping(value = "readAllAddress")
	public List<Address> readAllAddress() {

		return addressServiceInterface.readAllAddress();

	}

	@GetMapping(value = "readByCity")
	public List<Address> readByCity(@RequestParam String city) throws UserException {
		return addressServiceInterface.readByCity(city);
	}

	@GetMapping(value = "readByState")
	public List<Address> readByState(@RequestParam String state) throws UserException {
		return addressServiceInterface.readByState(state);
	}

	@PutMapping(value = "updateDoorNumber")
	public ResponseEntity<Address> updateDoorNumber(@RequestParam int id, @RequestParam int doorNo)
			throws UserException {
		return new ResponseEntity<Address>(addressServiceInterface.updateDoorNumber(id, doorNo), HttpStatus.OK);

	}

	@PutMapping(value = "updateStreetName")
	public ResponseEntity<Address> updateStreetName(@RequestParam int id, @RequestParam String streetName)
			throws UserException {
		return new ResponseEntity<Address>(addressServiceInterface.updateStreetName(id, streetName), HttpStatus.OK);

	}

	@PutMapping(value = "updateCity")
	public ResponseEntity<Address> updateCity(@RequestParam int id, @RequestParam String city) throws UserException {
		return new ResponseEntity<Address>(addressServiceInterface.updateCity(id, city), HttpStatus.OK);

	}

	@PutMapping(value = "updateState")
	public ResponseEntity<Address> updateState(@RequestParam int id, @RequestParam String state) throws UserException {
		return new ResponseEntity<Address>(addressServiceInterface.updateState(id, state), HttpStatus.OK);

	}

}
