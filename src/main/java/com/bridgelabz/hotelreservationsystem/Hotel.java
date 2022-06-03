package com.bridgelabz.hotelreservationsystem;
/*
 *Author: Prasad
 */
public class Hotel {
    String hotelName;
    double rating;
    double regularCustomerRates;

    //constructor
    public Hotel(){

    }

    //parametrized constructor
    public Hotel(String hotelName, double rating, double regularCustomerRates) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.regularCustomerRates = regularCustomerRates;
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

    public double getRegularCustomerRates() {
        return regularCustomerRates;
    }

    public void setRegularCustomerRates(double regularCustomerRates) {
        this.regularCustomerRates = regularCustomerRates;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", rating=" + rating +
                ", regularCustomerRates=" + regularCustomerRates +
                '}';
    }
}
