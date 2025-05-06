package commonLLDQuestions.splitwise.entities;

import java.util.List;
import java.util.Map;

public class NonGroupExpense extends Expense{

    private List<Integer> involvedUserIds;


    public NonGroupExpense(int expenseId, int paidByUserId, List<Integer> involvedUserIds, int amount, Map<Integer,Double> expenseDistribution) {
        super(expenseId, paidByUserId, amount, expenseDistribution);

        this.involvedUserIds = involvedUserIds;

    }

    public List<Integer> getInvolvedUserIds() {
        return involvedUserIds;
    }

    public void setInvolvedUserIds(List<Integer> involvedUserIds) {
        this.involvedUserIds = involvedUserIds;
    }
}
