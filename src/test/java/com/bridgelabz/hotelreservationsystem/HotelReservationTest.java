package com.bridgelabz.hotelreservationsystem;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

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
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String hotelName = hotelReservation.getCheapestHotel(startDate, endDate);
        Assert.assertEquals("Lakewood", hotelName);
    }
}
