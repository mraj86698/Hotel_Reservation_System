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
		obj.addHotel("Lakewood", 110,90,80,80,3);
		obj.addHotel("Bridgewood", 150,50,110,50,4);
		obj.addHotel("Ridgewood", 220,150,100,40,5);
		while(true) {

			 System.out.println( "\nWelcome to Hotel Reservation Program" );

		        System.out.println();
		        System.out.println("------------------------------------------------------");
		        System.out.println();

		        System.out.println("What do you want to do?");
		        System.out.println("1. Add Hotel Entry.");
		        System.out.println("2. Display Hotel Entry");
		        System.out.println("3. Cheapest Hotel Based on WeekdayRegularRate");
		        System.out.println("4. Cheapest Hotel Based on WeekEndRegularRate");
		        System.out.println("5. Cheapest best Rated Hotel ");
		        System.out.println("6. Best Rated Hotel");
		        System.out.println("7. Cheapest Best Hotel Rating for Reward");


		        String user_input=sc.next();


		        switch(user_input) {

		        case "1": {
		        	System.out.println("Please add hotel.");
		            System.out.println();
		            System.out.print("Enter hotel name: ");
		            String hotelName = sc.next();
		            System.out.print("Enter WeekDay rate of rooms: ");
		            int weekdayRegularRate = sc.nextInt();
		            System.out.print("Enter Weekend rate of rooms: ");
		            int weekendRegularRate = sc.nextInt();
		            System.out.print("Enter WeekDay rate of rooms: ");
		            int weekdayReward = sc.nextInt();
		            System.out.print("Enter Weekend rate of rooms: ");
		            int weekendReward = sc.nextInt();
		            System.out.print("Enter Rating of Hotel: ");
		            int rating = sc.nextInt();

		            obj.addHotel(hotelName, weekdayRegularRate,weekendRegularRate,weekdayReward,weekendReward,rating);
		            break;
		        }
		        case "2":{
		        	obj.showHotelInfo();
		        	break;
		        }
		        case "3":{
		        	System.out.println(" ");
		            System.out.println("Cheapest Hotel Based on WeekdayRegularRate");
		            obj.findCheapestHotelOne("11-Sep-2020","12-Sep-2020");
		            System.out.println(" ");
		            break;
		        }
		        case "4":{
		        	System.out.println(" ");
		            System.out.println("Cheapest Hotel Based on WeekendRegularRate");
		            obj.findCheapestHotelTwo("11-Sep-2020","12-Sep-2020");
		            System.out.println(" ");
		            break;
		        }
		        case "5":{
		        	System.out.println(" ");
		            System.out.println("Cheapest best Rated Hotel");
		            obj.findCheapestHotelRatingForRegular("11-Sep-2020","12-Sep-2020");
		            System.out.println(" ");
		            break;
		        }
		        case "6":{
		        	System.out.println(" ");
		            System.out.println("Best Rated Hotel ");
		            obj.findBestRatingForRegular("11-Sep-2020","12-Sep-2020");
		            System.out.println(" ");
		            break;
		        }
		        case "7":{
		        	System.out.println(" ");
		            System.out.println("Cheapest best Hotel Rating For Regular");
		            obj.findCheapestHotelRatingForReward("11-Sep-2020","12-Sep-2020");
		            System.out.println(" ");
		            break;

		        }



		        default:
		        	System.out.println("Unknown input.");
		        }
		    }
		}
}
