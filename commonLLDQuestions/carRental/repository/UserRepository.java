package commonLLDQuestions.carRental.repository;

import commonLLDQuestions.carRental.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    Map<Integer, User> users;

    private UserRepository() {
        users = new HashMap<>();
    }

    private static class Initializer {
        public static final UserRepository INSTANCE = new UserRepository();
    }

    public static UserRepository getInstance() {
        return Initializer.INSTANCE;
    }

    public void addUser(User user) {
        users.put(user.getUserId(),user);
    }
}
