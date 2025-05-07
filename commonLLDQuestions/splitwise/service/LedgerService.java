package commonLLDQuestions.splitwise.service;

import commonLLDQuestions.splitwise.entities.Ledger;
import commonLLDQuestions.splitwise.repository.LedgerRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LedgerService {

    private LedgerRepository ledgerRepository;

    public LedgerService(){
        ledgerRepository = LedgerRepository.getInstance();
    }

    public void addLedger(Ledger ledger){
        ledgerRepository.addLedger(ledger);
    }

    public List<Ledger> getAllLedgerByUserId(int userId){
        List<Ledger> allLedgersAsCreditor = ledgerRepository.getLedgersWhereUserIsCreditor(userId);
        List<Ledger> allLedgersAsDebitor = ledgerRepository.getLedgersWhereUserIsDebitor(userId);
        List<Ledger> allLedgers = Stream.concat(allLedgersAsDebitor.stream(),allLedgersAsCreditor.stream()).collect(Collectors.toList());
        return allLedgers;
    }
}
