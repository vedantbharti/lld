package commonLLDQuestions.bookMyShow.entities;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private int theatreId;
    private String theatreName;
    private List<Show> shows;
    private List<Screen> screens;
    private String cityName;


    public Theatre(int theatreId, String theatreName, String cityName, List<Screen> screens) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.cityName = cityName;
        this.screens = screens;
        this.shows = new ArrayList<>();
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
