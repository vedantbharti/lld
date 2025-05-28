package commonLLDQuestions.rideBooking.entity;

import commonLLDQuestions.rideBooking.enums.UserType;
import lombok.Data;


@Data
public class Driver extends User{

    private boolean isAvailable;
    private String vehicleNo;

    public Driver(String userName, UserType userType) {
        super(userName, userType);
        this.isAvailable = true;
        this.vehicleNo = "";
    }


}
