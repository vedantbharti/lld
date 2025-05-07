package commonLLDQuestions.splitwise.service;

import commonLLDQuestions.splitwise.entities.User;
import commonLLDQuestions.splitwise.models.UserBalanceSheet;
import commonLLDQuestions.splitwise.repository.UserRepository;

import java.util.List;
import java.util.Map;

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

//    public synchronized void updateTotalOwed(int userId, double newOwedAmount) {
//        userRepository.updateTotalOwed(userId,newOwedAmount);
//    }

    public synchronized void updateUserLedger(int userId, String ledgerId) {
        userRepository.updateUserLedger(userId,ledgerId);
    }

    public UserBalanceSheet getBalanceSheet(int userId){
        return userRepository.getBalanceSheet(userId);
    }

    public synchronized void updateBalanceSheet(int creditorId, int debitorId, double amount) {
        userRepository.updateBalanceSheet(creditorId, debitorId,amount);
    }

    public synchronized void settleBalance(int userId, int settleWithId) {
        double amountToBeSettled = userRepository.getUserById(userId)
                .getUserBalanceSheet()
                .getUserVsBalance()
                .get(settleWithId);

        double amountOwed = userRepository.getUserById(userId)
                .getUserBalanceSheet()
                .getAmountOwed();

        amountOwed = amountOwed - amountToBeSettled;

        userRepository.getUserById(userId)
                .getUserBalanceSheet()
                .setAmountOwed(amountOwed);

        userRepository.getUserById(userId)
                .getUserBalanceSheet()
                .getUserVsBalance()
                .put(settleWithId,0.0);

    }
}
