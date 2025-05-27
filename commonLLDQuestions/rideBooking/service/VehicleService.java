package commonLLDQuestions.rideBooking.service;

import commonLLDQuestions.rideBooking.repository.VehicleRepo;

public class VehicleService {

    private final VehicleRepo vehicleRepo;

    public VehicleService(){
        this.vehicleRepo = VehicleRepo.getInstance();
    }


}
