package commonLLDQuestions.splitwise.repository;

import commonLLDQuestions.splitwise.entities.Expense;

import java.util.HashMap;
import java.util.Map;

public class ExpenseRepository {

    private Map<Integer, Expense> expenses;

    private ExpenseRepository() {
        this.expenses = new HashMap<>();
    }

    private static class InstanceHolder {
        private static final ExpenseRepository INSTANCE = new ExpenseRepository();
    }

    public static ExpenseRepository getInstance() {
        return InstanceHolder.INSTANCE;
    }

    //TODO: CRUD operations


    public void addExpense(Expense expense){
        expenses.put(expense.getExpenseId(), expense);
    }

}
