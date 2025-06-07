package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.repository.PlayerRepo;

public class PlayerService {

    private PlayerRepo playerRepo;

    public PlayerService() {
        this.playerRepo = PlayerRepo.getInstance();
    }
}
