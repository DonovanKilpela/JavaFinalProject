/*
 * Name: Donovan Kilpela
 * Course: CIS 171 Java
 * Date: 7/31/24
 */

package controller;

import java.util.ArrayList;
import java.util.Arrays;

import model.TravelBooking;

public class TravelBookingController {

	// ArrayLists to hold destination, travelMethods, and the travels they have
	// booked
	private ArrayList<String> fromCity;
	private ArrayList<String> destinations;
	private ArrayList<String> travelMethods;
	private ArrayList<TravelBooking> bookings;

	// Constructor
	public TravelBookingController() {
		super();
		// puts the destinations into the ArrayList
		destinations = new ArrayList<>(Arrays.asList("Minneapolis", "Las Vegas", "New York"));
		// Puts the travelMethods in the ArrayList
		travelMethods = new ArrayList<>(Arrays.asList("Car", "Bus", "Plane"));
		bookings = new ArrayList<>();
	}

	// Getters
	public ArrayList<String> getDestinations() {
		return destinations;
	}

	public ArrayList<String> getTravelMethods() {
		return travelMethods;
	}

	public ArrayList<String> getFromCity() {
		return fromCity;
	}

	public void setFromCity(ArrayList<String> fromCity) {
		this.fromCity = fromCity;
	}

	// Method to add the trip to the bookings ArrayList
	public void addBooking(TravelBooking booking) {
		bookings.add(booking);
	}

	// Getter for all of the bookings
	public ArrayList<TravelBooking> getBookings() {
		return bookings;
	}

}
