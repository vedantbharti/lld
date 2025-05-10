package commonLLDQuestions.splitwise;

import commonLLDQuestions.splitwise.entities.Expense;
import commonLLDQuestions.splitwise.entities.Group;
import commonLLDQuestions.splitwise.entities.User;
import commonLLDQuestions.splitwise.exceptions.UserNotFoundException;
import commonLLDQuestions.splitwise.models.UserBalanceSheet;
import commonLLDQuestions.splitwise.service.ExpenseService;
import commonLLDQuestions.splitwise.service.GroupService;
import commonLLDQuestions.splitwise.service.UserService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        /*
        *NOTE: Don't think there is a need to write different split logic separately.
        * When we add expense, if there is an equal split specified, we just split the amounts equally here only
        * and add to expense distribution
        */

        Map<Integer,Double> expenseDistribution = new HashMap<>();
        expenseDistribution.put(1,25.0);
        expenseDistribution.put(2,25.0);
        expenseDistribution.put(3,50.0);

        Expense nonGroupExpense = new Expense(1, 1, Arrays.asList(1,2,3), 100, expenseDistribution);

        //to maintain the paying user's expense list
        userService.addExpense(nonGroupExpense);

        //to maintain all the expenses, basically a database of expenses
        ExpenseService expenseService = new ExpenseService();
        expenseService.addExpense(nonGroupExpense);

        //for a user, fetch its BalanceSheet

        List<Expense> allExpensesForUser1 = userService.getAllExpenses(1);
        allExpensesForUser1.stream().forEach(expense -> {
            System.out.println("expense for expense Id: " + expense.getExpenseId() + " is: " + expense.getAmount()
             + " and is paid by user Id: " + expense.getPaidByUserId());
        });

        System.out.println();

        try {
            List<Expense> allExpensesForUser2 = userService.getAllExpenses(4);
            allExpensesForUser1.stream().forEach(expense -> {
                System.out.println("expense for expense Id: " + expense.getExpenseId() + " is: " + expense.getAmount()
                        + " and is paid by user Id: " + expense.getPaidByUserId());
            });
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        UserBalanceSheet balanceSheet1 = userService.getBalanceSheet(1);
        System.out.println("for the user with userId 1, balance sheet is as below: ");
        balanceSheet1.getUserVsBalance().entrySet().stream().forEach(entry -> {
            if(entry.getValue()<0){
                System.out.println("you owe user with userId: " + entry.getKey() + " an amount of " + entry.getValue());
            } else if(entry.getValue()>0){
                System.out.println("you are owed from userId: " + entry.getKey() + " an amount of " + entry.getValue());
            } else {
                System.out.println("All settled up with userId: " + entry.getKey());
            }
        });

        System.out.println();

        UserBalanceSheet balanceSheet2 = userService.getBalanceSheet(2);
        System.out.println("for the user with userId 2, balance sheet is as below: ");
        balanceSheet2.getUserVsBalance().entrySet().stream().forEach(entry -> {
            if(entry.getValue()<0){
                System.out.println("you owe user with userId: " + entry.getKey() + " an amount of " + entry.getValue());
            } else if(entry.getValue()>0){
                System.out.println("you are owed from userId: " + entry.getKey() + " an amount of " + entry.getValue());
            } else {
                System.out.println("All settled up with userId: " + entry.getKey());
            }
        });

        System.out.println();

        //settle balance between two users
        userService.settleBalance(1,2);

        UserBalanceSheet newBalanceSheet1 = userService.getBalanceSheet(1);
        System.out.println("for the user with userId 1, balance sheet is as below: ");
        newBalanceSheet1.getUserVsBalance().entrySet().stream().forEach(entry -> {
            if(entry.getValue()<0){
                System.out.println("you owe user with userId: " + entry.getKey() + " an amount of " + entry.getValue());
            } else if(entry.getValue()>0){
                System.out.println("you are owed from userId: " + entry.getKey() + " an amount of " + entry.getValue());
            } else {
                System.out.println("All settled up with userId: " + entry.getKey());
            }
        });

        //same as above, but for a group

        //create a group
        GroupService groupService = new GroupService();

        Group groupA = new Group(1,"GroupA");
        groupService.addGroup(groupA);

        // add users to the group
        groupService.addUsersToGroup(1, Arrays.asList(1,2,3));

        // get all the users from the group and set expense distribution for them
        List<Integer> userIds = groupService.getAllUsers(1);

        //custom: add the logic to add expense for each user and also validate if each one's contribution sums to total
        //for now, I am skipping it

        Map<Integer,Double> groupExpenseDistribution = new HashMap<>();
        groupExpenseDistribution.put(1,25.0);
        groupExpenseDistribution.put(2,25.0);
        groupExpenseDistribution.put(3,50.0);

        Expense groupExpense = new Expense(2, 1, Arrays.asList(1,2,3), 100, groupExpenseDistribution);

        groupService.addExpense(1,groupExpense);

        //when you add expense, make sure to update each user's balance sheet
        //here addExpense handles that for both group and non-group
        expenseService.addExpense(groupExpense);

        System.out.println();

        List<Expense> expenses = groupService.getExpenses(1);
        expenses.stream().forEach(expense -> System.out.println("Expense for expense Id: " + expense.getExpenseId()
         + " is: " + expense.getAmount() + " and is paid by: " + expense.getPaidByUserId()));

        System.out.println();

        System.out.println("for the user with userId 1, balance sheet is as below: ");
        userService.getBalanceSheet(1).getUserVsBalance().entrySet().stream().forEach(entry -> {
            if(entry.getValue()<0){
                System.out.println("you owe user with userId: " + entry.getKey() + " an amount of " + entry.getValue());
            } else if(entry.getValue()>0){
                System.out.println("you are owed from userId: " + entry.getKey() + " an amount of " + entry.getValue());
            } else {
                System.out.println("All settled up with userId: " + entry.getKey());
            }
        });

        //we can have a feature of settling up group expenses
        //for each group member, we can pull up what is the current user's balance sheet corresponding to other members
        //for now skipping that feature

        //not implementing notification features...that will be unnecessary for now.

        //Added one exception for understanding purpose...can be added many more for best implementation.

    }
}
