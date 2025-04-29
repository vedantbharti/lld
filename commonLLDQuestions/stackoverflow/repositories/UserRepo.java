package commonLLDQuestions.stackoverflow.repositories;

import commonLLDQuestions.stackoverflow.dao.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {

    Map<Integer, User> users;
    private static UserRepo userRepo;

    private UserRepo(){
        users = new HashMap<>();
    }

    public static synchronized UserRepo getInstance(){
        if(userRepo==null) {
            userRepo = new UserRepo();
        }

        return userRepo;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
        return;
    }

    public User getUser(int userId){
        return users.get(userId);
    }
}
