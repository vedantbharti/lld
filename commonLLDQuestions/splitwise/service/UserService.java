package commonLLDQuestions.splitwise.service;

import commonLLDQuestions.splitwise.entities.User;
import commonLLDQuestions.splitwise.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(){
        this.userRepository = UserRepository.getInstance();
    }

    public void addUser(User user){
        userRepository.addUser(user);
    }

    public User getUserById(int userId){
        return userRepository.getUserById(userId);
    }

    public synchronized void updateTotalOwed(int userId, double newOwedAmount) {
        userRepository.updateTotalOwed(userId,newOwedAmount);
    }
}
