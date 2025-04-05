package commonLLDQuestions.parkingLot.dao.repository;

import commonLLDQuestions.parkingLot.dao.Floor;
import commonLLDQuestions.parkingLot.dao.ParkingSpot;
import commonLLDQuestions.parkingLot.dao.Ticket;
import commonLLDQuestions.parkingLot.enums.SpotType;
import commonLLDQuestions.parkingLot.enums.VehicleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Integer, ParkingSpot> parkingSpots;
    private Map<Integer, Ticket> tickets;

    private Map<Integer, Floor> floors;

    private static ParkingLotRepository parkingLotRepository;

    private ParkingLotRepository() {
        this.parkingSpots = new HashMap<>();
        this.tickets = new HashMap<>();
        this.floors = new HashMap<>();
    }

    public static synchronized ParkingLotRepository getInstance() {
        if(parkingLotRepository==null){
            parkingLotRepository = new ParkingLotRepository();
        }

        return parkingLotRepository;
    }


    //CRUD operations: floor

    public Floor getFloor(int floorNo){
        return floors.get(floorNo);
    }

    public Floor addFloor(Floor floor) {
        floors.put(floor.getFloorNo(), floor);
        return getFloor(floor.getFloorNo());
    }

    public Floor updateFreeSpotCount(int floorNo, SpotType spotType, int count){
        Floor floor = getFloor(floorNo);
        if(spotType == SpotType.LIGHT_VEHICLE){
            floor.setFreeSpotCountForLV(floor.getFreeSpotCountForLV() + count);
        } else {
            floor.setFreeSpotCountForHV(floor.getFreeSpotCountForHV() + count);
        }
        floors.put(floorNo,floor);
        return floor;
    }

    public Floor deleteFloor(int floorNo){
        Floor floor = getFloor(floorNo);
        floors.remove(floorNo);
        return floor;
    }

    public int getFreeSpotCountForLV(int floorNo){
        return floors.get(floorNo).getFreeSpotCountForLV();
    }

    public int getFreeSpotCountForHV(int floorNo){
        System.out.println(floorNo);
        return floors.get(floorNo).getFreeSpotCountForHV();
    }

    //CRUD parking spot

    public ParkingSpot getParkingSpot(int spotId){
        return parkingSpots.get(spotId);
    }

    public ParkingSpot getFirstFreeSpotFor2Wheeler(int floorNo){

        for(Map.Entry<Integer,ParkingSpot> parkingSpotEntry : parkingSpots.entrySet()){
            if(parkingSpotEntry.getValue().isOccupied()==false && parkingSpotEntry.getValue().getFloorNo()==floorNo) {
                return parkingSpotEntry.getValue();
            }
        }

        return null;
    }

    public ParkingSpot getFirstFreeSpotFor4Wheeler(int floorNo,SpotType spotType){

        for(Map.Entry<Integer,ParkingSpot> parkingSpotEntry : parkingSpots.entrySet()){
            if(parkingSpotEntry.getValue().isOccupied()==false &&
                    parkingSpotEntry.getValue().getFloorNo()==floorNo &&
                    parkingSpotEntry.getValue().getSpotType()==spotType) {
                return parkingSpotEntry.getValue();
            }
        }

        return null;
    }

    public ParkingSpot addParkingSpot(ParkingSpot spot){
        parkingSpots.put(spot.getSpotId(),spot);
        return getParkingSpot(spot.getSpotId());
    }

    public ParkingSpot occupyParkingSpot(int spotId, String vehicleNo){
        ParkingSpot spot = parkingSpots.get(spotId);
        spot.setOccupied(true);
        spot.setVehicleNo(vehicleNo);
        parkingSpots.put(spotId,spot);
        int floorNo = spot.getFloorNo();
        updateFreeSpotCount(floorNo,spot.getSpotType(), -1);
        return spot;
    }

    public ParkingSpot freeParkingSpot(int spotId){
        ParkingSpot spot = parkingSpots.get(spotId);
        spot.setOccupied(false);
        spot.setVehicleNo(null);
        parkingSpots.put(spotId,spot);
        int floorNo = spot.getFloorNo();
        updateFreeSpotCount(floorNo,spot.getSpotType(), 1);
        return spot;
    }

    public ParkingSpot deleteParkingSpot(int spotId){
        ParkingSpot spot = parkingSpots.get(spotId);
        parkingSpots.remove(spotId);
        return spot;
    }

    //CRUD ticket

    public Ticket getTicket(int ticketId){
        return tickets.get(ticketId);
    }

    public Ticket addTicket(Ticket ticket){
        tickets.put(ticket.getTicketId(),ticket);
        return tickets.get(ticket.getTicketId());
    }


    public int getFloorCount(){
        return floors.size();
    }

    public int parkingSpotCount(){
        return parkingSpots.size();
    }

}
