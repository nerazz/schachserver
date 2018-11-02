package pieces;

import board.Board;
import board.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * created on: 02.11.18
 */

public class Piece {

   private Board board; // Jeder Spieler hat eogenes Board um Spielstand zu überprüfen
    public List<Coordinate> validmoves = new ArrayList<Coordinate>();


    void setBoard(Board b) {
        board = b;
    }

   Board getBoard() {
        return board;
    }

    public boolean valid(Coordinate xy) {
        if (validmoves.contains(xy)) {

            return true;
        }
        return false;
    }
}
