package com.java.maven.Hotel_Reservation_System;

import java.util.Scanner;

public class HotelReservationMain {
	/**
	 * Global Scanner
	 */
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/**
		 * Default Entries
		 */
		HotelReservation obj = new HotelReservation();
		obj.addHotel("Lakewood", 110);
		obj.addHotel("Bridgewood", 160);
		obj.addHotel("Ridgewood", 220);
		while(true) {

			 System.out.println( "\nWelcome to Hotel Reservation Program" );

		        System.out.println();
		        System.out.println("------------------------------------------------------");
		        System.out.println();

		        System.out.println("What do you want to do?");
		        System.out.println("1. Add Hotel Entry.");
		        System.out.println("2. Display Hotel Entry");
		        String user_input=sc.next();


		        switch(user_input) {

		        case "1": {
		        	System.out.println("Please add hotel.");
		            System.out.println();
		            System.out.print("Enter hotel name: ");
		            String hotelName = sc.next();
		            System.out.print("Enter regular rate of rooms: ");
		            int rate_regular = sc.nextInt();

		            obj.addHotel(hotelName, rate_regular);
		            break;
		        }
		        case "2":{
		        	obj.showHotelInfo();
		        	break;
		        }

		        default:
		        	System.out.println("Unknown input.");
		        }
		    }
		}
}
