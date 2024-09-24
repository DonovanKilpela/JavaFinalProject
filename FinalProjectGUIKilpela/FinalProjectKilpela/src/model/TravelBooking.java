/*
 * Name: Donovan Kilpela
 * Course: CIS 171 Java
 * Date: 7/28/24
 */
package model;

import java.util.ArrayList;

public class TravelBooking {

	// Variable declarations
	private String tripName;
	private String fromCity;
	private String destinationCity;
	private String travelMethod;
	private double budget;
	private int tripDuration;
	private double travelCost;

	// Default constructor
	public TravelBooking() {
		super();
		this.setTripName("No name");
		this.budget = 0.0;
		this.fromCity = "No Start place";
		this.destinationCity = "No destination";
		this.travelMethod = "No travel Method";
		this.tripDuration = 0;
		this.travelCost = 0.0;
	}

	public TravelBooking(String tripName, String fromCity, String destinationCity, String travelMethod, double budget, int tripDuration,
			double travelCost) {
		super();
		this.tripName = tripName;
		this.fromCity = fromCity;
		this.destinationCity = destinationCity;
		this.travelMethod = travelMethod;
		this.budget = budget;
		this.tripDuration = tripDuration;
		this.travelCost = travelCost;
	}

	// Getters and Setters
	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getTravelMethod() {
		return travelMethod;
	}

	public void setTravelMethod(String travelMethod) {
		this.travelMethod = travelMethod;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getTripDuration() {
		return tripDuration;
	}

	public void setTripDuration(int tripDuration) {
		this.tripDuration = tripDuration;
	}

	public double getTravelCost() {
		return travelCost;
	}

	public void setTravelCost(double travelCost) {
		this.travelCost = travelCost;
	}

	// Method to get the remaining budget
	public double getRemainingBudget() {
		return budget - travelCost;
	}

	// Method to calculate the daily budget
	public double getDailyBudget() {
		return getRemainingBudget() / tripDuration;
	}

	// Method to get the total cost of travel
	public void calculateTravelCost(ArrayList<String> destinations, ArrayList<String> travelMethods) {
		// Minneapolis
		if (destinationCity.equals(destinations.get(0))) {
			// Car cost
			if (travelMethod.equals(travelMethods.get(0))) {
				travelCost = 78.50;
				// Bus cost
			} else if (travelMethod.equals(travelMethods.get(1))) {
				travelCost = 125.25;
				// Plane Cost
			} else {
				travelCost = 170.15;
			}
			// Las Vegas
		} else if (destinationCity.equals(destinations.get(1))) {
			// Car cost
			if (travelMethod.equals(travelMethods.get(0))) {
				travelCost = 275.36;
				// Bus cost
			} else if (travelMethod.equals(travelMethods.get(1))) {
				travelCost = 215.64;
				// Plane Cost
			} else {
				travelCost = 315.04;
			}
			// New York
		} else if (destinationCity.equals(destinations.get(2))) {
			// Car cost
			if (travelMethod.equals(travelMethods.get(0))) {
				travelCost = 180.45;
				// Bus cost
			} else if (travelMethod.equals(travelMethods.get(1))) {
				travelCost = 204.65;
				// Plane Cost
			} else {
				travelCost = 194.15;
			}
		}
	}

	@Override
	public String toString() {
		return String.format(
				"Travel Booking Details:\n" + "Trip Name: %s\n" + "Destination City: %s\n" + "Travel Method: %s\n"
						+ "Budget: $%.2f\n" + "Trip Duration: %d days\n" + "Travel Cost: $%.2f\n"
						+ "Remaining Budget: $%.2f\n" + "Daily Budget: $%.2f",
				tripName, destinationCity, travelMethod, budget, tripDuration, travelCost, getRemainingBudget(),
				getDailyBudget());
	}

}
