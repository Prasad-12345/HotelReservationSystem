package com.bridgelabz.hotelreservationsystem;
/*
 *Author: Prasad
 */
public class Hotel {
    //variables
    String hotelName;
    double rating;
    double weekdayRegularRates;
    double weekendRegularRates;

    //constructor
    public Hotel(){

    }

    //parametrized constructor
    public Hotel(String hotelName, double rating, double weekdayRegularRates, double weekendRegularRates) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekdayRegularRates = weekdayRegularRates;
        this.weekendRegularRates = weekendRegularRates;
    }

    //getter and setter methods
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getWeekdayRegularRates() {
        return weekdayRegularRates;
    }

    public void setWeekdayRegularRates(double weekdayRegularRates) {
        this.weekdayRegularRates = weekdayRegularRates;
    }

    public double getWeekendRegularRates() {
        return weekendRegularRates;
    }

    public void setWeekendRegularRates(double weekendRegularRates) {
        this.weekendRegularRates = weekendRegularRates;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", rating=" + rating +
                ", weekdayRegularRates=" + weekdayRegularRates +
                ", weekendRegularRates=" + weekendRegularRates +
                '}';
    }
}
