package commonLLDQuestions.rideBooking.entity;

import commonLLDQuestions.rideBooking.enums.UserType;
import lombok.Data;


@Data
public class Customer extends User{

    public Customer(int userId, String userName, UserType userType) {
        super(userId, userName, userType);
    }
}
