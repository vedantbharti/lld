package commonLLDQuestions.bookMyShow.repository;

import commonLLDQuestions.bookMyShow.entities.Screen;
import commonLLDQuestions.bookMyShow.enums.SeatStatus;
import commonLLDQuestions.bookMyShow.enums.SeatType;
import commonLLDQuestions.bookMyShow.models.Seat;

import java.util.*;
import java.util.stream.Collectors;

public class ScreenRepo {

    Map<Integer, Screen> screens;

    private ScreenRepo(){
        this.screens = new HashMap<>();
    }

    private static class Initializer {
        private static final ScreenRepo INSTANCE = new ScreenRepo();
    }

    public static ScreenRepo getInstance() {
        return ScreenRepo.Initializer.INSTANCE;
    }

    public synchronized void addScreen(Screen screen) {
        screens.put(screen.getScreenId(),screen);
    }

    public synchronized void addSeatsForScreenId(int screenId, List<Seat> seats) {
        seats.stream().forEach(seat -> {
            Screen screen = screens.get(screenId);
            if(screen.getSeatMap().containsKey(seat.getSeatType())) {
                screen.getSeatMap().get(seat.getSeatType()).add(seat);
            } else {
                screen.getSeatMap().put(seat.getSeatType(),new ArrayList<>(Arrays.asList(seat)));
            }
            int availableSeats = 0;
            if(screen.getAvailableSeats().containsKey(seat.getSeatType())) {
                availableSeats = screen.getAvailableSeats().get(seat.getSeatType()) + 1;
            } else {
                screen.getAvailableSeats().put(seat.getSeatType(),1);
            }
            screen.getAvailableSeats().put(seat.getSeatType(),availableSeats);
        });
        int totalSeats = screens.get(screenId).getTotalSeats() + seats.size();
        screens.get(screenId).setTotalSeats(totalSeats);
    }

    public List<Seat> getAvailableSeatsByType(int screenId, SeatType seatType) {
        return screens.get(screenId).getSeatMap().get(seatType).stream().filter(seat -> seat.getSeatStatus().equals(SeatStatus.AVAILABLE)).collect(Collectors.toList());
    }
}
