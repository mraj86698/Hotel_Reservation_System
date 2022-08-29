package com.java.maven.Hotel_Reservation_System;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
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
	public boolean addHotel(String hotelName, int weekdayRegularRate,int weekendRegularRate,int rating) {

		Hotel hotel = new Hotel(hotelName,  weekdayRegularRate,weekendRegularRate,rating);
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
        /**
         * it returns the day of the month which is in range 1-31.
         */
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
	/**
	 * Find CheapestBest Rating Hotel based on WeekEndRegularRate
	 * @param startDateRange
	 * @param endDateRange
	 */
	public void findBestRatingForRegular(String startDateRange, String endDateRange) {
//		/**
//		 * LocalDate class is used to parse the start and end date ranges with DateTimeFormater class to pass date format
//		 */
//        LocalDate startDate = LocalDate.parse(startDateRange, DateTimeFormatter.ofPattern("d-MMM-yyyy"));
//        LocalDate endDate = LocalDate.parse(endDateRange, DateTimeFormatter.ofPattern("d-MMM-yyyy"));
//
//        int numberOfDays = endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1;
//        /**
//         * Stream function on arrlist
//         * hotelList and storing in cheapestHotel
//         */
//
//        Optional<Hotel> cheapestHotel = this.hotelList.stream().sorted(Comparator.comparing(Hotel::getWeekendRegularRate)).findFirst();
//
//        Hotel hotel = new Hotel();                                                                                  //Hotel Object
//        hotel.setHotelName(cheapestHotel.get().getHotelName());
//        hotel.setTotal(cheapestHotel.get().getWeekendRegularRate() * numberOfDays);
//        hotel.setRating(cheapestHotel.get().getRating());
//        /**
//         * Printing Hotel name and total Hotel rate for the date range
//         */
//        System.out.println("HotelName :" + hotel.getHotelName());
//        System.out.println("Days Stayed:"+numberOfDays);
//        /**
//         * To calculate Number of days stayed + the weekEndRegularRate for eg-(5*110)
//         */
//        System.out.println("TotalBill :" + hotel.getTotal() + "$");
//        System.out.println("Rating :" + hotel.getRating());

		Date startDate=null;
        Date endDate = null;
        try {
			startDate = new SimpleDateFormat("dd-MMM-yyyy").parse(startDateRange);
			endDate = new SimpleDateFormat("dd-MMM-yyyy").parse(endDateRange);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

        long numberOfDays = 1+(endDate.getTime()- startDate.getTime())/1000/60/60/24;
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        long noOfWeekdays = 0;
        if (startCal.getTimeInMillis() < endCal.getTimeInMillis()) {

        do {
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                ++noOfWeekdays;
            }
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

        long noOfWeekends = numberOfDays - noOfWeekdays;


        /**
         * Stream function on arrlist
         * hotelList and storing in cheapestHotel
         */

        Optional<Hotel> BestHotel = this.hotelList.stream().max(Comparator.comparing(Hotel::getRating));

        Hotel hotel = new Hotel();                                                                                  //Hotel Object
        hotel.setHotelName(BestHotel.get().getHotelName());
        hotel.setTotal(BestHotel.get().getWeekdayRegularRate()* noOfWeekdays+hotel.getWeekendRegularRate()*noOfWeekends);
        hotel.setRating(BestHotel.get().getRating());




        /**
         * Printing Hotel name and total Hotel rate for the date range
         */
        System.out.println("HotelName :" + hotel.getHotelName());
        System.out.println("Days Stayed:"+numberOfDays);
        /**
         * To calculate Number of days stayed + the weekly rate for eg-(5*110)
         */
        System.out.println("TotalBill :" + hotel.getTotal() + "$");
        System.out.println("Rating :" + hotel.getRating());
        }

    }
	/**
	 * Find Cheapest Rated Hotel
	 * @param startDateRange
	 * @param endDateRange
	 */
	public void findCheapestHotelRatingForRegular(String startDateRange, String endDateRange) {


		Date startDate=null;
        Date endDate = null;
        try {
			startDate = new SimpleDateFormat("dd-MMM-yyyy").parse(startDateRange);
			endDate = new SimpleDateFormat("dd-MMM-yyyy").parse(endDateRange);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

        long numberOfDays = 1+(endDate.getTime()- startDate.getTime())/1000/60/60/24;
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        long noOfWeekdays = 0;
        if (startCal.getTimeInMillis() < endCal.getTimeInMillis()) {

        do {
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                ++noOfWeekdays;
            }
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

        long noOfWeekends = numberOfDays - noOfWeekdays;


        /**
         * Stream function on arrlist
         * hotelList and storing in cheapestHotel
         */

        Optional<Hotel> cheapestHotel = this.hotelList.stream().min(Comparator.comparing(Hotel::getTotal).thenComparing(Hotel::getRating));

        Hotel hotel = new Hotel();                                                                                  //Hotel Object
        hotel.setHotelName(cheapestHotel.get().getHotelName());
        hotel.setTotal(cheapestHotel.get().getWeekdayRegularRate()* noOfWeekdays+hotel.getWeekendRegularRate()*noOfWeekends);
        hotel.setRating(cheapestHotel.get().getRating());
        /**
         * Printing Hotel name and total Hotel rate for the date range
         */
        System.out.println("HotelName :" + hotel.getHotelName());
        System.out.println("Days Stayed:"+numberOfDays);
        /**
         * To calculate Number of days stayed + the weeklyRate for eg-(5*110)
         */
        System.out.println("TotalBill :" + hotel.getTotal() + "$");
        System.out.println("Rating :" + hotel.getRating());

    }
	}
}
