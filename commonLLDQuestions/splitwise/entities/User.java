package commonLLDQuestions.splitwise.entities;

public class User {

    private int userId;
    private String userName;
    private double totalOwed;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.totalOwed = 0;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotalOwed() {
        return totalOwed;
    }

    public void setTotalOwed(double totalOwed) {
        this.totalOwed = totalOwed;
    }
}
