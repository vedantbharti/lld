package commonLLDQuestions.bookMyShow.service;

import commonLLDQuestions.bookMyShow.entities.Show;
import commonLLDQuestions.bookMyShow.entities.Theatre;
import commonLLDQuestions.bookMyShow.repository.TheatreRepo;

import java.util.List;

public class TheatreService {

    private TheatreRepo theatreRepo;

    public TheatreService() {
        this.theatreRepo = TheatreRepo.getInstance();
    }

    public synchronized void addTheatre(Theatre theatre) {
        theatreRepo.addTheatre(theatre);
    }

    public synchronized void addShowToTheatre(int theatreId, Show show){
        theatreRepo.addShowToTheatre(theatreId,show);
    }

    public List<Theatre> getAllTheatresByCity(String city) {
        return theatreRepo.getAllTheatresByCity(city);
    }
}
