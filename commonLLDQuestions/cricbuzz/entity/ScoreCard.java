package commonLLDQuestions.cricbuzz.entity;

import commonLLDQuestions.cricbuzz.enums.WicketType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ScoreCard {

    private String scoreCardId;
    private String inningId;
    private String playerId;
    private int totalRunsScored;
    private int totalRunsGiven;
    private int totalWickets;
    private List<WicketType> wicketTypes;

    public ScoreCard(String inningId, String playerId) {
        this.scoreCardId = UUID.randomUUID().toString();
        this.inningId = inningId;
        this.playerId = playerId;
        this.totalRunsScored = 0;
        this.totalRunsGiven = 0;
        this.totalWickets = 0;
        this.wicketTypes = new ArrayList<>();
    }
}
