package commonLLDQuestions.cricbuzz.repository;

import commonLLDQuestions.cricbuzz.entity.Player;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerRepo {

    private Map<String, Player> players;

    private PlayerRepo(){
        this.players = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final PlayerRepo INSTANCE = new PlayerRepo();
    }

    public static PlayerRepo getInstance() {
        return Initializer.INSTANCE;
    }

    public void addPlayer(Player player) {
        players.put(player.getPlayerId(),player);
    }
}
