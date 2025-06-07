package commonLLDQuestions.cricbuzz.entity;

import commonLLDQuestions.cricbuzz.enums.PlayerType;
import lombok.Data;

import java.util.UUID;

@Data
public class Player {

    private String playerId;
    private String playerName;
    private PlayerType playerType;
    private String country;
    private int totalScore;
    private int totalWickets;
    private int totalMatch;

    public Player(String playerName, PlayerType playerType, String country) {
        this.playerId = UUID.randomUUID().toString();
        this.playerName = playerName;
        this.playerType = playerType;
        this.country = country;
        this.totalMatch = 0;
        this.totalScore = 0;
        this.totalWickets = 0;
    }
}
