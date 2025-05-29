package commonLLDQuestions.foodOrdering.model;

import lombok.Data;

@Data
public class Location {

    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
