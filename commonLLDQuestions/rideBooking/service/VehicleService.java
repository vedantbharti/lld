package commonLLDQuestions.rideBooking.service;

import commonLLDQuestions.rideBooking.entity.Vehicle;
import commonLLDQuestions.rideBooking.repository.VehicleRepo;

public class VehicleService {

    private final VehicleRepo vehicleRepo;

    public VehicleService(){
        this.vehicleRepo = VehicleRepo.getInstance();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleRepo.addVehicle(vehicle);
    }

    public Vehicle getVehicleByNumber(String vehicleNo) {
        return vehicleRepo.getVehicleByNumber(vehicleNo);
    }
}
