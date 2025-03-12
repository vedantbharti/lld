package commonLLDQuestions.ticTacToe.dao;

import commonLLDQuestions.ticTacToe.enums.PieceType;

public class Player {

    private int id;
    private String name;
    private Piece piece;
    private boolean isWinner;

    public Player(int id, String name, Piece piece){
        this.id = id;
        this.name = name;
        this.piece = piece;
        this.isWinner = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
