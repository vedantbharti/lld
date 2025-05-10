package commonLLDQuestions.splitwise.repository;

import commonLLDQuestions.splitwise.entities.Expense;
import commonLLDQuestions.splitwise.entities.User;
import commonLLDQuestions.splitwise.exceptions.UserNotFoundException;
import commonLLDQuestions.splitwise.models.UserBalanceSheet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    Map<Integer, User> users;

    private UserRepository(){
        users = new HashMap<>();
    }

    /*
    this is Bill-Pugh singleton initialization: lazy loading, no synchronization overhead, thread-safe
    * logic: class loading in java is lazy(only loaded when it's first accessed) and thread safe => JVM ensures this
    * Static inner class is not loaded until accessed
    * if two threads access get instance at the same time, since class loading in Java is thread safe, only
    * thread will be able to initialize InstanceHolder class, hence only instance created.
     */

    private static class InstanceHolder {
        private static  final UserRepository INSTANCE = new UserRepository();
    }

    public static UserRepository getInstance(){
        return InstanceHolder.INSTANCE;
    }

    // TODO: CRUD Operations as required

    public void addUser(User user){
        users.put(user.getUserId(), user);
    }

//    public synchronized void updateTotalOwed(int userId, double newOwedAmount) {
//        User user = users.get(userId);
//        double newAmount = user.getTotalOwed() + newOwedAmount;
//        user.setTotalOwed(newAmount);
//    }

    public User getUserById(int userId){
        return users.get(userId);
    }

    public synchronized void updateUserLedger(int userId, String ledgerId) {
        User user = users.get(userId);
        List<String> userLedger = user.getUserLedgers();
        userLedger.add(ledgerId);
    }

    public List<String> getUserLedger(int userId){
        return users.get(userId).getUserLedgers();
    }

    public UserBalanceSheet getBalanceSheet(int userId) {
        return users.get(userId).getUserBalanceSheet();
    }

    public synchronized void updateBalanceSheet(int creditorId, int debitorId, double amount) {
        double oldAmount = 0.0;
        if(users.get(creditorId).getUserBalanceSheet().getUserVsBalance().containsKey(debitorId)) {
            oldAmount = users.get(creditorId).getUserBalanceSheet().getUserVsBalance().get(debitorId);
        }
        users.get(creditorId).getUserBalanceSheet().getUserVsBalance().put(debitorId,oldAmount+amount);
        double oldAmountOwed = users.get(creditorId).getUserBalanceSheet().getAmountOwed();
        users.get(creditorId).getUserBalanceSheet().setAmountOwed(oldAmountOwed+amount);
    }

    public synchronized void addExpense(Expense expense) {
        users.get(expense.getPaidByUserId()).getExpenses().add(expense);
    }

    public List<Expense> getAllExpenses(int userId) {
        if(!users.containsKey(userId)){
            throw new UserNotFoundException("user with userId: " + userId + " is not in your friend list");
        }
        return users.get(userId).getExpenses();
    }

    public synchronized void removeUser(int userId){
        users.remove(userId);
    }

}
