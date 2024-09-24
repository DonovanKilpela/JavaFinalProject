/*
 * Name: Donovan Kilpela
 * Course: CIS 171 Java
 * Date: 7/31/24
 */

package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.TravelBookingController;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelBookingMainMenuPanel extends JPanel {
	// Buttons to book and view trips
	private JButton buttonBook = new JButton("Book Trip");
	private JButton buttonViewTrips = new JButton("View Trips");
	private TravelBookingController controller;

	// Constructor
	public TravelBookingMainMenuPanel(TravelBookingController controller) {
		this.controller = controller;

		// Label to tell the user what they need to do
		JLabel instructions = new JLabel("Please select an option to continue");

		// Button listener to track when buttons are clicked
		ButtonListener bl = new ButtonListener();
		buttonBook.addActionListener(bl);
		buttonViewTrips.addActionListener(bl);

		// Creating a new panel and adds a layout
		JPanel menu = new JPanel();
		setLayout(new BorderLayout());

		// Adds the label and buttons to the panel
		add(instructions, BorderLayout.NORTH);
		menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
		menu.add(buttonBook);
		menu.add(buttonViewTrips);

		// Adds it to the center of the panel
		add(menu, BorderLayout.CENTER);
	}

	// Buttonlistener method
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel newPanel = new JPanel();
			// if they click the book button it will create a BookTripPanel
			if (e.getSource() == buttonBook) {
				newPanel = new BookTripPanel(controller);
				// If they click the view button it will create a ViewTripsPanel
			} else if (e.getSource() == buttonViewTrips) {
				newPanel = new ViewTripsPanel(controller);
			}
			// Calls the helper method below to send the new panel to the screen
			sendToNewPanel(newPanel);
		}

		// Helper method to send it on button click to the correct panel and show it on
		// screen
		private void sendToNewPanel(JPanel newPanel) {
			removeAll();
			setVisible(false);
			add(newPanel);
			validate();
			setVisible(true);
		}
	}
}