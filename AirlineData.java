package airline;

import java.util.ArrayList;

public class AirlineData {
    private static ArrayList<String> destinations = new ArrayList<>();
    private static ArrayList<Route> routes = new ArrayList<>();
    private static ArrayList<int[]> seatPrices = new ArrayList<>();

    static {
        //  destinations
        destinations.add("Singapore");
        destinations.add("Malaysia");
        destinations.add("Thailand");
        destinations.add("England");
        destinations.add("America");

        // Prices for Seat Classes (Economy, Business)
        seatPrices.add(new int[]{120000, 250000});
        seatPrices.add(new int[]{100000, 200000});
        seatPrices.add(new int[]{225000, 400000});
        seatPrices.add(new int[]{450000, 900000});
        seatPrices.add(new int[]{400000, 950000});

        //routes
        routes.add(new Route("Singapore", 
                new String[]{"Colombo-Singapore", "Colombo-Chennai-Singapore"}, 
                new String[]{
                    "2025/03/01 5AM - Flight No: FL001", "2025/03/02 8AM - Flight No: FL002"})); 
        routes.add(new Route("Singapore", 
                new String[]{"Colombo-Chennai-Singapore"}, 
                new String[]{
                    "2025/02/25 9AM - Flight No: FL003", "2025/02/26 6PM - Flight No: FL004"})); 

        routes.add(new Route("Malaysia", 
                new String[]{"Colombo-Malaysia", "Colombo-Singapore-Malaysia"}, 
                new String[]{
                    "2025/03/02 8AM - Flight No: FL005", "2025/03/03 10AM - Flight No: FL006"}));
        routes.add(new Route("Malaysia", 
                new String[]{"Colombo-Singapore-Malaysia"}, 
                new String[]{
                    "2025/02/28 6AM - Flight No: FL007", "2025/02/29 5PM - Flight No: FL008"}));

        routes.add(new Route("Thailand", 
                new String[]{"Colombo-Thailand", "Colombo-Singapore-Thailand"}, 
                new String[]{
                    "2025/03/05 10AM - Flight No: FL009", "2025/03/06 7AM - Flight No: FL010"}));
        routes.add(new Route("Thailand", 
                new String[]{"Colombo-Singapore-Thailand"}, 
                new String[]{
                    "2025/02/28 2PM - Flight No: FL011", "2025/02/29 8AM - Flight No: FL012"}));

        routes.add(new Route("England", 
                new String[]{"Colombo-England", "Colombo-Dubai-England"}, 
                new String[]{
                    "2025/03/10 11AM - Flight No: FL013", "2025/03/11 9PM - Flight No: FL014"}));
        routes.add(new Route("England", 
                new String[]{"Colombo-Dubai-England"}, 
                new String[]{
                    "2025/02/28 4PM - Flight No: FL015", "2025/02/29 11AM - Flight No: FL016"}));

        routes.add(new Route("America", 
                new String[]{"Colombo-Dubai-America", "Colombo-Abu Dhabi-America"}, 
                new String[]{
                    "2025/03/08 11AM - Flight No: FL017", "2025/03/09 2PM - Flight No: FL018"}));
        routes.add(new Route("America", 
                new String[]{"Colombo-Abu Dhabi-America"}, 
                new String[]{
                    "2025/02/28 3PM - Flight No: FL019", "2025/02/29 5PM - Flight No: FL020"}));
    }

    public static ArrayList<String> getDestinations() {
        return destinations;
    }

    public static ArrayList<Route> getRoutes() {
        return routes;
    }

    public static int[] getSeatPrices(String destination) {
        int index = destinations.indexOf(destination);
        return (index != -1) ? seatPrices.get(index) : null;
    }
}
