package commonLLDQuestions.cricbuzz;

import commonLLDQuestions.cricbuzz.entity.*;
import commonLLDQuestions.cricbuzz.enums.BowlType;
import commonLLDQuestions.cricbuzz.enums.PlayerType;
import commonLLDQuestions.cricbuzz.enums.WicketType;
import commonLLDQuestions.cricbuzz.service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cricbuzz {

    private static BowlService bowlService;
    private static InningService inningService;
    private static MatchService matchService;
    private static OverService overService;
    private static PlayerService playerService;
    private static ScoreCardService bowlerScoreCardService;
    private static ScoreCardService batsmanScoreCardService;
    private static TeamService teamService;
    private static ScoreUpdaterService scoreUpdaterService;

    private static void initialize() {
        bowlService = new BowlService();
        inningService = new InningService();
        matchService = new MatchService();
        overService = new OverService();
        playerService = new PlayerService();
        bowlerScoreCardService = new BowlerScoreCardService();
        batsmanScoreCardService = new BatsmanScoreCardService();
        teamService = new TeamService();
        scoreUpdaterService = new ScoreUpdaterService();
    }

    public static void main(String[] args) {

        initialize();

        //create Players for India
        Player indianPlayer1 = new Player("indianPlayer1", PlayerType.RIGHT_HANDED_BATSMAN, "India");
        Player indianPlayer2 = new Player("indianPlayer2", PlayerType.LEFT_HANDED_BATSMAN, "India");
        Player indianPlayer3 = new Player("indianPlayer3", PlayerType.RIGHT_HANDED_BATSMAN, "India");
        Player indianPlayer4 = new Player("indianPlayer4", PlayerType.LEFT_HANDED_BATSMAN, "India");
        Player indianPlayer5 = new Player("indianPlayer5", PlayerType.RIGHT_HANDED_BATSMAN, "India");
        Player indianPlayer6 = new Player("indianPlayer6", PlayerType.LEFT_HANDED_BATSMAN, "India");
        Player indianPlayer7 = new Player("indianPlayer7", PlayerType.BATTING_ALLROUNDER, "India");
        Player indianPlayer8 = new Player("indianPlayer8", PlayerType.BOWLING_ALLROUNDER, "India");
        Player indianPlayer9 = new Player("indianPlayer9", PlayerType.RIGHT_ARM_BOWLER, "India");
        Player indianPlayer10 = new Player("indianPlayer10", PlayerType.RIGHT_ARM_BOWLER, "India");
        Player indianPlayer11 = new Player("indianPlayer11", PlayerType.LEFT_ARM_BOWLER, "India");
        Player indianPlayer12 = new Player("indianPlayer12", PlayerType.RIGHT_ARM_BOWLER, "India");
        Player indianPlayer13 = new Player("indianPlayer13", PlayerType.RIGHT_HANDED_BATSMAN, "India");
        Player indianPlayer14 = new Player("indianPlayer14", PlayerType.RIGHT_HANDED_BATSMAN, "India");
        Player indianPlayer15 = new Player("indianPlayer15", PlayerType.LEFT_HANDED_BATSMAN, "India");

        //create players for Australia
        Player australianPlayer1 = new Player("australianPlayer1", PlayerType.RIGHT_HANDED_BATSMAN, "Australia");
        Player australianPlayer2 = new Player("australianPlayer2", PlayerType.LEFT_HANDED_BATSMAN, "Australia");
        Player australianPlayer3 = new Player("australianPlayer3", PlayerType.RIGHT_HANDED_BATSMAN, "Australia");
        Player australianPlayer4 = new Player("australianPlayer4", PlayerType.RIGHT_HANDED_BATSMAN, "Australia");
        Player australianPlayer5 = new Player("australianPlayer5", PlayerType.RIGHT_HANDED_BATSMAN, "Australia");
        Player australianPlayer6 = new Player("australianPlayer6", PlayerType.LEFT_HANDED_BATSMAN, "Australia");
        Player australianPlayer7 = new Player("australianPlayer7", PlayerType.RIGHT_HANDED_BATSMAN, "Australia");
        Player australianPlayer8 = new Player("australianPlayer8", PlayerType.LEFT_ARM_BOWLER, "Australia");
        Player australianPlayer9 = new Player("australianPlayer9", PlayerType.RIGHT_ARM_BOWLER, "Australia");
        Player australianPlayer10 = new Player("australianPlayer10", PlayerType.RIGHT_ARM_BOWLER, "Australia");
        Player australianPlayer11 = new Player("australianPlayer11", PlayerType.RIGHT_ARM_BOWLER, "Australia");
        Player australianPlayer12 = new Player("australianPlayer12", PlayerType.BATTING_ALLROUNDER, "Australia");
        Player australianPlayer13 = new Player("australianPlayer13", PlayerType.BATTING_ALLROUNDER, "Australia");
        Player australianPlayer14 = new Player("australianPlayer14", PlayerType.BATTING_ALLROUNDER, "Australia");
        Player australianPlayer15 = new Player("australianPlayer15", PlayerType.LEFT_ARM_BOWLER, "Australia");

        playerService.addPlayer(indianPlayer1);
        playerService.addPlayer(indianPlayer2);
        playerService.addPlayer(indianPlayer3);
        playerService.addPlayer(indianPlayer4);
        playerService.addPlayer(indianPlayer5);
        playerService.addPlayer(indianPlayer6);
        playerService.addPlayer(indianPlayer7);
        playerService.addPlayer(indianPlayer8);
        playerService.addPlayer(indianPlayer9);
        playerService.addPlayer(indianPlayer10);
        playerService.addPlayer(indianPlayer11);
        playerService.addPlayer(indianPlayer12);
        playerService.addPlayer(indianPlayer13);
        playerService.addPlayer(indianPlayer14);
        playerService.addPlayer(indianPlayer15);

        playerService.addPlayer(australianPlayer1);
        playerService.addPlayer(australianPlayer2);
        playerService.addPlayer(australianPlayer3);
        playerService.addPlayer(australianPlayer4);
        playerService.addPlayer(australianPlayer5);
        playerService.addPlayer(australianPlayer6);
        playerService.addPlayer(australianPlayer7);
        playerService.addPlayer(australianPlayer8);
        playerService.addPlayer(australianPlayer9);
        playerService.addPlayer(australianPlayer10);
        playerService.addPlayer(australianPlayer11);
        playerService.addPlayer(australianPlayer12);
        playerService.addPlayer(australianPlayer13);
        playerService.addPlayer(australianPlayer14);
        playerService.addPlayer(australianPlayer15);

        //choose players for team
        List<String> indianPlayers = new ArrayList<>();

        indianPlayers.add(indianPlayer1.getPlayerId());
        indianPlayers.add(indianPlayer2.getPlayerId());
        indianPlayers.add(indianPlayer3.getPlayerId());
        indianPlayers.add(indianPlayer4.getPlayerId());
        indianPlayers.add(indianPlayer5.getPlayerId());
        indianPlayers.add(indianPlayer6.getPlayerId());
        indianPlayers.add(indianPlayer7.getPlayerId());
        indianPlayers.add(indianPlayer8.getPlayerId());
        indianPlayers.add(indianPlayer9.getPlayerId());
        indianPlayers.add(indianPlayer10.getPlayerId());
        indianPlayers.add(indianPlayer11.getPlayerId());
        indianPlayers.add(indianPlayer12.getPlayerId());
        indianPlayers.add(indianPlayer13.getPlayerId());
        indianPlayers.add(indianPlayer14.getPlayerId());
        indianPlayers.add(indianPlayer15.getPlayerId());

        Team teamIndia = new Team("India","India",indianPlayers);
        teamService.createTeam(teamIndia);

        //choose playing 11 for India
        List<String> indPlayingEleven = indianPlayers.stream().limit(11).toList();
        teamService.updatePlayingEleven(teamIndia.getTeamId(), indPlayingEleven);

        // choose players for team

        List<String> australianPlayers = new ArrayList<>();

        australianPlayers.add(australianPlayer1.getPlayerId());
        australianPlayers.add(australianPlayer2.getPlayerId());
        australianPlayers.add(australianPlayer3.getPlayerId());
        australianPlayers.add(australianPlayer4.getPlayerId());
        australianPlayers.add(australianPlayer5.getPlayerId());
        australianPlayers.add(australianPlayer6.getPlayerId());
        australianPlayers.add(australianPlayer7.getPlayerId());
        australianPlayers.add(australianPlayer8.getPlayerId());
        australianPlayers.add(australianPlayer9.getPlayerId());
        australianPlayers.add(australianPlayer10.getPlayerId());
        australianPlayers.add(australianPlayer11.getPlayerId());
        australianPlayers.add(australianPlayer12.getPlayerId());
        australianPlayers.add(australianPlayer13.getPlayerId());
        australianPlayers.add(australianPlayer14.getPlayerId());
        australianPlayers.add(australianPlayer15.getPlayerId());

        Team teamAus = new Team("Aus", "Australia", australianPlayers);
        teamService.createTeam(teamAus);

        //choose playing 11 for India
        List<String> ausPlayingEleven = australianPlayers.stream().limit(11).toList();
        teamService.updatePlayingEleven(teamAus.getTeamId(),indPlayingEleven);

        //create match
        Match match1 = new Match("Match1","Stadium1", new Date());

        matchService.addMatch(match1);

        //create innings
        Inning inning1 = new Inning(match1.getMatchId(),teamIndia.getTeamId(),teamAus.getTeamId());
        inningService.addInning(inning1);

        //create scorecards for striker, non-striker and bowler, if not already present
        ScoreCard indianPlayer1ScoreCard = batsmanScoreCardService.createScoreCardIfNotPresent(inning1.getInningId(),indianPlayer1.getPlayerId());
        ScoreCard indianPlayer2ScoreCard = batsmanScoreCardService.createScoreCardIfNotPresent(inning1.getInningId(),indianPlayer2.getPlayerId());
        ScoreCard australianPlayer8ScoreCard = bowlerScoreCardService.createScoreCardIfNotPresent(inning1.getInningId(),australianPlayer8.getPlayerId());

        //start 1st inning
        Over over1 = new Over(1);
        overService.addOver(over1);
        //after each bowl update scorecard, for each of the three players

        Bowl bowl1 = new Bowl(BowlType.NORMAL,australianPlayer8.getPlayerId(),indianPlayer1.getPlayerId(),4,false,null);
        bowlService.addBowl(bowl1);
        scoreUpdaterService.updateScore(inning1.getInningId(),australianPlayer8ScoreCard.getScoreCardId(),indianPlayer1ScoreCard.getScoreCardId(),bowl1.getBowlType(),4,false,null);

        Bowl bowl2 = new Bowl(BowlType.NORMAL,australianPlayer8.getPlayerId(),indianPlayer1.getPlayerId(),1,false,null);
        bowlService.addBowl(bowl2);
        scoreUpdaterService.updateScore(inning1.getInningId(),australianPlayer8ScoreCard.getScoreCardId(),indianPlayer1ScoreCard.getScoreCardId(),bowl2.getBowlType(),1,false,null);

        Bowl bowl3 = new Bowl(BowlType.NORMAL,australianPlayer8.getPlayerId(),indianPlayer2.getPlayerId(),2,false,null);
        bowlService.addBowl(bowl3);
        scoreUpdaterService.updateScore(inning1.getInningId(),australianPlayer8ScoreCard.getScoreCardId(),indianPlayer2ScoreCard.getScoreCardId(),bowl3.getBowlType(),2,false,null);

        Bowl bowl4 = new Bowl(BowlType.NORMAL,australianPlayer8.getPlayerId(),indianPlayer2.getPlayerId(),3,false,null);
        bowlService.addBowl(bowl4);
        scoreUpdaterService.updateScore(inning1.getInningId(),australianPlayer8ScoreCard.getScoreCardId(),indianPlayer2ScoreCard.getScoreCardId(),bowl4.getBowlType(),3,false,null);

        Bowl bowl5 = new Bowl(BowlType.WIDE_BALL,australianPlayer8.getPlayerId(),indianPlayer1.getPlayerId(),1,false,null);
        bowlService.addBowl(bowl5);
        scoreUpdaterService.updateScore(inning1.getInningId(),australianPlayer8ScoreCard.getScoreCardId(),indianPlayer1ScoreCard.getScoreCardId(),bowl5.getBowlType(),1,false,null);

        Bowl bowl6 = new Bowl(BowlType.NORMAL,australianPlayer8.getPlayerId(),indianPlayer1.getPlayerId(),4,false,null);
        bowlService.addBowl(bowl1);
        scoreUpdaterService.updateScore(inning1.getInningId(),australianPlayer8ScoreCard.getScoreCardId(),indianPlayer1ScoreCard.getScoreCardId(),bowl6.getBowlType(),4,false,null);

        Bowl bowl7 = new Bowl(BowlType.NORMAL,australianPlayer8.getPlayerId(),indianPlayer1.getPlayerId(),0,true, WicketType.BOLD);
        bowlService.addBowl(bowl1);
        scoreUpdaterService.updateScore(inning1.getInningId(),australianPlayer8ScoreCard.getScoreCardId(),indianPlayer1ScoreCard.getScoreCardId(),bowl5.getBowlType(),0,true,WicketType.BOLD);


        //till now, we have created 1 over, added scores and wickets for each batsmen, and bowlers
        //total score or wicket can be found from innings, individual score or wicket can be found for each player

        //repeat the same process for as many overs as the game has, and in between increase runs, make few wickets fall

        // do the same thing for second inning and in the end, find see which inning has more score, the batting team in that has won!

        Inning inning2 = new Inning(match1.getMatchId(),teamAus.getTeamId(),teamIndia.getTeamId());
        inningService.addInning(inning2);

    }
}
