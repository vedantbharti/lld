package commonLLDQuestions.splitwise.service;

import commonLLDQuestions.splitwise.entities.Expense;
import commonLLDQuestions.splitwise.entities.Ledger;
import commonLLDQuestions.splitwise.entities.User;
import commonLLDQuestions.splitwise.repository.ExpenseRepository;

import java.util.List;

public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(){
        this.expenseRepository = ExpenseRepository.getInstance();
    }

    public synchronized void addExpense(Expense expense) {
        expenseRepository.addExpense(expense);

        UserService userService = new UserService();

        List<Integer> userIds = expense.getInvolvedUserIds();

        userIds.stream().forEach(userId -> {

            if(userId!=expense.getPaidByUserId()) {
                double amount = expense.getExpenseDistribution().get(userId);
                //update balance sheet for creditor
                userService.updateBalanceSheet(expense.getPaidByUserId(), userId, amount);

                //update balance sheet for debitor
                userService.updateBalanceSheet(userId, expense.getExpenseId(), 0-amount);
            }
        });
    }

}
