package commonLLDQuestions.rideBooking.entity;

import commonLLDQuestions.rideBooking.enums.UserType;
import commonLLDQuestions.rideBooking.model.Location;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
public class User {

    private int userId;
    private String userName;
    private List<Integer> bookings;
    private UserType userType;
    private Location location;

    public User(){}

    public User(int userId, String userName, UserType userType) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.bookings = new ArrayList<>();
    }



}
