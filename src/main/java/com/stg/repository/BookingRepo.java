package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stg.entity.Bookings;
import com.stg.entity.Car;
@Repository
public interface BookingRepo extends JpaRepository<Bookings, Integer> {
//	@Query(value = "SELECT * FROM carsalesandbuy.bookings order by premium desc", nativeQuery = true)
//	List<Bookings> findAllCar();

	//Bookings findbyUserId(int userId);

}
