package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	public boolean existsByAdminEmail(String adminEmail);
	

}
