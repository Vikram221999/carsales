package com.stg.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class AddressDto1 {



	private int doorNo;

	private String streetName;

	private String city;

	private String state;

	private int pincode;

	public AddressDto1( int doorNo, String streetName, String city, String state, int pincode) {
		super();
	

		this.doorNo = doorNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

}
