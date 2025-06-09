package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.entity.Player;
import commonLLDQuestions.cricbuzz.entity.Team;
import commonLLDQuestions.cricbuzz.repository.TeamRepo;

import java.util.List;

public class TeamService {

    private TeamRepo teamRepo;

    public TeamService(){
        this.teamRepo = TeamRepo.getInstance();
    }

    public void createTeam(Team team) {
        teamRepo.addTeam(team);
    }

    public void updatePlayingEleven(String teamId, List<String> playingEleven) {
        Team team = teamRepo.getTeamById(teamId);
        List<String> currPlayingEleven = team.getPlayingEleven();
        currPlayingEleven.addAll(playingEleven);
    }

    public void addPlayerToPlayingEleven(String teamId, String playerId) {
        //do your own impl
    }

    public void removePlayerFromPlayingEleven(String teamId, String playerId) {
        // do your own impl
    }
}
