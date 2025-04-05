package commonLLDQuestions.parkingLot.dao;

import commonLLDQuestions.parkingLot.enums.SpotType;

public class ParkingSpot {

    private int spotId;
    private SpotType spotType;
    private boolean isOccupied;
    private int floorNo;
    private String vehicleNo;

    public ParkingSpot(int spotId, SpotType spotType, int floorNo){
        this.spotId = spotId;
        this.spotType = spotType;
        this.floorNo = floorNo;
        this.isOccupied = false;
        this.vehicleNo = null;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId=" + spotId +
                ", spotType=" + spotType +
                ", isOccupied=" + isOccupied +
                ", floorNo=" + floorNo +
                ", vehicleNo='" + vehicleNo + '\'' +
                '}';
    }
}
