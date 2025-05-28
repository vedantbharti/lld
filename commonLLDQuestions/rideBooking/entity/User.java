package commonLLDQuestions.rideBooking.entity;

import commonLLDQuestions.rideBooking.enums.UserType;
import commonLLDQuestions.rideBooking.model.Location;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
public class User {

    private String userId;
    private String userName;
    private List<String> bookings;
    private UserType userType;
    private Location location;

    public User(){}

    public User(String userName, UserType userType) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.userType = userType;
        this.bookings = new ArrayList<>();
    }



}
