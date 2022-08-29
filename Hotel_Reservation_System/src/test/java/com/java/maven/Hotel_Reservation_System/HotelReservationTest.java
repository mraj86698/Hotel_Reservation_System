package com.java.maven.Hotel_Reservation_System;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {

	private HotelReservation hotelReservation;


	@Before
	public void init() {
		hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110,90,80,80,3);
		hotelReservation.addHotel("Bridgewood", 160,50,110,50,4);
		hotelReservation.addHotel("Ridgewood", 220,150,100,40,5);
		Hotel hotel=new Hotel();
	}

	//Testing for creation of 3 hotels
	@Test
	public void whenLakewoodAdded_ShouldReturnTrue()
	{
		assertTrue(hotelReservation.addHotel("Lakewood", 110,90,80,80,3));
	}

	@Test
	public void whenBridgewoodAdded_ShouldReturnTrue()
	{
		assertTrue(hotelReservation.addHotel("Bridgewood", 160,50,110,50,4));
	}

	@Test
	public void whenRidgewoodAdded_ShouldReturnTrue()
	{
		assertTrue(hotelReservation.addHotel("Ridgewood", 220,150,100,40,5));
	}

	//Testing for correct output for staying 1 day
	@Test
	public void FindCheapestHotel()
	{
		 hotelReservation.findCheapestHotelOne("12.05.2020", "13.05.2020");
		//assertEquals(110, getTotal());
	}

	@Test
	public void findCheapestHotelForWeekEnd()
	{
		hotelReservation.findCheapestHotelTwo("12.05.2020", "13.05.2020");
		//assertEquals("Lakewood", cust.getHotelName());
	}

	@Test
	public void findCheapestHotelRatingForRegular()
	{
		hotelReservation.findCheapestHotelRatingForRegular("12.09.2020", "13.09.2020");
		//assertEquals("Bridgewood", cust.getHotelName());
	}

	@Test
	public void findBestRatingForRegular()
	{
		hotelReservation.findBestRatingForRegular("12.09.2020", "13.09.2020");
	//	assertEquals(50, getBill());
	}

	@Test
	public void findCheapestHotelRatingForReward()
	{
		hotelReservation.addHotel("DummyHotel", 110,90,80,80,5);
		hotelReservation.findCheapestHotelRatingForReward("12.05.2020", "13.05.2020");
		//assertEquals("DummyHotel", cust.getHotelName());
	}


}