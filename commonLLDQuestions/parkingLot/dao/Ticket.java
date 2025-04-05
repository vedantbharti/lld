package commonLLDQuestions.parkingLot.dao;

import java.util.Date;

public class Ticket {

    private int ticketId;
    private String vehicleNo;
    private int spotId;
    private Date entryTime;

    public Ticket(int ticketId, String vehicleNo, int spotId) {
        this.ticketId = ticketId;
        this.vehicleNo = vehicleNo;
        this.spotId = spotId;
        this.entryTime = new Date();
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public Date getDate() {
        return entryTime;
    }

    public void setDate(Date entryTime) {
        this.entryTime = entryTime;
    }
}
