package commonLLDQuestions.carRental.service;

import commonLLDQuestions.carRental.entities.Store;
import commonLLDQuestions.carRental.entities.Vehicle;
import commonLLDQuestions.carRental.enums.VehicleType;
import commonLLDQuestions.carRental.exception.VehicleAlreadyAddedException;
import commonLLDQuestions.carRental.models.Location;
import commonLLDQuestions.carRental.repository.StoreRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StoreService {

    private StoreRepository storeRepository;

    public StoreService(){
        storeRepository = StoreRepository.getInstance();
    }

    public void addStore(Store store) {
        storeRepository.addStore(store);
    }

    public void addVehiclesToStore(int storeId, Vehicle vehicle) {
        List<Vehicle> vehicles = storeRepository.getStoreDetails(storeId).getVehicles();
        if(!vehicles.contains(vehicle)){
            vehicles.add(vehicle);
        } else {
            throw new VehicleAlreadyAddedException("This vehicle is already added!");
        }
    }

    public List<Store> getStoresForLocation(Location location) {
        return storeRepository.getStoresForLocation(location);
    }

    public List<Vehicle> getAvailableVehicles(int storeId, VehicleType vehicleType) {
        return storeRepository.getStoreDetails(storeId).getVehicles().stream().filter(vehicle -> vehicle.getVehicleType().equals(vehicleType)).collect(Collectors.toList());
    }
}
