package commonLLDQuestions.cricbuzz.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Team {

    private String teamId;
    private String teamName;
    private String country;
    private List<String> playingEleven;
    private List<String> players;

    public Team(String teamName, String country, List<String> players) {
        this.teamId = UUID.randomUUID().toString();
        this.teamName = teamName;
        this.country = country;
        this.players = players;
        this.playingEleven = new ArrayList<>();
    }
}
