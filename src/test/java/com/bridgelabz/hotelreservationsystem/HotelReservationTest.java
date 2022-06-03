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
        hotelReservation.addHotel("lakewood", 3, 110);
        hotelReservation.addHotel("bridgewood", 4, 160);
        hotelReservation.addHotel("ridgewood", 5, 220);
        Assert.assertEquals(hotelReservation.hotelList.size(), 3);
    }

    @Test
    public void givenHotelDetails_shouldReturnCheapestHotel(){
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("lakewood", 3, 110);
        hotelReservation.addHotel("bridgewood", 4, 160);
        hotelReservation.addHotel("ridgewood", 5, 220);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        hotelReservation.getCheapestHotel(startDate, endDate);
        Assert.assertEquals(hotelReservation.hotelList.get(0).getHotelName(), "lakewood");
    }
}
