package com.java.maven.Hotel_Reservation_System;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {
	/**
	 * Global Scanner
	 */
	static Scanner sc = new Scanner(System.in);
	ArrayList<Hotel> hotelList = new ArrayList();
	/**
	 * The element passed as a parameter gets inserted at the end of the list.
	 * @param hotelName
	 * @param rate_regular
	 * @return a boolean value true
	 */
	public boolean addHotel(String hotelName, int rate_regular) {

		Hotel hotel = new Hotel(hotelName, rate_regular);
		hotelList.add(hotel);
		return true;
	}
	/**
	 * Displaying Hotel List
	 */

	public void showHotelInfo() {
		for (Hotel hotel : hotelList) {
			hotel.display();
		}

	}
}
