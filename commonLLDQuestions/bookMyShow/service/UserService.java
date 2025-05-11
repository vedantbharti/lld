package commonLLDQuestions.bookMyShow.service;

import commonLLDQuestions.bookMyShow.entities.User;
import commonLLDQuestions.bookMyShow.repository.UserRepo;

public class UserService {

    private UserRepo userRepo;

    public UserService() {
        this.userRepo = UserRepo.getInstance();
    }


    public void addUser(User user){
        userRepo.addUser(user);
    }
}
