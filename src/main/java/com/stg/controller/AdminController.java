package com.stg.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.dto.CarDto1;
import com.stg.dto.UserDto;
import com.stg.entity.Address;
import com.stg.entity.Admin;
import com.stg.entity.Advertisement;
import com.stg.entity.Car;
import com.stg.entity.Premium;
import com.stg.entity.User;
import com.stg.exception.UserException;
import com.stg.service.AddressServiceInterface;
import com.stg.service.AdminServiceInterface;
import com.stg.service.CarServiceInterface;
import com.stg.service.LoginServiceInterface;
import com.stg.service.SignServiceInterface;
import com.stg.service.UserServiceInterface;


@RestController
@RequestMapping(value = "admin")
public class AdminController {
	
	
	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private CarServiceInterface carService;
	
	@Autowired
	private AddressServiceInterface addressService;
	@Autowired
	private SignServiceInterface signServiceInterface;

	@Autowired
	private LoginServiceInterface loginService;
	@Autowired
	private AdminServiceInterface adminService;
	@Autowired
	private ModelMapper mapper;
	@GetMapping(value = "adminLogin")
	public ResponseEntity<String> adminLogin(@RequestParam String emailId,@RequestParam String pasword){
		return new ResponseEntity<String>(loginService.adminLogin(emailId,pasword),HttpStatus.OK);
	}
	@PostMapping(value = "adminSign")
		public ResponseEntity<String> create(@RequestBody Admin sign) throws UserException {
			return new ResponseEntity<String>(signServiceInterface.createAdmin(sign), HttpStatus.OK);
		}

	@GetMapping(value = "ShowAllUser")
	public List<CarDto1> readAllCar() {
		List<CarDto1> cars = carService.readAllCar();
		

		return cars;
	}
	
	@GetMapping(value = "readByUserId")
	public User readById(@RequestParam int id) throws UserException {
		return userService.readById(id);
	}
	
	//@GetMapping(value = "readByName")
	public List<User> readByName(@RequestParam String UserName) throws UserException {
		return userService.readByName(UserName);
	}
	@GetMapping(value = "readByPremium")
	public List<CarDto1> readByPremium(@RequestParam Premium premium) throws UserException {
		List<CarDto1> list=adminService.readByPremium(premium);
		return list;
	}
	
	
	
	
	//@GetMapping(value = "readByCarName")
	public List<CarDto1> readByCarName(@RequestParam String carName) throws UserException {
		return carService.readByCarName(carName);
	}
	
	//@GetMapping(value = "readByYear")
	public List<CarDto1> readByYear(@RequestParam int year) throws UserException {
		return carService.readByYear(year);
	}
	
	//@GetMapping(value = "readAllAddress")
	public List<Address> readAllAddress() {

		return addressService.readAllAddress();

	}
	//@GetMapping(value = "readByCity")
	public List<Address> readByCity(@RequestParam String city) throws UserException {
		return addressService.readByCity(city);
	}
	
	//@GetMapping(value = "readByState")
	public  List<Address> readByState(@RequestParam String state) throws UserException {
		return addressService.readByState(state);
	}
	
	@DeleteMapping(value = "deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam int id){
		return new ResponseEntity<String>(adminService.deleteUser(id),HttpStatus.OK);
	}
	
 

}
