package commonLLDQuestions.ticTacToe.service;

import commonLLDQuestions.ticTacToe.dao.*;
import commonLLDQuestions.ticTacToe.enums.PieceType;

import java.util.*;

public class GameService {

    private Deque<Player> players;
    private Board board;

    private static GameService gameService;

    private Scanner scanner;

    private GameService(){
        scanner = new Scanner(System.in);
    }

    public static GameService getInstance(){
        if(gameService==null){
            gameService = new GameService();
        }

        return gameService;
    }

    public void initializeGame(int boardSize){
        this.players = new LinkedList<>();
        this.board = new Board(boardSize);

        Player player1 = new Player(1,"Player1", new PieceX());
        Player player2 = new Player(2,"Player2", new PieceY());

        players.addLast(player1);
        players.addLast(player2);

    }

    public void playGame(){

        boolean haveAWinner = false;

        while(!haveAWinner){

            board.printBoard();

            List<List<Integer>> freeSpaces =  board.getFreeCells();
            if(freeSpaces.isEmpty()) {
                haveAWinner = false;
                continue;
            }

            Player currPlayer = players.removeFirst();

            System.out.print("Player:" + currPlayer.getName() + " Enter row,column: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean pieceAdded = board.addPiece(row,col,currPlayer.getPiece());
            if(!pieceAdded) {
                System.out.println("This position is already filled, please try again!");
                players.addFirst(currPlayer);
                continue;
            }
            players.addLast(currPlayer);

            haveAWinner = isThereWinner(row,col,currPlayer.getPiece().getPieceType());
            if(haveAWinner){
                currPlayer.setWinner(true);
                System.out.println("The winner is " + currPlayer.getName());;
            }
        }

        if(!haveAWinner) System.out.println("There was a tie");;
    }

    private boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        Piece[][] currBoard = board.getBoard();
        int size = board.getSize();

        //need to check in row
        for(int i=0;i<size;i++) {

            if(currBoard[row][i] == null || currBoard[row][i].getPieceType() != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<size;i++) {

            if(currBoard[i][column] == null || currBoard[i][column].getPieceType() != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<size;i++,j++) {
            if (currBoard[i][j] == null || currBoard[i][j].getPieceType() != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=size-1; i<size;i++,j--) {
            if (currBoard[i][j] == null || currBoard[i][j].getPieceType() != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
