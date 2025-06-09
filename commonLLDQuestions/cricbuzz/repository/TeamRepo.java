package commonLLDQuestions.cricbuzz.repository;

import commonLLDQuestions.cricbuzz.entity.Team;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TeamRepo {

    private Map<String, Team> teams;

    private TeamRepo(){
        this.teams = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final TeamRepo INSTANCE = new TeamRepo();
    }

    public static TeamRepo getInstance() {
        return Initializer.INSTANCE;
    }

    public void addTeam(Team team) {
        teams.put(team.getTeamId(),team);
    }

    public Team getTeamById(String teamId){
        return teams.get(teamId);
    }
}
