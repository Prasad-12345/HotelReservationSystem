package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
 *Author: Prasad
 *Ability to add Hotel in a Hotel Reservation System with Name and rates for Regular Customer
 */
public class HotelReservation {
    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    Hotel hotel;

    public void addHotel(String hotelName, int rating, double regularCustomerRate) {
        hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setRating(rating);
        hotel.setRegularCustomerRates(regularCustomerRate);

        hotelList.add(hotel);
        System.out.println("Successfully ADDED !!");
    }
}
