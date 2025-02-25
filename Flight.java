package airline;

public class Flight {
    private String schedule;
    private Booking booking;

    public Flight(String schedule) {
        this.schedule = schedule;
        this.booking = new Booking(50); 
    }

    public String getSchedule() {
        return schedule;
    }

    public Booking getBooking() {
        return booking;
    }
}
