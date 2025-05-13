package commonLLDQuestions.carRental.entities;

import commonLLDQuestions.carRental.models.Location;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private int storeId;
    private Location location;
    private List<Vehicle> vehicles;

    public Store(int storeId, Location location) {
        this.storeId = storeId;
        this.location = location;
        vehicles = new ArrayList<>();
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
