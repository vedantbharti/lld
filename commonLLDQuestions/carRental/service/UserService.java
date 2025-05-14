package commonLLDQuestions.carRental.service;

import commonLLDQuestions.carRental.entities.User;
import commonLLDQuestions.carRental.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = UserRepository.getInstance();
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }
}
