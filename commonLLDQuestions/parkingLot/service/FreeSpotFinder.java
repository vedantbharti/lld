package commonLLDQuestions.parkingLot.service;

import commonLLDQuestions.parkingLot.enums.VehicleType;

public interface FreeSpotFinder {

    public int findFreeSpot(VehicleType vehicleType);
}
