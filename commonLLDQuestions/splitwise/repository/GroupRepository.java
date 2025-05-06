package commonLLDQuestions.splitwise.repository;

import commonLLDQuestions.splitwise.entities.Group;

import java.util.HashMap;
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


}
