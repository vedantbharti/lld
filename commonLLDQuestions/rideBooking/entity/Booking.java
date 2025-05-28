package commonLLDQuestions.rideBooking.entity;


import commonLLDQuestions.rideBooking.enums.BookingStatus;
import commonLLDQuestions.rideBooking.model.Location;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
public class Booking {

    private final String bookingId;
    private final String driverId;
    private final String customerId;
    private Date bookingStartTime;
    private Date bookingEndTime;
    private Location pickupLocation;
    private Location dropLocation;
    private BookingStatus bookingStatus;
    private double totalCost;

    public Booking(String driverId, String customerId, double totalCost, Date bookingStartTime, Location pickupLocation, Location dropLocation){
        this.bookingId = UUID.randomUUID().toString();
        this.driverId = driverId;
        this.customerId = customerId;
        this.bookingStartTime = bookingStartTime;
        this.bookingEndTime = null;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.bookingStatus = BookingStatus.ACTIVE;
        this.totalCost = totalCost;
    }

}
