package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.Advertisement;
import com.stg.entity.User;
@Repository
public interface AdvertisementRepo extends JpaRepository<Advertisement, Integer> {

//	List<User> findByUserId(int id);



}
