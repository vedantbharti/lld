package commonLLDQuestions.carRental.util;

import commonLLDQuestions.carRental.entities.Booking;
import commonLLDQuestions.carRental.enums.VehicleAvailability;
import commonLLDQuestions.carRental.exception.VehicleBookedException;
import commonLLDQuestions.carRental.service.VehicleService;

public class VehicleAvailabilityHandler extends Handler{

    private VehicleService vehicleService;

    public VehicleAvailabilityHandler() {
        vehicleService = new VehicleService();
    }

    @Override
    public boolean handleBooking(Booking booking) {

        if(vehicleService.getVehicleDetails(booking.getVehicleNo()).getVehicleAvailability().equals(VehicleAvailability.BOOKED)) {
            throw new VehicleBookedException("This vehicle is booked");
        }

        return next==null || next.handleBooking(booking);
    }

    @Override
    public void handleCancellation(Booking booking) {

        vehicleService.unbookVehicle(booking.getVehicleNo());

        next.handleCancellation(booking);
    }
}
