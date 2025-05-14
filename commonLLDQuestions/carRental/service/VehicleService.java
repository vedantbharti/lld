package commonLLDQuestions.carRental.service;

import commonLLDQuestions.carRental.entities.Vehicle;
import commonLLDQuestions.carRental.enums.VehicleAvailability;
import commonLLDQuestions.carRental.repository.VehicleRepository;

public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(){
        vehicleRepository = VehicleRepository.getInstance();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.addVehicle(vehicle);
    }

    public Vehicle getVehicleDetails(int vehicleNo){
        return vehicleRepository.getVehicleDetails(vehicleNo);
    }

    public void unbookVehicle(int vehicleNo) {
        vehicleRepository.getVehicleDetails(vehicleNo).setVehicleAvailability(VehicleAvailability.AVAILBALE);
    }
}
