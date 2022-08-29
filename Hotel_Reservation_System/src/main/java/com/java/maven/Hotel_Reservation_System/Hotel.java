package com.java.maven.Hotel_Reservation_System;

public class Hotel {
	String hotelName;
	int weekdayRegularRate;
    int weekendRegularRate;

	int Total;

	public Hotel(String hotelName, int weekdayRegularRate, int weekendRegularRate) {
        this.hotelName = hotelName;
        this.weekdayRegularRate = weekdayRegularRate;
        this.weekendRegularRate = weekendRegularRate;
    }
	public Hotel() {

	}
	/**
	 * It Returns the value into String Format
	 */
	@Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", weekdayRegularRate=" + weekdayRegularRate +
                ", weekendRegularRate=" + weekendRegularRate +
                '}';
    }
	public void display() {

		System.out.println("------------------------------------------------------");
		System.out.println("Hotel Name: "+hotelName);
		System.out.println("Regular Weekday Rate: "+weekdayRegularRate);
		System.out.println("Regular Weekend Rate: "+weekendRegularRate);
		System.out.println("------------------------------------------------------");
		System.out.println();
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public int getWeekdayRegularRate() {
		return weekdayRegularRate;
	}
	public void setWeekdayRegularRate(int weekdayRegularRate) {
		this.weekdayRegularRate = weekdayRegularRate;
	}
	public int getWeekendRegularRate() {
		return weekendRegularRate;
	}
	public void setWeekendRegularRate(int weekendRegularRate) {
		this.weekendRegularRate = weekendRegularRate;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}


}
