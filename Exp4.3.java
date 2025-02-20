import java.util.concurrent.*;

class TicketBookingSystem {
    private final boolean[] seats;
    
    TicketBookingSystem(int numSeats) {
        seats = new boolean[numSeats];
    }
    
    public synchronized boolean bookSeat(int seatNumber, String user) {
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println("Invalid seat number!");
            return false;
        }
        if (seats[seatNumber - 1]) {
            System.out.println(user + ": Seat " + seatNumber + " is already booked!");
            return false;
        }
        seats[seatNumber - 1] = true;
        System.out.println(user + " booked seat " + seatNumber);
        return true;
    }
}

class User extends Thread {
    private final TicketBookingSystem system;
    private final int seatNumber;
    
    User(TicketBookingSystem system, int seatNumber, String name, int priority) {
        super(name);
        this.system = system;
        this.seatNumber = seatNumber;
        setPriority(priority);
    }
    
    public void run() {
        system.bookSeat(seatNumber, getName());
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(5);
        
        Thread u1 = new User(system, 1, "Anish (VIP)", Thread.MAX_PRIORITY);
        Thread u2 = new User(system, 2, "Bobby (Regular)", Thread.NORM_PRIORITY);
        Thread u3 = new User(system, 3, "Charlie (VIP)", Thread.MAX_PRIORITY);
        Thread u4 = new User(system, 4, "Anish (VIP)", Thread.MAX_PRIORITY);
        Thread u5 = new User(system, 4, "Bobby (Regular)", Thread.MIN_PRIORITY);
        Thread u6 = new User(system, 6, "David (Regular)", Thread.NORM_PRIORITY);
        
        u1.start(); u2.start(); u3.start(); u4.start(); u5.start(); u6.start();
    }
}
