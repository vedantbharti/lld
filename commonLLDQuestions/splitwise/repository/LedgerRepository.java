package commonLLDQuestions.splitwise.repository;
import commonLLDQuestions.splitwise.entities.Ledger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Ledger> getLedgersWhereUserIsCreditor(int creditorId){
        List<Ledger> ledgersAsCreditor = ledgers.values().stream().filter(ledger -> ledger.getCreditorId()==creditorId).collect(Collectors.toList());
        return ledgersAsCreditor;
    }

    public List<Ledger> getLedgersWhereUserIsDebitor(int debitorId){
        List<Ledger> ledgersAsDebitor = ledgers.values().stream().filter(ledger -> ledger.getDebitorId()==debitorId).collect(Collectors.toList());
        return ledgersAsDebitor;
    }

}
