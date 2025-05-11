package commonLLDQuestions.bookMyShow.models;

public class Movie {

    private String movieName;
    private String runtime;
    private int rating;

    public Movie(String movieName, String runtime) {
        this.movieName = movieName;
        this.runtime = runtime;
        this.rating = 0;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
