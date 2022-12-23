package com.stg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	private int offerPrice;
	
//	public enum BookingStatus{
//		BUYYER,SELLER
//	}
//	@Enumerated(EnumType.ORDINAL)
//	private BookingStatus bookingStatus;
	
	public enum Choose{
		AVAILABLE,ACCEPT,REJECT
	}
	@Enumerated(EnumType.ORDINAL)
	private Choose choose;
	//private int adId;
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@JsonBackReference(value = "userBooking")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "adId")
	@JsonBackReference(value = "adBooking")
	private Advertisement advertisement;
	
	private int sellerId;
	
	private String sellerDetail;
	
	private int buyerId;
	private String buyerDetail;
	
	private int advertisementId;
	

}
