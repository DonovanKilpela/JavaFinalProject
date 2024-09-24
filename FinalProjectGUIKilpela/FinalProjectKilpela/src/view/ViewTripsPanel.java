package view;

import controller.TravelBookingController;
import model.TravelBooking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewTripsPanel extends JPanel {

	// Declarations for the elements that will be on the panel
	private JTextArea list;
	private JScrollPane scroll;
	private TravelBookingController controller;
	private JButton btnBackToMain;

	// Constructor
	public ViewTripsPanel(TravelBookingController controller) {
		this.controller = controller;

		JPanel form = new JPanel();
		JLabel title = new JLabel("DETAILS FOR ALL TRIPS");

		// Gets all of the trips that have been booked and formats them into a string
		ArrayList<TravelBooking> allTrips = controller.getBookings();
		String allTripsFormatted = formatAllTrips(allTrips);

		// Text area to display all of the trips
		JTextArea commentTextArea = new JTextArea(allTripsFormatted, 5, 20);
		commentTextArea.setEditable(false);

		// Makes it scrollable
		scroll = new JScrollPane(commentTextArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(450, 200));

		// Button to get back to main menu
		btnBackToMain = new JButton("Back to Main");
		ButtonListener bl = new ButtonListener();
		btnBackToMain.addActionListener(bl);

		form.setLayout(new BorderLayout());
		form.add(title, BorderLayout.NORTH);
		form.add(scroll, BorderLayout.CENTER);
		form.add(btnBackToMain, BorderLayout.SOUTH);

		add(form);
	}

	// Button listener
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnBackToMain) {
				removeAll();
				setVisible(false);
				TravelBookingMainMenuPanel newPanel = new TravelBookingMainMenuPanel(controller);
				add(newPanel);
				validate();
				setVisible(true);
			}
		}
	}

	// Method to format all the trips into a string and will have a message if no
	// trips are booked
	private String formatAllTrips(ArrayList<TravelBooking> trips) {
		StringBuilder sb = new StringBuilder();
		if (!trips.isEmpty()) {
			for (TravelBooking trip : trips) {
				sb.append(trip.toString());
				sb.append("\n\n");
			}
		} else {
			sb.append("No trips saved. Return to the previous screen to enter data.");
		}
		return sb.toString();
	}
}