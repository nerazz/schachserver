package board;

import pieces.Piece;
import players.PlayerColor;

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

	public void setState(State state) {
		this.state = state;
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

	public void put(Piece piece) {
		state = (piece.getColor() == PlayerColor.WHITE) ? State.WHITE : State.BLACK;
		this.piece = piece;
	}

	@Override
	public String toString() {
		//return state == null ? "[ ]" : "[" + state.toString() + "]";
		return piece == null ? "[" + state.toString() + "]" : "[" + piece.toString() + "]";
	}
}
