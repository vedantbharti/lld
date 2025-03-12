package commonLLDQuestions.ticTacToe;

import commonLLDQuestions.ticTacToe.service.GameService;

public class Main {

    public static void main(String[] args) {

        GameService gameService = GameService.getInstance();
        gameService.initializeGame(3);
        gameService.playGame();
    }
}
