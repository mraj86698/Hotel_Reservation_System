package com.java.maven.Hotel_Reservation_System;

public class Hotel {
	String hotelName;
	int regularRate;

	public Hotel(String hotelName, int regularRate) {
		this.hotelName = hotelName;
		this.regularRate = regularRate;

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

}
