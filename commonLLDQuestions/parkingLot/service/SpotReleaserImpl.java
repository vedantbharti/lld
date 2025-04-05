package commonLLDQuestions.parkingLot.service;

import commonLLDQuestions.parkingLot.dao.ParkingSpot;
import commonLLDQuestions.parkingLot.dao.Ticket;
import commonLLDQuestions.parkingLot.dao.repository.ParkingLotRepository;

public class SpotReleaserImpl implements SpotReleaser{

    private ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();

    @Override
    public int releaseOccupiedSpot(int ticketId) {
        Ticket ticket = parkingLotRepository.getTicket(ticketId);
        System.out.println("the ticket is: " + ticket + " and ticket id is: " + ticketId);
        ParkingSpot spot = parkingLotRepository.freeParkingSpot(ticket.getSpotId());

        PaymentService paymentService = new PaymentServiceImpl();
        paymentService.makePayment(ticketId);
        return spot.getSpotId();
    }
}
