package commonLLDQuestions.carRental.entities;

import commonLLDQuestions.carRental.enums.VehicleAvailability;
import commonLLDQuestions.carRental.enums.VehicleType;

public class Vehicle {

    private int vehicleNo;
    private String vehicleName;
    private VehicleType vehicleType;
    private VehicleAvailability vehicleAvailability;

    public Vehicle(int vehicleNo, String vehicleName, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.vehicleAvailability = VehicleAvailability.AVAILBALE;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleAvailability getVehicleAvailability() {
        return vehicleAvailability;
    }

    public void setVehicleAvailability(VehicleAvailability vehicleAvailability) {
        this.vehicleAvailability = vehicleAvailability;
    }
}
