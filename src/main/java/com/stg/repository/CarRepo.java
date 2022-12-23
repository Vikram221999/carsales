package com.stg.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stg.entity.Car;
import com.stg.entity.Premium;


public interface CarRepo extends JpaRepository<Car, Integer> {
	
	@Query(value = "SELECT * FROM carsalesandbuy.car order by premium desc", nativeQuery = true)
	List<Car> findAllCar();

	boolean existsByCarNumber(String carNumber);

	public Car findByCarNumber(String carNumber);


	public List<Car> findByCarName(String carName);

	public List<Car> findByYearOfManufacture(int year);


	public boolean existsByYearOfManufacture(int year);

	public boolean existsByCarName(String carName);


	

}
