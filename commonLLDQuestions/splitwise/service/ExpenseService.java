package commonLLDQuestions.splitwise.service;

import commonLLDQuestions.splitwise.entities.Expense;
import commonLLDQuestions.splitwise.entities.Ledger;
import commonLLDQuestions.splitwise.entities.NonGroupExpense;
import commonLLDQuestions.splitwise.entities.User;
import commonLLDQuestions.splitwise.repository.ExpenseRepository;

import java.util.List;
import java.util.UUID;

public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(){
        this.expenseRepository = ExpenseRepository.getInstance();
    }

    public void addExpense(Expense expense){
        expenseRepository.addExpense(expense);
        LedgerService ledgerService = new LedgerService();
        UserService userService = new UserService();

        if(expense instanceof NonGroupExpense) {
            //TODO: some logic here for updating ledger

            List<Integer> userIds = ((NonGroupExpense) expense).getInvolvedUserIds();
            userIds.stream().forEach(userId -> {
                if(userId!= expense.getExpenseId()){
                    double amount = expense.getExpenseDistribution().get(userId);
                    Ledger ledger = new Ledger(expense.getPaidByUserId(),userId,amount);
                    ledgerService.addLedger(ledger);
                    userService.updateTotalOwed(userId,0-amount);
                    userService.updateTotalOwed(expense.getPaidByUserId(),amount);
                }
            });
        } else {
            //TODO: some logic here for updating ledger
        }
    }
}
