package com.java.maven.Hotel_Reservation_System;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
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
	public boolean addHotel(String hotelName, int weekdayRegularRate,int weekendRegularRate) {

		Hotel hotel = new Hotel(hotelName,  weekdayRegularRate,weekendRegularRate);
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

	/**
	 * Find CheapestHotel based on RegularRate
	 * @param startDateRange
	 * @param endDateRange
	 */
	public void findCheapestHotelOne(String startDateRange, String endDateRange) {
		/**
		 * LocalDate class is used to parse the start and end date ranges with DateTimeFormater class to pass date format
		 */
        LocalDate startDate = LocalDate.parse(startDateRange, DateTimeFormatter.ofPattern("d-MMM-yyyy"));
        LocalDate endDate = LocalDate.parse(endDateRange, DateTimeFormatter.ofPattern("d-MMM-yyyy"));

        int numberOfDays = endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1;
        /**
         * Stream function on arrlist
         * hotelList and storing in cheapestHotel
         */

        Optional<Hotel> cheapestHotel = this.hotelList.stream().sorted(Comparator.comparing(Hotel::getWeekdayRegularRate)).findFirst();

        Hotel hotel = new Hotel();                                                                                  //Hotel Object
        hotel.setHotelName(cheapestHotel.get().getHotelName());
        hotel.setTotal(cheapestHotel.get().getWeekdayRegularRate() * numberOfDays);
        /**
         * Printing Hotel name and total Hotel rate for the date range
         */
        System.out.println("HotelName :" + hotel.getHotelName());
        System.out.println("Days Stayed:"+numberOfDays);
        /**
         * To calculate Number of days stayed + the weekdayRegularRate for eg-(5*110)
         */
        System.out.println("TotalBill :" + hotel.getTotal() + "$");

    }

	/**
	 * Find CheapestHotel based on WeekEndRegularRate
	 * @param startDateRange
	 * @param endDateRange
	 */
	public void findCheapestHotelTwo(String startDateRange, String endDateRange) {
		/**
		 * LocalDate class is used to parse the start and end date ranges with DateTimeFormater class to pass date format
		 */
        LocalDate startDate = LocalDate.parse(startDateRange, DateTimeFormatter.ofPattern("d-MMM-yyyy"));
        LocalDate endDate = LocalDate.parse(endDateRange, DateTimeFormatter.ofPattern("d-MMM-yyyy"));

        int numberOfDays = endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1;
        /**
         * Stream function on arrlist
         * hotelList and storing in cheapestHotel
         */

        Optional<Hotel> cheapestHotel = this.hotelList.stream().sorted(Comparator.comparing(Hotel::getWeekendRegularRate)).findFirst();

        Hotel hotel = new Hotel();                                                                                  //Hotel Object
        hotel.setHotelName(cheapestHotel.get().getHotelName());
        hotel.setTotal(cheapestHotel.get().getWeekendRegularRate() * numberOfDays);
        /**
         * Printing Hotel name and total Hotel rate for the date range
         */
        System.out.println("HotelName :" + hotel.getHotelName());
        System.out.println("Days Stayed:"+numberOfDays);
        /**
         * To calculate Number of days stayed + the weekdayRegularRate for eg-(5*110)
         */
        System.out.println("TotalBill :" + hotel.getTotal() + "$");

    }
}
