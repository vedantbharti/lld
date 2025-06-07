package commonLLDQuestions.cricbuzz.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ScoreCard {

    private String scoreCardId;
    private String inningId;
    private String playerId;
    private int totalScore;
    private int totalWickets;

    public ScoreCard(String inningId, String playerId) {
        this.scoreCardId = UUID.randomUUID().toString();
        this.inningId = inningId;
        this.playerId = playerId;
        this.totalScore = 0;
        this.totalWickets = 0;
    }
}
