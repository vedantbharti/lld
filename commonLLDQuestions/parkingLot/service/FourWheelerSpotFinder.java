package commonLLDQuestions.parkingLot.service;

import commonLLDQuestions.parkingLot.dao.ParkingSpot;
import commonLLDQuestions.parkingLot.dao.repository.ParkingLotRepository;
import commonLLDQuestions.parkingLot.enums.SpotType;
import commonLLDQuestions.parkingLot.exceptions.NoAvailableParkingSpot;

public class FourWheelerSpotFinder implements SpotFinder{

    private ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();

    @Override
    public synchronized int findFreeSpot() {

        int numberOfFloors = parkingLotRepository.getFloorCount();
        ParkingSpot parkingSpot = null;
        for(int i=1;i<=numberOfFloors;i++){
            if(parkingLotRepository.getFreeSpotCountForHV(i)>0) {
                parkingSpot = parkingLotRepository.getFirstFreeSpotFor4Wheeler(i, SpotType.HEAVY_VEHICLE);
                break;
            }
        }

        if(parkingSpot==null) {
            throw new NoAvailableParkingSpot("Parking lot is full!");
        }

        return parkingSpot.getSpotId();
    }
}
