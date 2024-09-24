/*
 * Name: Donovan Kilpela
 * Course: CIS 171 Java
 * Date: 7/31/24
 */

package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controller.TravelBookingController;
import model.TravelBooking;

public class TravelBookingControllerTest {

	private TravelBookingController controller;

	@BeforeEach
	public void setUp() {
		controller = new TravelBookingController();
	}

	@Test
	public void testGetDestinations() {
		ArrayList<String> expectedDestinations = new ArrayList<>();
		expectedDestinations.add("Minneapolis");
		expectedDestinations.add("Las Vegas");
		expectedDestinations.add("New York");
		assertEquals(expectedDestinations, controller.getDestinations());
	}

	@Test
	public void testGetTravelMethods() {
		ArrayList<String> expectedMethods = new ArrayList<>();
		expectedMethods.add("Car");
		expectedMethods.add("Bus");
		expectedMethods.add("Plane");
		assertEquals(expectedMethods, controller.getTravelMethods());
	}

	@Test
	public void testAddBooking() {
		TravelBooking booking = new TravelBooking("Vacation", "Minneapolis", "Car", 500.0, 5, 0.0);
		controller.addBooking(booking);
		assertEquals(1, controller.getBookings().size());
		assertEquals(booking, controller.getBookings().get(0));
	}
}