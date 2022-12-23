package com.stg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarAddress {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carAddressId ;
	
	
	private String area;
	
	private String city;
	
	private String State;
	
	@OneToOne
	@JsonBackReference
	@JoinColumn
	private Car car;

	public CarAddress(String carNumber, String area, String city, String state, Car car) {
		super();
		this.area = area;
		this.city = city;
		State = state;
		this.car = car;
	}

	

	
	

	
	
	
	
}
