package com.java.maven.Hotel_Reservation_System;

public class Hotel {
	String hotelName;
	int regularRate;
	int Total;

	public Hotel(String hotelName, int regularRate) {
		this.hotelName = hotelName;
		this.regularRate = regularRate;

	}
	public Hotel() {

	}
	/**
	 * It Returns the value into String Format
	 */
	@Override
	public String toString() {
		return "Hotel{" + "hotelName='" + hotelName + '\'' + ", regularRate=" + regularRate + '}';
	}
	public void display() {

		System.out.println("------------------------------------------------------");
		System.out.println("Hotel Name: "+hotelName);
		System.out.println("Regular Rate: "+regularRate);
		System.out.println("------------------------------------------------------");
		System.out.println();
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getRegularRate() {
		return regularRate;
	}
	public void setRegularRate(int regularRate) {
		this.regularRate = regularRate;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}


}
