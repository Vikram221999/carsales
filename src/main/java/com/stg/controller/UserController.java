package com.stg.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.dto.AddressDto1;
import com.stg.dto.CarDto1;
import com.stg.dto.CarDto3;
import com.stg.dto.UserDto;
import com.stg.dto.UserDto1;
import com.stg.dto.UserLogin;
import com.stg.dto.UserSign;
import com.stg.entity.Address;
import com.stg.entity.Car;
import com.stg.entity.User;
import com.stg.exception.UserException;
import com.stg.service.AddressServiceInterface;
import com.stg.service.AdminServiceInterface;
import com.stg.service.LoginServiceInterface;
import com.stg.service.SignServiceInterface;
import com.stg.service.UserServiceInterface;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserServiceInterface serviceInterface;
	
	@Autowired
	private SignServiceInterface signServiceInterface;

	@Autowired
	private AddressServiceInterface addressService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AdminServiceInterface adminService;
	
	@Autowired
	private LoginServiceInterface loginService;
		
	
	@GetMapping(value = "userLogin/{email}")
	public ResponseEntity<UserDto1> userLogin(@PathVariable String email){
//		System.out.println(login.getEmail());
//		System.out.println(login.getUserPassword()+"////////////////");
		User dto1= loginService.userLogin(email);
		UserDto1 dto=mapper.map(dto1, UserDto1.class);
		return new ResponseEntity<UserDto1>(dto,HttpStatus.OK);
	}
	@PostMapping(value = "createUser")
	public ResponseEntity<String> UserSign(@RequestBody UserSign sign) throws UserException {

		User user = new User(sign.getUserName(), sign.getUserPassword(), sign.getMobileNumber(), sign.getEmail());

		return new ResponseEntity<String>(signServiceInterface.createUserSign(user), HttpStatus.OK);
	}
	
	@GetMapping(value = "showAllUser")
	public List<UserDto> showAllUser(){
		List<User> user = serviceInterface.showUser();
		Type listType = new TypeToken<List<UserDto>>() {
	}.getType();
		List<UserDto> user1 = mapper.map(user, listType);
		
		return user1;
	}
	
	
	@GetMapping(value = "readById/{email}")
	public UserDto readById(@PathVariable int id) throws UserException {
		User user=serviceInterface.readById(id);
		UserDto dto=mapper.map(user, UserDto.class);
		return dto;
	}
	@GetMapping(value = "address/readById/{userId}")
	public AddressDto1 addressReadById(@PathVariable int userId) throws UserException {
		Address address=serviceInterface.addressReadById(userId);
		AddressDto1 dto=mapper.map(address, AddressDto1.class);
		return dto;
	}
	
	@GetMapping(value = "car/readById/{userId}")
	public List<CarDto3>  carReadById(@PathVariable int userId) throws UserException {
		 List<Car> car=serviceInterface.carReadById(userId);
		 Type listType = new TypeToken<List<CarDto3>>() {
			}.getType();
				List<CarDto3> cars = mapper.map(car, listType);
				
		 
		 
		return cars;
	}
	
	@GetMapping(value = "readByName")
	public List<User> readByName(@RequestParam String UserName) throws UserException {
		return serviceInterface.readByName(UserName);
	}
	
	@GetMapping(value = "readByEmailId")
	public UserDto readByEmailId(@RequestParam String email) throws UserException {
		User user=serviceInterface.readByEmail(email);
		UserDto dto=mapper.map(user, UserDto.class);
		return dto;
		
	}
	@PutMapping(value = "updateUserName")
	public ResponseEntity<UserDto> updateUserName(@RequestParam String email,@RequestParam String name) throws UserException {
		User user=serviceInterface.updateName(email, name);
		UserDto dto=mapper.map(user, UserDto.class);
		return new ResponseEntity<UserDto>(dto, HttpStatus.OK);

	}
	@PutMapping(value = "updateMobileNumber")
	public ResponseEntity<UserDto> updateMobileNumber(@RequestParam String email,@RequestParam long mobilNumber) throws UserException {
		User user=serviceInterface.updateMobileNumber(email, mobilNumber);
		UserDto dto=mapper.map(user, UserDto.class);
		return new ResponseEntity<UserDto>(dto, HttpStatus.OK);
		

	}
	
	@PutMapping(value = "updatePassword")
	public ResponseEntity<User> updatePassword(@RequestParam String email,@RequestParam String password) throws UserException {
		return new ResponseEntity<User>(serviceInterface.updatePassword(email, password), HttpStatus.OK);

	}
	
	@PutMapping(value = "updateEmail")
	public ResponseEntity<UserDto> updateEmail(@RequestParam String email,@RequestParam String newEmail) throws UserException {
	
		User user=serviceInterface.updateEmail(email, email);
		UserDto dto=mapper.map(user, UserDto.class);
		return new ResponseEntity<UserDto>(dto, HttpStatus.OK);

	}


	@DeleteMapping(value = "deactiveAccount")
	public ResponseEntity<String> deleteUser(@RequestParam int id){
		return new ResponseEntity<String>(adminService.deleteUser(id),HttpStatus.OK);
	}

}
