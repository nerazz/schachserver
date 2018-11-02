package pieces;

import board.Board;
import board.Coordinate;
import board.Field;
import board.State;
import players.Player;
import players.PlayerColor;

/**
 * created on: 02.11.18
 */

public class Bishop extends Piece {

    private PlayerColor color;
    private boolean hasMoved = false;
    private Coordinate current_coordinate;
    private Coordinate new_coordinate;



    public Bishop(PlayerColor color, Board board, Coordinate current) {
        super(color, board, current);
    }


/*


    public void validmove() {

        Field[][] state = getBoard().getState();
        int x = current_coordinate.getX();
        int y = current_coordinate.getY();


        while()

        if (color == PlayerColor.WHITE) {
            if(state[x][y+1].getState() == State.EMPTY) {
                validmoves.add(new Coordinate(x, y + 1));
            }
            if(state[x+1][y+1].getState() != State.EMPTY && state[x+1][y+1].getState() == State.BLACK) {
                validmoves.add(new Coordinate(x + 1, y + 1));
            }
            if(state[x-1][y+1].getState() != State.EMPTY && state[x-1][y+1].getState() == State.BLACK) {
                validmoves.add(new Coordinate(x - 1, y + 1));
            }
        } else {
            if(state[x][y-1].getState() == State.EMPTY) {
                validmoves.add(new Coordinate(x, y - 1));
            }
            if(state[x-1][y-1].getState() != State.EMPTY && state[x-1][y-1].getState() == State.WHITE) {
                validmoves.add(new Coordinate(x - 1, y - 1));
            }
            if(state[x+1][y-1].getState() != State.EMPTY && state[x+1][y-1].getState() == State.WHITE) {

                validmoves.add(new Coordinate(x + 1, y - 1));
            }
        }
        */

    }


