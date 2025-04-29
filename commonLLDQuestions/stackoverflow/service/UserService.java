package commonLLDQuestions.stackoverflow.service;

import commonLLDQuestions.stackoverflow.dao.User;
import commonLLDQuestions.stackoverflow.repositories.UserRepo;

public class UserService {

    UserRepo userRepo = UserRepo.getInstance();

    public void addUser(User user) {
        userRepo.addUser(user);
    }
}
