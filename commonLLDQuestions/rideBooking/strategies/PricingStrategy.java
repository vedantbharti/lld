package commonLLDQuestions.rideBooking.strategies;

import commonLLDQuestions.rideBooking.model.Location;

import java.util.List;

public interface PricingStrategy {

    public List<Double> calculatePrice(Location pickupLocation, Location dropLocation);
}
