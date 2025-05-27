package commonLLDQuestions.rideBooking.entity;


import commonLLDQuestions.rideBooking.enums.BookingStatus;
import commonLLDQuestions.rideBooking.model.Location;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
public class Booking {

    private final int bookingId;
    private final int driverId;
    private final int customerId;
    private Date bookingStartTime;
    private Date bookingEndTime;
    private Location startLocation;
    private Location dropLocation;
    private BookingStatus bookingStatus;
    private double totalCost;

    public Booking(int bookingId, int driverId, int customerId, double totalCost, Date bookingStartTime, Location startLocation, Location dropLocation){
        this.bookingId = bookingId;
        this.driverId = driverId;
        this.customerId = customerId;
        this.bookingStartTime = bookingStartTime;
        this.bookingEndTime = null;
        this.startLocation = startLocation;
        this.dropLocation = dropLocation;
        this.bookingStatus = BookingStatus.ACTIVE;
        this.totalCost = totalCost;
    }

}
