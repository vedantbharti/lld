package commonLLDQuestions.splitwise.service;

import commonLLDQuestions.splitwise.entities.Expense;
import commonLLDQuestions.splitwise.entities.Group;
import commonLLDQuestions.splitwise.entities.User;
import commonLLDQuestions.splitwise.repository.GroupRepository;
import commonLLDQuestions.splitwise.repository.UserRepository;

import java.util.List;
import java.util.Map;

public class GroupService {

    private GroupRepository groupRepository;
    private UserService userService;

    public GroupService(){
        this.groupRepository = GroupRepository.getInstance();
    }

    public void addGroup(Group group){
        groupRepository.addGroup(group);
    }

    public Group getGroupById(int groupId){
        return groupRepository.getGroupById(groupId);
    }

    public synchronized void addUsersToGroup(int groupId, List<Integer> userIds){
        groupRepository.addUsersToGroup(groupId,userIds);
    }

    public List<Integer> getAllUsers(int groupId) {
        return groupRepository.getAllUsers(groupId);
    }

    public synchronized void addExpense(int groupId, Expense expense){
        groupRepository.addExpense(groupId, expense);
    }

    public List<Expense> getExpenses(int groupId) {
        return groupRepository.getExpenses(groupId);
    }
}
