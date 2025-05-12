package commonLLDQuestions.bookMyShow.enums;

public enum SeatType {

    REGULAR(200), PREMIUM(300), VIP(500);

    private final double price;

    SeatType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
