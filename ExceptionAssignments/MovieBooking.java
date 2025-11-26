import java.util.*;

class InvalidSeatException extends Exception { InvalidSeatException(String m){super(m);} }
class SeatAlreadyBookedException extends Exception { SeatAlreadyBookedException(String m){super(m);} }

public class MovieBooking {
    Map<Integer, Boolean> seats = new HashMap<>();

    public MovieBooking(int totalSeats) {
        for (int i = 1; i <= totalSeats; i++) seats.put(i, true);
    }

    void book(int seat) throws InvalidSeatException, SeatAlreadyBookedException {
        if (!seats.containsKey(seat)) throw new InvalidSeatException("No such seat: " + seat);
        if (!seats.get(seat)) throw new SeatAlreadyBookedException("Seat already booked: " + seat);
        seats.put(seat, false);
        System.out.println("Seat " + seat + " booked.");
    }

    public static void main(String[] args) {
        MovieBooking mb = new MovieBooking(5);
        try { mb.book(6); }
        catch (Exception e) { System.out.println(e.getMessage()); }
    }
}
