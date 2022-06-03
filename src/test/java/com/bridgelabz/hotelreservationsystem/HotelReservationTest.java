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
}
