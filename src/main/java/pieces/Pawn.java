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

public class Pawn extends Piece {




    public Pawn(PlayerColor color, Coordinate current) {
        super(color, current);
    }




   public void validmove() {

        Field[][] state = getBoard().getState();
       int x = getCurrent().getX();
       int y = getCurrent().getY();

       if (getColor() == PlayerColor.WHITE) {
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

   }





    //test
}
