package commonLLDQuestions.splitwise.service;

import commonLLDQuestions.splitwise.entities.Group;
import commonLLDQuestions.splitwise.entities.User;
import commonLLDQuestions.splitwise.repository.GroupRepository;
import commonLLDQuestions.splitwise.repository.UserRepository;

import java.util.List;

public class GroupService {

    private GroupRepository groupRepository;

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
}
