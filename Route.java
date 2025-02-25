package airline;

import java.util.ArrayList;

public class Route {
    private String destination;
    private ArrayList<String> routes;
    private ArrayList<Flight> flights;

    public Route(String destination, String[] routeList, String[] flightSchedules) {
        this.destination = destination;
        this.routes = new ArrayList<>();
        this.flights = new ArrayList<>();
        
        for (String route : routeList) {
            this.routes.add(route);
        }

        for (String schedule : flightSchedules) {
            this.flights.add(new Flight(schedule));
        }
    }

    public String getDestination() {
        return destination;
    }

    public ArrayList<String> getRoutes() {
        return routes;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
}
