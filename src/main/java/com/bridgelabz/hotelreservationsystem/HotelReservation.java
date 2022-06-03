package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
 *Author: Prasad
 *Ability to add weekday and weekend rates for each Hotel
 */
public class HotelReservation {
    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    Hotel hotel;

    //Method to add hotel
    public void addHotel(String hotelName, int rating, double weekdayRegularRates, double weekendRegularRates) {
        hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setRating(rating);
        hotel.setWeekdayRegularRates(weekdayRegularRates);
        hotel.setWeekendRegularRates(weekendRegularRates);

        hotelList.add(hotel);
        System.out.println("Successfully ADDED !!");
    }

    //Method to return cheapest hotel
/*    public List<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate){
        return hotelList.stream().sorted((hotel1, hotel2) -> String.valueOf(hotel1.getRegularCustomerRates()).compareTo(String.valueOf(hotel2.getRegularCustomerRates()))).collect(Collectors.toList());
    }*/
}
