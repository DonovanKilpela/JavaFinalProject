/*
 * Name: Donovan Kilpela
 * Course: CIS 171 Java
 * Date: 7/31/24
 */

package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.TravelBooking;

public class TravelBookingTest {

	private TravelBooking booking;
	private ArrayList<String> destinations;
	private ArrayList<String> travelMethods;

	@BeforeEach
	public void setUp() {
		booking = new TravelBooking("Vacation", "Minneapolis", "Car", 500.0, 5, 0.0);
		destinations = new ArrayList<>(Arrays.asList("Minneapolis", "Las Vegas", "New York"));
		travelMethods = new ArrayList<>(Arrays.asList("Car", "Bus", "Plane"));
	}

	@Test
	public void testGetRemainingBudget() {
		booking.setTravelCost(100.0);
		assertEquals(400.0, booking.getRemainingBudget());
	}

	@Test
	public void testGetDailyBudget() {
		booking.setTravelCost(100.0);
		assertEquals(80.0, booking.getDailyBudget());
	}

	@Test
	public void testCalculateTravelCost() {
		booking.calculateTravelCost(destinations, travelMethods);
		assertEquals(78.50, booking.getTravelCost());
	}

	@Test
	public void testToString() {
		booking.calculateTravelCost(destinations, travelMethods);
		String expected = "Travel Booking Details:\n" + "Trip Name: Vacation\n" + "Destination City: Minneapolis\n"
				+ "Travel Method: Car\n" + "Budget: $500.00\n" + "Trip Duration: 5 days\n" + "Travel Cost: $78.50\n"
				+ "Remaining Budget: $421.50\n" + "Daily Budget: $84.30";
		assertEquals(expected, booking.toString());
	}
}