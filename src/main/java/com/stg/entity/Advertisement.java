package com.stg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Advertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adId;
	
	
	//private int userId;
	
	
	//private int carId;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@JsonBackReference(value = "userAdvertisement")
	private User user;
	
	private int carId;
	
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
//	@JsonManagedReference
//	@Column(nullable = true)
//	private List<Car> cars;
	
//	@OneToOne   //(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//	@JsonBackReference //(value = "userAddress")
//	@JoinColumn(name = "carId")//(name = "userId",referencedColumnName = "userId"	)
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "advertisement")
//	@JsonManagedReference(value = "advertise")
//	@Column(nullable = true)
//	@JsonManagedReference
//	@OneToMany(mappedBy = "advertisement", fetch = FetchType.EAGER)
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "advertisement")
	@JsonManagedReference(value = "userCar")
	@Column(nullable = true)
	private List<Car>car;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "advertisement")
	@JsonManagedReference(value = "adBooking")
	@Column(nullable = true)
	private List<Bookings> booking;
	

}
