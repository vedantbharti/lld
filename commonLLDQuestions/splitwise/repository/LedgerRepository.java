package commonLLDQuestions.splitwise.repository;
import commonLLDQuestions.splitwise.entities.Ledger;

import java.util.HashMap;
import java.util.Map;

public class LedgerRepository {

    private Map<String, Ledger> ledgers;

    private LedgerRepository(){
        this.ledgers = new HashMap<>();
    }

    private static class InstanceHolder{
        private static final LedgerRepository INSTANCE = new LedgerRepository();
    }

    public static LedgerRepository getInstance(){
        return InstanceHolder.INSTANCE;
    }

    //TODO: CRUD operations

    public void addLedger(Ledger ledger) {
        ledgers.put(ledger.getLedgerId(),ledger);
    }

}
