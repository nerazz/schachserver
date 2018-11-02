package board;

import pieces.Piece;

/**
 * created on: 02.11.18
 */

public class Field {
    private Piece piece = null;
    //coords?
    //color?

    @Override
    public String toString() {
        return piece == null ? "[ ]" : "[" + piece.toString() + "]";
    }
}
