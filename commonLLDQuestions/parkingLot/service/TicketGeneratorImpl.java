package commonLLDQuestions.parkingLot.service;

import commonLLDQuestions.parkingLot.dao.Ticket;
import commonLLDQuestions.parkingLot.dao.Vehicle;
import commonLLDQuestions.parkingLot.dao.repository.ParkingLotRepository;
import commonLLDQuestions.parkingLot.enums.VehicleType;
import commonLLDQuestions.parkingLot.exceptions.NoAvailableParkingSpot;

public class TicketGeneratorImpl implements TicketGenerator{

    private ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();

    private SpotFinder spotFinder;


    @Override
    public synchronized Ticket generateTicket(Vehicle vehicle, int ticketId) {

        //we can move this to a factory class
        if(vehicle.getVehicleType()== VehicleType.TWO_WHEELER){
            spotFinder = new TwoWheelerSpotFinder();
        } else {
            spotFinder = new FourWheelerSpotFinder();
        }

        try {
            int spotId = spotFinder.findFreeSpot();
            parkingLotRepository.occupyParkingSpot(spotId, vehicle.getVehicleNo());
            Ticket ticket = new Ticket(ticketId,vehicle.getVehicleNo(),spotId);
            parkingLotRepository.addTicket(ticket);
        } catch (NoAvailableParkingSpot e) {
            throw e;
        }


        return parkingLotRepository.getTicket(ticketId);

    }
}
