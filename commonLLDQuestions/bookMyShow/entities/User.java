package commonLLDQuestions.bookMyShow.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int userId;
    private String userName;
    private List<Ticket> tickets;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.tickets = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
