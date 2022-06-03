package com.bridgelabz.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 *Author: Prasad
 *Ability to find the cheapest best rated hotel Hotel for a given Date Range
 */
public class HotelReservation {
    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    Hotel hotel;
    public static double cheapestPrice;

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
    public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate){
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

        cheapestPrice = hotelList.stream()
                .mapToDouble(hotel -> ((hotel.getWeekendRegularRates()*weekendsNumber) + hotel.getWeekdayRegularRates()*weekdaysNumber))
                .min()
                .orElse(Double.MAX_VALUE);

        ArrayList<Hotel> cheapestHotel = hotelList.stream()
                .filter(hotel -> (hotel.getWeekendRegularRates()*weekendsNumber + hotel.getWeekdayRegularRates()*weekdaysNumber) == cheapestPrice)
                .collect(Collectors.toCollection(ArrayList::new));

        if (cheapestPrice != Double.MAX_VALUE) {
            Iterator<Hotel> iterator = cheapestHotel.iterator();
            while(iterator.hasNext()) {
                System.out.println("Cheap Hotel : \n" + iterator.next().getHotelName() + ", Total Rates: " + cheapestPrice);
            }
            return cheapestHotel;
        }
        return null;
        }

     /*
      * Method to return cheapest and best rated hotel
      */
     public Hotel getCheapestBestRatedHotel(LocalDate startDate, LocalDate endDate){
        ArrayList<Hotel> cheapestHotels = getCheapestHotel(startDate, endDate);
        Optional<Hotel> sortedHotelList = cheapestHotels.stream().max(Comparator.comparing(Hotel::getRating));
        System.out.println("Cheapest Best Rated Hotel : \n" + sortedHotelList.get().getHotelName() + ", Total Rates: " + cheapestPrice);
        return sortedHotelList.get();
     }
    }

