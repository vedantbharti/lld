package commonLLDQuestions.bookMyShow.service;

import commonLLDQuestions.bookMyShow.entities.Screen;
import commonLLDQuestions.bookMyShow.entities.Show;
import commonLLDQuestions.bookMyShow.repository.ShowRepo;

public class ShowService {

    private ShowRepo showRepo;

    public ShowService() {
        this.showRepo = ShowRepo.getInstance();
    }

    public synchronized void addShow(Show show) {
        showRepo.addShow(show);
    }

    public Screen getScreenForShowId(int showId){
        return showRepo.getScreenForShowId(showId);
    }
}
