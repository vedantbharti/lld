package commonLLDQuestions.ticTacToe.dao;

import commonLLDQuestions.ticTacToe.enums.PieceType;

public class Piece {

    private PieceType pieceType;

    public Piece(PieceType pieceType){
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
