package airline;


import java.util.ArrayList;

public class Reports {
    private static final ArrayList<String> reports = new ArrayList<>();

    public static void addReport(String name, String email, String destination, String route, String schedule, String seatClass, int seats, int price) {
        String report = "\nBooking Report:\n" +
                "Customer Name: " + name + "\n" +
                "Customer Email: " + email + "\n" +
                "Destination: " + destination + "\n" +
                "Selected Route: " + route + "\n" +
                "Selected Flight Schedule: " + schedule + "\n" +
                "Seat Class: " + seatClass + "\n" +
                "Seats Booked: " + seats + "\n" +
                "Total Price: Rs." + price + "\n";
        reports.add(report);
    }

    public static void displayReports() {
        for (String report : reports) {
            System.out.println(report);
        }
    }
}
