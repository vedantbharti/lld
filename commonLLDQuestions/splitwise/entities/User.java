package commonLLDQuestions.splitwise.entities;

import commonLLDQuestions.splitwise.models.UserBalanceSheet;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int userId;
    private String userName;
    private List<Expense> expenses;
    private UserBalanceSheet userBalanceSheet;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.expenses = new ArrayList<>();
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

    public UserBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }

    public void setUserBalanceSheet(UserBalanceSheet userBalanceSheet) {
        this.userBalanceSheet = userBalanceSheet;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
