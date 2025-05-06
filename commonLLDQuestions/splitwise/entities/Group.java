package commonLLDQuestions.splitwise.entities;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private int groupId;
    private String groupName;
    private List<Integer> users;
    private List<Integer> expenses;


    public Group(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public int getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public List<Integer> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Integer> expenses) {
        this.expenses = expenses;
    }
}
