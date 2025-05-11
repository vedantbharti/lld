package commonLLDQuestions.bookMyShow.repository;

import commonLLDQuestions.bookMyShow.entities.Show;
import commonLLDQuestions.bookMyShow.entities.Theatre;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TheatreRepo {

    Map<Integer, Theatre> theatres;

    private TheatreRepo(){
        this.theatres = new HashMap<>();
    }

    private static class Initializer {
        private static final TheatreRepo INSTANCE = new TheatreRepo();
    }

    public static TheatreRepo getInstance() {
        return TheatreRepo.Initializer.INSTANCE;
    }

    public synchronized void addTheatre(Theatre theatre){
        theatres.put(theatre.getTheatreId(),theatre);
    }

    public synchronized void addShowToTheatre(int theatreId, Show show) {
        theatres.get(theatreId).getShows().add(show);
    }

    public List<Theatre> getAllTheatresByCity(String city){
        return theatres.values().stream().filter(theatre -> theatre.getCityName().equals(city)).collect(Collectors.toList());
    }
}
