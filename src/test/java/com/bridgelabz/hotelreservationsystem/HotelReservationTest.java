package com.bridgelabz.hotelreservationsystem;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class HotelReservationTest {

    /*
     *Test case to check hotel added in list
     */
    @Test
    public void givenHotelDetails_WhenValuesEnteredAreCorrect_ThenListSizeshouldBeThree(){
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("lakewood", 3, 110, 90);
        hotelReservation.addHotel("bridgewood", 4, 160, 50);
        hotelReservation.addHotel("ridgewood", 5, 220, 150);
        Assert.assertEquals(hotelReservation.hotelList.size(), 3);
    }

    /*
    * Test case to check cheapest hotel
     */
    @Test
    public void givenHotelDetails_shouldReturnCheapestHotel(){
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90);
        hotelReservation.addHotel("Bridgewood", 4, 160, 50);
        hotelReservation.addHotel("ridgewood", 5, 220, 150);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        ArrayList<Hotel> hotel = hotelReservation.getCheapestHotel(startDate, endDate);
        String hotelName = hotel.get(0).getHotelName();
        Assert.assertEquals("Bridgewood", hotelName);
    }

    /*
     *Test case to check cheapest and best rated hotel
     */
    @Test
    public void givenHotelDetails_WhenHotelPricesAreSame_shouldReturnHighestRatedHotel(){
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        Hotel hotel = hotelReservation.getCheapestBestRatedHotel(startDate, endDate);
        Assert.assertEquals("Bridgewood", hotel.getHotelName());
    }
}
