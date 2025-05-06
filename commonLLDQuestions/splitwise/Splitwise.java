package commonLLDQuestions.splitwise;

import commonLLDQuestions.splitwise.entities.Expense;
import commonLLDQuestions.splitwise.entities.Group;
import commonLLDQuestions.splitwise.entities.NonGroupExpense;
import commonLLDQuestions.splitwise.entities.User;
import commonLLDQuestions.splitwise.service.ExpenseService;
import commonLLDQuestions.splitwise.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Splitwise {

    public static void main(String[] args) {

        //create users
        User userA = new User(1, "A");
        User userB = new User(2, "B");
        User userC = new User(3, "C");

        UserService userService = new UserService();

        //add users
        userService.addUser(userA);
        userService.addUser(userB);
        userService.addUser(userC);

        // create and add expense logic
        Map<Integer,Double> expenseDistribution = new HashMap<>();
        expenseDistribution.put(1,25.0);
        expenseDistribution.put(2,25.0);
        expenseDistribution.put(3,50.0);

        Expense nonGroupExpense = new NonGroupExpense(1, 1, Arrays.asList(1,2,3), 100, expenseDistribution);

        ExpenseService expenseService = new ExpenseService();
        expenseService.addExpense(nonGroupExpense);

        //TODO: for a user, fetch its ledger

        //TODO: same as above, but for a group

        //TODO: refine code

    }
}
