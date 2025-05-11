package commonLLDQuestions.bookMyShow.repository;

import commonLLDQuestions.bookMyShow.entities.User;


import java.util.HashMap;
import java.util.Map;

public class UserRepo {

    Map<Integer, User> users;

    private UserRepo(){
        this.users = new HashMap<>();
    }

    private static class Initializer {
        private static final UserRepo INSTANCE = new UserRepo();
    }

    public static UserRepo getInstance() {
        return UserRepo.Initializer.INSTANCE;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }
}
