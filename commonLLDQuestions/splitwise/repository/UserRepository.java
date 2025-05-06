package commonLLDQuestions.splitwise.repository;

import commonLLDQuestions.splitwise.entities.User;

import java.util.HashMap;
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

    public synchronized void updateTotalOwed(int userId, double newOwedAmount) {
        User user = users.get(userId);
        double newAmount = user.getTotalOwed() + newOwedAmount;
        user.setTotalOwed(newAmount);
    }

    public User getUserById(int userId){
        return users.get(userId);
    }
}
