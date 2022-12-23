package com.stg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Address;
import com.stg.entity.User;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	List<Address> findByCity(String city);

	List<Address> findByState(String state);

	Address findByDoorNo(int doorNumber);

	public boolean existsByCity(String city);

	public boolean existsByState(String state);



	

}
