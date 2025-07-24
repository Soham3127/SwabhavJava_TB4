package com.aurionpro.compare.flightfare;

public class Flight {
    private String airline;
    private double fare;

    public Flight(String airline, double fare) {
        this.airline = airline;
        this.fare = fare;
    }

    public String getAirline() {
        return airline;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return "Flight{Airline='" + airline + "', Fare=₹" + fare + "}";
    }
}