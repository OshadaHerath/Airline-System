package airline;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        ArrayList<Customer> customerList = new ArrayList<>();

        while (true) {
            System.out.println("Welcome to the Airline Booking System!");

            
            String name;
            while (true) {
                System.out.println("Enter your name:");
                name = scanner.nextLine();
                if (name.matches(".*\\d.*")) {
                    System.out.println("Invalid name. Name cannot contain numbers. Please try again.");
                } else {
                    break;
                }
            }

          
            String email;
            while (true) {
                System.out.println("Enter your email:");
                email = scanner.nextLine();
                if (!email.contains("@")) {
                    System.out.println("Invalid email. Email must contain '@'. Please enter a valid email.");
                } else {
                    break;
                }
            }
            Customer customer = new Customer(name, email);
            customerList.add(customer);

            System.out.println("Customer data saved successfully!");

            // Select Destination
            ArrayList<String> destinations = AirlineData.getDestinations();
            System.out.println("Select your destination:");
            for (int i = 0; i < destinations.size(); i++) {
                System.out.println((i + 1) + ". " + destinations.get(i));
            }

            int destChoice;
            while (true) {
                try {
                    System.out.print("Enter your choice: ");
                    destChoice = Integer.parseInt(scanner.nextLine());
                    if (destChoice >= 1 && destChoice <= destinations.size()) {
                        break;
                    } else {
                        System.out.println("Invalid selection. Please select a valid destination.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            String selectedDestination = destinations.get(destChoice - 1);
            ArrayList<Route> availableRoutes = new ArrayList<>();

            for (Route route : AirlineData.getRoutes()) {
                if (route.getDestination().equals(selectedDestination)) {
                    availableRoutes.add(route);
                }
            }

            System.out.println("\nAvailable Routes for " + selectedDestination + ":");
            for (int i = 0; i < availableRoutes.size(); i++) {
                System.out.println((i + 1) + ". " + availableRoutes.get(i).getRoutes().get(0));
            }

            int routeChoice;
            while (true) {
                try {
                    System.out.print("Enter the number of the route you want to select: ");
                    routeChoice = Integer.parseInt(scanner.nextLine());
                    if (routeChoice >= 1 && routeChoice <= availableRoutes.size()) {
                        break;
                    } else {
                        System.out.println("Invalid selection. Please select a valid route.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            Route chosenRoute = availableRoutes.get(routeChoice - 1);

            // Select Flight Schedule
            System.out.println("\nAvailable Flights for Route: " + chosenRoute.getRoutes().get(0));
            ArrayList<Flight> flights = chosenRoute.getFlights();
            for (int i = 0; i < flights.size(); i++) {
                System.out.println((i + 1) + ". " + flights.get(i).getSchedule());
            }

            int flightChoice;
            while (true) {
                try {
                    System.out.print("Enter the number of the flight you want to select: ");
                    flightChoice = Integer.parseInt(scanner.nextLine());
                    if (flightChoice >= 1 && flightChoice <= flights.size()) {
                        break;
                    } else {
                        System.out.println("Invalid selection. Please select a valid flight.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            Flight selectedFlight = flights.get(flightChoice - 1);

            // Select Seat Class
            int[] seatPrices = AirlineData.getSeatPrices(selectedDestination);
            System.out.println("Select your seat class:");
            System.out.println("1. Economy - Rs." + seatPrices[0]);
            System.out.println("2. Business - Rs." + seatPrices[1]);

            int seatClassChoice;
            while (true) {
                try {
                    System.out.print("Enter your choice: ");
                    seatClassChoice = Integer.parseInt(scanner.nextLine());
                    if (seatClassChoice == 1 || seatClassChoice == 2) {
                        break;
                    } else {
                        System.out.println("Invalid selection. Please enter 1 or 2.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            String seatClass = (seatClassChoice == 1) ? "Economy" : "Business";

            // Check Seat Availability
            Booking booking = selectedFlight.getBooking();
            int availableSeats = booking.getAvailableSeats();
            System.out.println("Available seats in " + seatClass + ": " + availableSeats);

            int seatsToBook;
            while (true) {
                try {
                    System.out.print("Enter the number of seats to book: ");
                    seatsToBook = Integer.parseInt(scanner.nextLine());
                    if (seatsToBook > 0 && seatsToBook <= availableSeats) {
                        break;
                    } else {
                        System.out.println("Invalid number of seats. Enter a value between 1 and " + availableSeats + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            // Calculate Total Price
            int totalPrice = seatPrices[seatClassChoice - 1] * seatsToBook;
            System.out.println("Total Price: Rs." + totalPrice);

            // Select Payment Method
            int paymentMethod;
            while (true) {
                try {
                    System.out.println("\nSelect Payment Method:");
                    System.out.println("1. PayPal");
                    System.out.println("2. Card Payment");
                    System.out.print("Enter your choice: ");
                    paymentMethod = Integer.parseInt(scanner.nextLine());
                    if (paymentMethod == 1 || paymentMethod == 2) {
                        break;
                    } else {
                        System.out.println("Invalid selection. Please enter 1 or 2.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            // Add payment to queue
            Payment payment = new Payment(paymentMethod, totalPrice);
            Payment.enqueuePayment(payment);

            // Booking Confirmation
            System.out.println("If you would like to confirm the booking, type \"CONFIRM\" and hit Enter.");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("CONFIRM")) {
                Payment.processPayments();
                Reports.addReport(customer.getName(), customer.getEmail(), selectedDestination, chosenRoute.getRoutes().get(0), selectedFlight.getSchedule(), seatClass, seatsToBook, totalPrice);
                Reports.displayReports();
                if (!booking.bookSeats(seatsToBook)) {
                    System.out.println("Booking failed.");
                }
            } else {
                System.out.println("Invalid confirmation. Booking cancelled. Returning to the main menu...\n");
            }
        }
    }
}
