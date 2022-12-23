package com.stg.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.dto.AddressDto;
import com.stg.entity.Address;
import com.stg.entity.User;
import com.stg.exception.UserException;
import com.stg.repository.AddressRepo;
import com.stg.repository.UserRepo;
import com.stg.service.AddressServiceInterface;
import com.stg.service.UserServiceInterface;

@Service
public class AddressSaerviceImpl implements AddressServiceInterface {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserServiceInterface serviceInterface;

	@Override
	public Address createAddress(AddressDto addDto) throws UserException {

	
		if (!userRepo.existsById(addDto.getUserId())) {
			throw new UserException("User Already has Address");
		} else {
			User user = serviceInterface.readById(addDto.getUserId());
			Address address = new Address(addDto.getDoorNo(), addDto.getStreetName(), addDto.getCity(),
					addDto.getState(), addDto.getPincode(), user);

			return addressRepo.save(address);
		}
	}

	@Override
	public List<Address> readAllAddress() {

		return addressRepo.findAll();
	}

	@Override
	public List<Address> readByCity(String city) throws UserException {
		if (addressRepo.existsByCity(city)) {
			List<Address> list = addressRepo.findByCity(city);
			return list;
		} else {
			throw new UserException("Oops..!  There is no city you are serched by");
		}
	}

	@Override
	public List<Address> readByState(String state) throws UserException {
		if (addressRepo.existsByState(state)) {
			List<Address> list = addressRepo.findByState(state);
			return list;
		} else {
			throw new UserException("Oops..!  There is no State you are serched by");
		}
	}

	@Override
	public Address updateDoorNumber(int id, int doorNumber) throws UserException {
		if (userRepo.existsById(id)) {
			User user = userRepo.findById(id).get();
			user.getAddress().setDoorNo(doorNumber);
			userRepo.save(user);
			return user.getAddress();
		} else {
			throw new UserException("Incorect User Id");
		}
	}

	@Override
	public Address updateStreetName(int id, String streetName) throws UserException {
		if (userRepo.existsById(id)) {
			User user = userRepo.findById(id).get();
			user.getAddress().setStreetName(streetName);
			userRepo.save(user);
			return user.getAddress();
		} else {
			throw new UserException("Incorect User Id");
		}
	}

	@Override
	public Address updateCity(int id, String city) throws UserException {
		if (userRepo.existsById(id)) {
			User user = userRepo.findById(id).get();
			user.getAddress().setCity(city);
			userRepo.save(user);
			return (user.getAddress());
		} else {
			throw new UserException("Incorect User Id");
		}
	}

	@Override
	public Address updateState(int id, String state) throws UserException {
		if (userRepo.existsById(id)) {
			User user = userRepo.findById(id).get();
			user.getAddress().setState(state);
			userRepo.save(user);
			return user.getAddress();
		} else {
			throw new UserException("Incorect User Id");
		}
	}

}
