package commonLLDQuestions.bookMyShow;

import commonLLDQuestions.bookMyShow.enums.SeatStatus;
import commonLLDQuestions.bookMyShow.enums.SeatType;
import commonLLDQuestions.bookMyShow.models.Movie;
import commonLLDQuestions.bookMyShow.entities.Show;
import commonLLDQuestions.bookMyShow.entities.Theatre;
import commonLLDQuestions.bookMyShow.entities.User;
import commonLLDQuestions.bookMyShow.entities.Screen;
import commonLLDQuestions.bookMyShow.models.Seat;
import commonLLDQuestions.bookMyShow.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookMyShow {

    public static void main(String[] args) {

        UserService userService = new UserService();
        ShowService showService = new ShowService();
        TheatreService theatreService = new TheatreService();
        ScreenService screenService = new ScreenService();
        TicketService ticketService = new TicketService();



        //create user
        User user = new User(1, "User1");
        userService.addUser(user);

        //create seats
        Seat seat1 = new Seat(1,SeatType.REGULAR);
        Seat seat2 = new Seat(2,SeatType.REGULAR);
        Seat seat3 = new Seat(3,SeatType.PREMIUM);
        Seat seat4 = new Seat(4,SeatType.PREMIUM);
        Seat seat5 = new Seat(5,SeatType.VIP);

        List<Seat> seats = new ArrayList<>(Arrays.asList(seat1,seat2,seat3,seat4,seat5));


        //create screens
        Screen screen1 = new Screen(1,1,5);
        Screen screen2 = new Screen(2, 2,5);

        //add screens
        screenService.addScreen(screen1);
        screenService.addScreen(screen2);

        //add seats to screens
        screenService.addSeatsForScreenId(1, seats);

        //create theatre
        Theatre theatre1 = new Theatre(1,"Theatre1","Bangalore", Arrays.asList(screen1,screen2));

        //add theatre to repo
        theatreService.addTheatre(theatre1);

        //create a movie
        Movie movie1 = new Movie("A","2");
        Movie movie2 = new Movie("B","2");
        Movie movie3 = new Movie("C","2");

        //create show
        Show show1 = new Show(1,movie1,"1200","0200",screen1);
        Show show2 = new Show(2,movie2,"1200","0200",screen2);

        //add show to the theatre
        theatreService.addShowToTheatre(1,show1);
        theatreService.addShowToTheatre(1,show2);

        //add shows
        showService.addShow(show1);
        showService.addShow(show2);

        //get all movies in a city
        List<Theatre> theatresByCity = theatreService.getAllTheatresByCity("Bangalore");
        List<Movie> moviesInBangalore = theatresByCity.stream().
                map(theatre -> theatre.getShows()).
                flatMap(shows ->shows.stream()).
                map(show -> show.getMovie())
                .collect(Collectors.toList());

        //print all the movies for a city
        moviesInBangalore.stream().forEach(movie -> System.out.println(movie.getMovieName()));

        System.out.println();
        //based on a movie, find all shows in the city
        List<Show> showsForMovie = theatresByCity.stream().map(theatre -> theatre.getShows().stream().filter(show -> show.getMovie().getMovieName().equals("A")).collect(Collectors.toList())).flatMap(list ->list.stream()).collect(Collectors.toList());
        showsForMovie.stream().forEach(show -> System.out.println(show.getMovie().getMovieName()));

        //for a particular show, select seats
        Screen screen = showService.getScreenForShowId(1);

        List<Seat> availableSeats = screenService.getAvailableSeatsByType(screen.getScreenId(), SeatType.REGULAR);

        availableSeats.stream().forEach(seat -> System.out.println(seat.getSeatNumber() + " " + seat.getSeatType() + " " + seat.getSeatStatus()));

        //select seat and update seat map

    }
}
