package airline;

public class Booking {
    private int[] seats;

    public Booking(int totalSeats) {
        this.seats = new int[totalSeats]; // 0 = available, 1 = booked
    }

    public int getAvailableSeats() {
        int available = 0;
        for (int seat : seats) {
            if (seat == 0) {
                available++;
            }
        }
        return available;
    }

    public boolean bookSeats(int count) {
        int booked = 0;
        for (int i = 0; i < seats.length && booked < count; i++) {
            if (seats[i] == 0) {
                seats[i] = 1; // Mark seat as booked
                booked++;
            }
        }
        return booked == count;
    }
}
