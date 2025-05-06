package commonLLDQuestions.splitwise.entities;

import java.util.List;
import java.util.Map;

public class GroupExpense extends Expense{

    private int groupId;

    public GroupExpense(int groupId, int expenseId, int paidByUserId, int amount, Map<Integer,Double> expenseDistribution) {

        super(expenseId, paidByUserId, amount, expenseDistribution);
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
