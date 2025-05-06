package commonLLDQuestions.splitwise.service;

import commonLLDQuestions.splitwise.entities.Ledger;
import commonLLDQuestions.splitwise.repository.LedgerRepository;

public class LedgerService {

    private LedgerRepository ledgerRepository;

    public LedgerService(){
        ledgerRepository = LedgerRepository.getInstance();
    }

    public void addLedger(Ledger ledger){
        ledgerRepository.addLedger(ledger);
    }
}
