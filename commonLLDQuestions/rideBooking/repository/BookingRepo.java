package commonLLDQuestions.rideBooking.repository;

import commonLLDQuestions.rideBooking.entity.Booking;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookingRepo {


    private Map<Integer, Booking> bookings;

    private BookingRepo() {
        this.bookings = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final BookingRepo INSTANCE = new BookingRepo();
    }

    public static BookingRepo getInstance(){
        return Initializer.INSTANCE;
    }
}
