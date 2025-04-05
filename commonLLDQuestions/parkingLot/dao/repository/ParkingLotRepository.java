package commonLLDQuestions.parkingLot.dao.repository;

import commonLLDQuestions.parkingLot.dao.ParkingSpot;
import commonLLDQuestions.parkingLot.dao.Ticket;
import commonLLDQuestions.parkingLot.enums.SpotType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Integer, ParkingSpot> parkingSpots;
    private Map<Integer, Ticket> tickets;
    private Map<Integer, List<Integer>> parkingSpotsPerFloor;
    private Map<SpotType, List<Integer>> parkingSpotsPerSpotType;

    private static ParkingLotRepository parkingLotRepository;

    private ParkingLotRepository(){
        this.parkingSpots = new HashMap<>();
        this.tickets = new HashMap<>();
        this.parkingSpotsPerFloor = new HashMap<>();
        this.parkingSpotsPerSpotType = new HashMap<>();
    }

    public static synchronized ParkingLotRepository getInstance(){
        if(parkingLotRepository==null){
            parkingLotRepository = new ParkingLotRepository();
        }

        return parkingLotRepository;
    }

    public Map<Integer, ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(Map<Integer, ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public Map<Integer, Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Map<Integer, Ticket> tickets) {
        this.tickets = tickets;
    }

    public Map<Integer, List<Integer>> getParkingSpotsPerFloor() {
        return parkingSpotsPerFloor;
    }

    public void setParkingSpotsPerFloor(Map<Integer, List<Integer>> parkingSpotsPerFloor) {
        this.parkingSpotsPerFloor = parkingSpotsPerFloor;
    }

    public Map<SpotType, List<Integer>> getParkingSpotsPerSpotType() {
        return parkingSpotsPerSpotType;
    }

    public void setParkingSpotsPerSpotType(Map<SpotType, List<Integer>> parkingSpotsPerSpotType) {
        this.parkingSpotsPerSpotType = parkingSpotsPerSpotType;
    }
}
