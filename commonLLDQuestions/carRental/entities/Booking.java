package commonLLDQuestions.carRental.entities;

import commonLLDQuestions.carRental.enums.BookingStatus;

import java.util.Date;

public class Booking {

    private int bookingId;
    private int userId;
    private int vehicleNo;
    private Date bookingTime;
    private Date startTime;
    private Date endTime;
    private String paymentId;
    private BookingStatus bookingStatus;

    public Booking(int bookingId, int userId, int vehicleNo, Date startTime, Date endTime) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.vehicleNo = vehicleNo;
        this.bookingTime = new Date();
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingStatus = BookingStatus.INACTIVE;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

}
