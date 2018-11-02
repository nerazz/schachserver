package board;

import pieces.Piece;

/**
 * created on: 02.11.18
 */

public class Field {
    private State state = State.EMPTY;
    private Piece piece = null;
    private final Coordinate coord;
    //coords?
    //color?
    //state?

    Field(int x, int y) {
        coord = new Coordinate(x, y);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        //return state == null ? "[ ]" : "[" + state.toString() + "]";
        return state == null ? "[" + coord.toString() + "]" : "[" + state.toString() + "]";
    }
}
