package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.repository.TeamRepo;

public class TeamService {

    private TeamRepo teamRepo;

    public TeamService(){
        this.teamRepo = TeamRepo.getInstance();
    }
}
