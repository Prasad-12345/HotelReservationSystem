package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
 *Author: Prasad
 *Ability to find the cheapest Hotel for a given Date Range - I/P – 10Sep2020, 11Sep2020 - O/P – Lakewood
 */
public class HotelReservation {
    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    Hotel hotel;

    //Method to add hotel
    public void addHotel(String hotelName, int rating, double regularCustomerRate) {
        hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setRating(rating);
        hotel.setRegularCustomerRates(regularCustomerRate);

        hotelList.add(hotel);
        System.out.println("Successfully ADDED !!");
    }

    //Method to return cheapest hotel
    public List<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate){
        return hotelList.stream().sorted((hotel1, hotel2) -> String.valueOf(hotel1.getRegularCustomerRates()).compareTo(String.valueOf(hotel2.getRegularCustomerRates()))).collect(Collectors.toList());
    }
}
