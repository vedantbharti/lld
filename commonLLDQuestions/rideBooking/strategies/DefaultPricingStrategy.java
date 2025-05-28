package commonLLDQuestions.rideBooking.strategies;

import commonLLDQuestions.rideBooking.model.Location;

import java.util.Arrays;
import java.util.List;

public class DefaultPricingStrategy implements PricingStrategy{


    @Override
    public List<Double> calculatePrice(Location pickupLocation, Location dropLocation) {

        //calculate pricing logic here

        return Arrays.asList(100.0,150.0,200.0);
    }
}
