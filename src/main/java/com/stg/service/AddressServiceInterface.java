package com.stg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stg.dto.AddressDto;
import com.stg.entity.Address;

import com.stg.exception.UserException;

@Service
public interface AddressServiceInterface {
	
	
	public Address createAddress(AddressDto address)throws UserException ;
	
	public List<Address> readAllAddress();

	public List<Address> readByCity(String city)throws UserException;
	
	public  List<Address> readByState(String state)throws UserException;
	
	public Address updateDoorNumber(int id,int doorNumber)throws UserException;
	
	public Address updateStreetName(int id,String streetName)throws UserException;
	
	public Address updateCity(int id,String city)throws UserException;
	
	public Address updateState(int id,String state)throws UserException;
	
	
	

}
