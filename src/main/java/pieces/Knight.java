package pieces;

import board.Board;
import board.Coordinate;
import board.Field;
import players.PlayerColor;

public class Knight extends Piece {



    private PlayerColor color;
    private boolean hasMoved = false;
    private Coordinate current_coordinate;
    private Coordinate new_coordinate;



    public Knight(PlayerColor color, Coordinate current) {
        super(color, current);
    }





    public void validmove() {

        Field[][] state = getBoard().getState();
        int x = current_coordinate.getX();
        int y = current_coordinate.getY();

      /*  if (color == PlayerColor.WHITE) {
            if( )

                validmoves.add(new Coordinate(x + 1, y + 1));
            validmoves.add(new Coordinate(x + 2,y + 2));
            validmoves.add(new Coordinate(x + 3, y + 3));
        } else {

            validmoves.add(new Coordinate(x, y - 1));
            validmoves.add(new Coordinate(x - 1,y - 1));
            validmoves.add(new Coordinate(x + 1,y + 1));
        }
        */

    }

}


