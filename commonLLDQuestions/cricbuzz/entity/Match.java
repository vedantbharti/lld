package commonLLDQuestions.cricbuzz.entity;


import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Match {

   private String matchId;
   private String matchName;
   private String stadiumName;
   private Date startTime;
   private String winningTeamId;
   private String manOfTheMatch;

   public Match(String matchName, String stadiumName, Date startTime) {
       this.matchId = UUID.randomUUID().toString();
       this.matchName = matchName;
       this.stadiumName = stadiumName;
       this.startTime = startTime;
       this.winningTeamId = null;
       this.manOfTheMatch = null;
   }
}
