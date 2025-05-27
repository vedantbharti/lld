package commonLLDQuestions.rideBooking.entity;

import commonLLDQuestions.rideBooking.enums.VehicleType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Vehicle {

    private final String vehicleNo;
    private final VehicleType vehicleType;

}
