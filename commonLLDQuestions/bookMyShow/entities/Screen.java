package commonLLDQuestions.bookMyShow.entities;

import commonLLDQuestions.bookMyShow.enums.SeatType;
import commonLLDQuestions.bookMyShow.models.Seat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {

    private int screenId;
    private int screenNumber;
    private int totalSeats;
    private Map<SeatType, Integer> availableSeats;
    private Map<SeatType, List<Seat>> seatMap;

    public Screen(int screenId, int screenNumber, int totalSeats) {
        this.screenId = screenId;
        this.screenNumber = screenNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = new HashMap<>();
        this.seatMap = new HashMap<>();
    }


    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Map<SeatType, Integer> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Map<SeatType, Integer> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Map<SeatType, List<Seat>> getSeatMap() {
        return seatMap;
    }

    public void setSeatMap(Map<SeatType, List<Seat>> seatMap) {
        this.seatMap = seatMap;
    }
}
