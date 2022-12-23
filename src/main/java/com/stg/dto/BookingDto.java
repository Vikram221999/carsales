package com.stg.dto;
public class BookingDto {
	
	private int userId;
	private int adId;
	private int offerPrice;

	@Override
	public String toString() {
		return "\"BookingDto [userId=" + this.userId + ", adId=" + this.adId + ", offerPrice=" + this.offerPrice + "]\"";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public int getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(int offerPrice) {
		this.offerPrice = offerPrice;
	}

	public BookingDto(int userId, int adId, int offerPrice) {
		super();
		this.userId = userId;
		this.adId = adId;
		this.offerPrice = offerPrice;
	}

	public BookingDto() {
		super();
	}
	
	
	
	
	
	
	
}
