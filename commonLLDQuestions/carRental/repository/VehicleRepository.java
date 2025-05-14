package commonLLDQuestions.carRental.repository;

import commonLLDQuestions.carRental.entities.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {

    Map<Integer, Vehicle> vehicles;

    private VehicleRepository() {
        vehicles = new HashMap<>();
    }

    private static class Initializer {
        private static final VehicleRepository INSTANCE = new VehicleRepository();
    }

    public static VehicleRepository getInstance(){
        return Initializer.INSTANCE;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleNo(),vehicle);
    }

    public Vehicle getVehicleDetails(int vehicleNo){
        return vehicles.get(vehicleNo);
    }
}
