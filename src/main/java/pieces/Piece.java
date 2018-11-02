package pieces;

import board.Board;
import board.Coordinate;
import players.Player;
import players.PlayerColor;

import java.util.ArrayList;
import java.util.List;

/**
 * created on: 02.11.18
 */

public abstract class Piece {

    private static Board board; // Jeder Spieler hat eogenes Board um Spielstand zu überprüfen
    public List<Coordinate> validmoves = new ArrayList<Coordinate>();
    private final PlayerColor color;
    private boolean hasMoved = false;
    private Coordinate current_coordinate;
    private Coordinate new_coordinate;



    protected Piece(PlayerColor color, Board board, Coordinate current) {
        this.color = color;
        this.board = board;
        current_coordinate = current;

    }

    public static void setBoard(Board b) {
        board = b;
    }

    public Coordinate getCurrent() {
        return current_coordinate;
    }


    public PlayerColor getColor() {
        return color;
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
