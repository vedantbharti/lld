package commonLLDQuestions.cricbuzz.entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Inning {

    private String inningId;
    private String matchId;
    private String battingTeamId;
    private String bowlingTeamId;
    private int totalScore;
    private int totalWickets;
    private int totalOvers;
    private List<String> overIds;

    public Inning(String matchId, String battingTeamId, String bowlingTeamId) {
        this.inningId = UUID.randomUUID().toString();
        this.matchId = matchId;
        this.battingTeamId = battingTeamId;
        this.bowlingTeamId = bowlingTeamId;
        this.totalScore = 0;
        this.totalWickets = 0;
        this.overIds = new ArrayList<>();
    }
}
