package commonLLDQuestions.rideBooking.enums;

public enum VehicleType {

    BIKE(10), AUTO(15), CAB(20);

    private final int pricePerKm;

    VehicleType(int pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public int getPricePerKm(){
        return this.pricePerKm;
    }
}
