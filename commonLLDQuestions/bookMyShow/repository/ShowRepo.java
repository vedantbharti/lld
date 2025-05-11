package commonLLDQuestions.bookMyShow.repository;

import commonLLDQuestions.bookMyShow.entities.Screen;
import commonLLDQuestions.bookMyShow.entities.Show;

import java.util.HashMap;
import java.util.Map;

public class ShowRepo {

    Map<Integer, Show> shows;

    private ShowRepo(){
        this.shows = new HashMap<>();
    }

    private static class Initializer {
        private static final ShowRepo INSTANCE = new ShowRepo();
    }

    public static ShowRepo getInstance() {
        return ShowRepo.Initializer.INSTANCE;
    }

    public synchronized void addShow(Show show){
        shows.put(show.getShowId(),show);
    }

    public Screen getScreenForShowId(int showId) {
        return shows.get(showId).getScreen();
    }
}
