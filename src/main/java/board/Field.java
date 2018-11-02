package board;

import pieces.Piece;

/**
 * created on: 02.11.18
 */

public class Field {
    private Piece piece = null;
    private final Coordinate coord;
    //coords?
    //color?
    //piece?

    Field(int x, int y) {
        coord = new Coordinate(x, y);
    }

    Coordinate getCoord() {
        return coord;
    }

    @Override
    public String toString() {
        //return piece == null ? "[ ]" : "[" + piece.toString() + "]";
        return piece == null ? "[" + coord.toString() + "]" : "[" + piece.toString() + "]";
    }
}
