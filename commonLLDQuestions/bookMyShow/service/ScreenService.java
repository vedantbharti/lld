package commonLLDQuestions.bookMyShow.service;

import commonLLDQuestions.bookMyShow.entities.Screen;
import commonLLDQuestions.bookMyShow.enums.SeatStatus;
import commonLLDQuestions.bookMyShow.enums.SeatType;
import commonLLDQuestions.bookMyShow.models.Seat;
import commonLLDQuestions.bookMyShow.repository.ScreenRepo;

import java.util.List;

public class ScreenService {

    private ScreenRepo screenRepo;

    public ScreenService() {
        this.screenRepo = ScreenRepo.getInstance();
    }

    public synchronized void addScreen(Screen screen) {
        screenRepo.addScreen(screen);
    }

    public synchronized void addSeatsForScreenId(int screenId, List<Seat> seats) {
        screenRepo.addSeatsForScreenId(screenId,seats);
    }

    public List<Seat> getAvailableSeatsByType(int screenId, SeatType seatType) {
        return screenRepo.getAvailableSeatsByType(screenId,seatType);
    }
}
