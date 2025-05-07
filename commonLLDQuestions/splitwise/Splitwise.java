package commonLLDQuestions.splitwise;

import commonLLDQuestions.splitwise.entities.Expense;
import commonLLDQuestions.splitwise.entities.Group;
import commonLLDQuestions.splitwise.entities.User;
import commonLLDQuestions.splitwise.service.ExpenseService;
import commonLLDQuestions.splitwise.service.GroupService;
import commonLLDQuestions.splitwise.service.UserService;

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

        ExpenseService expenseService = new ExpenseService();
        expenseService.addExpense(nonGroupExpense);

        //for a user, fetch its BalanceSheet

//        LedgerService ledgerService = new LedgerService();
//        List<Ledger> ledgersForUserA = ledgerService.getAllLedgerByUserId(1);

        userService.getBalanceSheet(1);

        //settle balance between two users
        userService.settleBalance(1,2);

        //TODO: same as above, but for a group

        //create a group
        GroupService groupService = new GroupService();

        Group groupA = new Group(1,"GroupA");
        groupService.addGroup(groupA);

        // add users to the group
        groupService.addUsersToGroup(1, Arrays.asList(1,2,3));

        //TODO: refine code

    }
}
