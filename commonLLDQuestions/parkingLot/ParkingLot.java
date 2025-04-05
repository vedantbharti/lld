package commonLLDQuestions.parkingLot;

import commonLLDQuestions.parkingLot.dao.Floor;
import commonLLDQuestions.parkingLot.dao.ParkingSpot;
import commonLLDQuestions.parkingLot.dao.Ticket;
import commonLLDQuestions.parkingLot.dao.Vehicle;
import commonLLDQuestions.parkingLot.dao.repository.ParkingLotRepository;
import commonLLDQuestions.parkingLot.enums.SpotType;
import commonLLDQuestions.parkingLot.enums.VehicleType;
import commonLLDQuestions.parkingLot.service.SpotReleaser;
import commonLLDQuestions.parkingLot.service.SpotReleaserImpl;
import commonLLDQuestions.parkingLot.service.TicketGenerator;
import commonLLDQuestions.parkingLot.service.TicketGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    public static void main(String[] args) {

        ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();

        Floor floor = new Floor(1,8);

        Floor addedFloor = parkingLotRepository.addFloor(floor);
        System.out.println("the added floor is: " + addedFloor.toString());

        ParkingSpot parkingSpot1 = new ParkingSpot(1,SpotType.LIGHT_VEHICLE,1);
        parkingLotRepository.addParkingSpot(parkingSpot1);
        ParkingSpot parkingSpot2 = new ParkingSpot(2,SpotType.LIGHT_VEHICLE,1);
        parkingLotRepository.addParkingSpot(parkingSpot2);
        ParkingSpot parkingSpot3 = new ParkingSpot(3,SpotType.LIGHT_VEHICLE,1);
        parkingLotRepository.addParkingSpot(parkingSpot3);
        ParkingSpot parkingSpot4 = new ParkingSpot(4,SpotType.LIGHT_VEHICLE,1);
        parkingLotRepository.addParkingSpot(parkingSpot4);
        ParkingSpot parkingSpot5 = new ParkingSpot(5,SpotType.HEAVY_VEHICLE,1);
        parkingLotRepository.addParkingSpot(parkingSpot5);
        ParkingSpot parkingSpot6 = new ParkingSpot(6,SpotType.HEAVY_VEHICLE,1);
        parkingLotRepository.addParkingSpot(parkingSpot6);
        ParkingSpot parkingSpot7 = new ParkingSpot(7,SpotType.HEAVY_VEHICLE,1);
        parkingLotRepository.addParkingSpot(parkingSpot7);
        ParkingSpot parkingSpot8 = new ParkingSpot(8,SpotType.HEAVY_VEHICLE,1);
        parkingLotRepository.addParkingSpot(parkingSpot8);



        Vehicle vehicle1 = new Vehicle("1", VehicleType.TWO_WHEELER);
        Vehicle vehicle2 = new Vehicle("2", VehicleType.TWO_WHEELER);
        Vehicle vehicle3 = new Vehicle("3", VehicleType.FOUR_WHEELER);
        Vehicle vehicle4 = new Vehicle("4", VehicleType.FOUR_WHEELER);

        TicketGenerator ticketGenerator = new TicketGeneratorImpl();

        Ticket ticket1 = ticketGenerator.generateTicket(vehicle1,1);
        Ticket ticket2 = ticketGenerator.generateTicket(vehicle2,2);
        Ticket ticket3 = ticketGenerator.generateTicket(vehicle3,3);
        Ticket ticket4 = ticketGenerator.generateTicket(vehicle4,4);

        System.out.println("Details of ticket is: " + ticket1.toString());
        System.out.println("Details of ticket is: " + ticket2.toString());
        System.out.println("Details of ticket is: " + ticket3.toString());
        System.out.println("Details of ticket is: " + ticket4.toString());

        SpotReleaser spotReleaser = new SpotReleaserImpl();
        int releasedSpotId1 = spotReleaser.releaseOccupiedSpot(ticket1.getTicketId());
        int releasedSpotId2 = spotReleaser.releaseOccupiedSpot(ticket3.getTicketId());

        System.out.println("released spot has spot Id: " + releasedSpotId1 + " and " + releasedSpotId2);

        Ticket ticket5 = ticketGenerator.generateTicket(vehicle2,5);
        Ticket ticket6 = ticketGenerator.generateTicket(vehicle4,6);

        System.out.println("Details of ticket is: " + ticket5.toString());
        System.out.println("Details of ticket is: " + ticket6.toString());
    }
}
