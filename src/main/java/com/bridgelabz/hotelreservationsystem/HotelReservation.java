package com.bridgelabz.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

/*
 *Author: Prasad
 *Ability to find the cheapest Hotel for a given Date Range based on weekday and weekend
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
    public String getCheapestHotel(LocalDate startDate, LocalDate endDate){
        int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate);
        int weekends = 0;

        while (startDate.compareTo(endDate) != 0) {
            switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
                case SATURDAY:
                    ++weekends;
                    break;
                case SUNDAY:
                    ++weekends;
                    break;
            }
            startDate = startDate.plusDays(1);
        }

        final int weekdaysNumber = numberOfDays - weekends;
        final int weekendsNumber = weekends;

        final double cheapestPrice = hotelList.stream()
                .mapToDouble(hotel -> ((hotel.getWeekendRegularRates()*weekendsNumber) + hotel.getWeekdayRegularRates()*weekdaysNumber))
                .min()
                .orElse(Double.MAX_VALUE);

        ArrayList<Hotel> cheapestHotel = hotelList.stream()
                .filter(hotel -> (hotel.getWeekendRegularRates()*weekendsNumber + hotel.getWeekdayRegularRates()*weekdaysNumber) == cheapestPrice)
                .collect(Collectors.toCollection(ArrayList::new));

        if (cheapestPrice != Double.MAX_VALUE) {
            System.out.println("Cheapest Hotel : \n" + cheapestHotel.get(0).getHotelName() + ", Total Rates: " + cheapestPrice);
            return cheapestHotel.get(0).getHotelName();
        }
        return null;
        }
    }

