package commonLLDQuestions.splitwise.repository;

import commonLLDQuestions.splitwise.entities.Group;
import commonLLDQuestions.splitwise.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository {

    private Map<Integer, Group> groups;

    private GroupRepository(){
        this.groups = new HashMap<>();
    }

    private static class InstanceHolder{
        private static final GroupRepository INSTANCE = new GroupRepository();
    }

    public static GroupRepository getInstance(){
        return InstanceHolder.INSTANCE;
    }

    //TODO: CRUD operations

    public void addGroup(Group group){
        groups.put(group.getGroupId(),group);
    }

    public Group getGroupById(int groupId){
        return groups.get(groupId);
    }

    public synchronized void addUsersToGroup(int groupId, List<Integer> userIds){
        Group group = groups.get(groupId);
        List<Integer> users = group.getUsers();
        users.addAll(userIds);
    }

}
