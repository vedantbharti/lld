package commonLLDQuestions.splitwise.entities;

import commonLLDQuestions.splitwise.models.UserBalanceSheet;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int userId;
    private String userName;
//    private double totalOwed;
    List<String> userLedgers;
    UserBalanceSheet userBalanceSheet;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
//        this.totalOwed = 0;
        this.userLedgers = new ArrayList<>();
        this.userBalanceSheet = new UserBalanceSheet();
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

//    public double getTotalOwed() {
//        return totalOwed;
//    }
//
//    public void setTotalOwed(double totalOwed) {
//        this.totalOwed = totalOwed;
//    }

    public List<String> getUserLedgers() {
        return userLedgers;
    }

    public void setUserLedgers(List<String> userLedgers) {
        this.userLedgers = userLedgers;
    }

    public UserBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }

    public void setUserBalanceSheet(UserBalanceSheet userBalanceSheet) {
        this.userBalanceSheet = userBalanceSheet;
    }
}
