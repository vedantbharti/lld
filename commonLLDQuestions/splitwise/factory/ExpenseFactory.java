package commonLLDQuestions.splitwise.factory;

import commonLLDQuestions.splitwise.entities.Expense;

public class ExpenseFactory {

    private Expense expense;

    private ExpenseFactory(){}

    private static class InstanceHolder {
        private static ExpenseFactory INSTANCE = new ExpenseFactory();
    }

    public static ExpenseFactory getInstance(){
        return InstanceHolder.INSTANCE;
    }

//    public Expense getExpenseObject(ExpenseType expenseType){
//        switch (expenseType){
//            case GROUP_EXPENSE :
//                return new GroupExpense()
//        }
//    }
}
