package commonLLDQuestions.ticTacToe.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private int size;
    private Piece[][] board;

    public Board(int size){
        this.size = size;
        this.board = new Piece[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }


    public boolean addPiece(int row, int column, Piece piece) {

        if(board[row][column] != null) {
            return false;
        }
        board[row][column] = piece;
        return true;
    }


    public List<List<Integer>> getFreeCells() {
        List<List<Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    List<Integer> rowColumn = new ArrayList<>(Arrays.asList(i,j));
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getPieceType().name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

}
