/*
 * Name: Donovan Kilpela
 * Course: CIS 171 Java
 * Date: 7/31/24
 */

package view;

import controller.TravelBookingController;
import model.TravelBooking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookTripPanel extends JPanel {
	// Declarations for the elements that will be on the panel
    private JTextField textFieldName;
    private JTextField textFieldBudget;
    private JComboBox<Integer> tripDuration;
    private JComboBox<String> destinationCity;
    private JComboBox<String> travelMethod;
    private JButton buttonSubmit;
    private JButton buttonClear;
    private JButton backToMainMenu;

    private TravelBookingController controller;

    // Constructor
    public BookTripPanel(TravelBookingController controller) {
        this.controller = controller;
        
        // Set up the layout for the panel
        setLayout(new BorderLayout());
        // Adding label to show the user what they need to do 
        JLabel instructions = new JLabel("Enter in the information to submit your trip");
        add(instructions, BorderLayout.NORTH);
        
        // creating the panel 
        JPanel tripBooking = new JPanel();
        tripBooking.setLayout(new BoxLayout(tripBooking, BoxLayout.PAGE_AXIS));
        
        // Adding the textfields to the panel 
        textFieldName = new JTextField(20);
        addLabelAndField(tripBooking, "Enter Trip Name: ", textFieldName);

        textFieldBudget = new JTextField(10);
        addLabelAndField(tripBooking, "Enter in your Budget: ", textFieldBudget);
        
        // Adding the numbers into the  combobox and adding it to the panel 
        tripDuration = new JComboBox<>();
        for (int i = 1; i <= 7; i++) {
            tripDuration.addItem(i);
        }
        addLabelAndField(tripBooking, "Select how many days you will be on the trip: ", tripDuration);
        
        // Adding the destination and travelmethods to the panel for the user to select
        destinationCity = new JComboBox<>(controller.getDestinations().toArray(new String[0]));
        addLabelAndField(tripBooking, "Select what city you would like to travel to: ", destinationCity);

        travelMethod = new JComboBox<>(controller.getTravelMethods().toArray(new String[0]));
        addLabelAndField(tripBooking, "Select what travel method you would like to take: ", travelMethod);
        
        // Adding the buttons to the screen 
        buttonSubmit = new JButton("Submit");
        buttonClear = new JButton("Clear");
        backToMainMenu = new JButton("Back to Main Menu");
        
        // Adds actionlistener to the buttons 
        buttonSubmit.addActionListener(new ButtonListener());
        buttonClear.addActionListener(new ButtonListener());
        backToMainMenu.addActionListener(new ButtonListener());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(buttonSubmit);
        buttonPanel.add(buttonClear);
        buttonPanel.add(backToMainMenu);

        tripBooking.add(buttonPanel);
        add(tripBooking, BorderLayout.CENTER);
    }
    
    // Helper method to add the labels and field to the panel 
    private void addLabelAndField(JPanel panel, String labelText, JComponent field) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(new JLabel(labelText));
        p.add(field);
        panel.add(p);
    }
     // Helper method to submit the information the user entered 
    private void submitBooking() {
        try {
            String name = textFieldName.getText();
            double budget = Double.parseDouble(textFieldBudget.getText());
            
            // Makes sure that the budget is a vaild number
            if (budget <= 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a positive number for budget.",
                    "Invalid Budget",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            int duration = (Integer) tripDuration.getSelectedItem();
            String city = (String) destinationCity.getSelectedItem();
            String method = (String) travelMethod.getSelectedItem();
            
            // Creates and adds new booking 
            TravelBooking booking = new TravelBooking(name, city, method, budget, duration, 0.0);
            booking.calculateTravelCost(controller.getDestinations(), controller.getTravelMethods());
            controller.addBooking(booking);

            clearAllFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number for budget.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    // Method to clear all of the fields 
    private void clearAllFields() {
        textFieldName.setText("");
        textFieldBudget.setText("");
        tripDuration.setSelectedIndex(0);
        destinationCity.setSelectedIndex(0);
        travelMethod.setSelectedIndex(0);
    }

    // Method to send it back to the main screen 
    private void backToMainPanel() {
        JPanel newPanel = new TravelBookingMainMenuPanel(controller);
        removeAll();
        add(newPanel);
        revalidate();
        repaint();
    }
    
	// Button listener
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonSubmit) {
                submitBooking();
            } else if (e.getSource() == buttonClear) {
                clearAllFields();
            } else if (e.getSource() == backToMainMenu) {
                backToMainPanel();
            }
        }
    }
}