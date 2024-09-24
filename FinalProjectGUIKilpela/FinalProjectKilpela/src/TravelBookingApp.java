/*
 * Name: Donovan Kilpela
 * Course: CIS 171 Java
 * Date: 7/31/24
 */

import javax.swing.JFrame;

import controller.TravelBookingController;
import view.TravelBookingMainMenuPanel;

public class TravelBookingApp {

	public static void main(String[] args) {

		 TravelBookingController controller = new TravelBookingController();
		JFrame frame = new JFrame("Travel Booking Application");
		TravelBookingMainMenuPanel panel = new TravelBookingMainMenuPanel(controller);

		frame.add(panel);
		frame.setSize(500, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}