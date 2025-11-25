class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    // Method to book a ticket
    void bookTicket(String movie, int seat, double ticketPrice) {
        movieName = movie;
        seatNumber = seat;
        price = ticketPrice;
        System.out.println("Ticket booked successfully!");
    }

    // Method to display ticket details
    void displayTicket() {
        System.out.println("\n----- Ticket Details -----");
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price      : " + price);
    }
}

public class MovieTicketTest {
    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();

        // Booking a ticket
        mt.bookTicket("Avengers: Endgame", 15, 250.0);

        // Displaying ticket details
        mt.displayTicket();
    }
}
