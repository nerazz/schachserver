package board;

import pieces.Piece;
import players.PlayerColor;

/**
 * created on: 02.11.18
 */

public class Field {
	private Owner owner = Owner.EMPTY;
	private Piece piece = null;
	private final Position pos;
	//coords?
	//color?
	//owner?

	Field(Position pos) {
		this.pos = pos;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Piece getPiece() {
		return piece;
	}

	public Position getPos() {
		return pos;
	}

	public Owner getOwner() {
		return owner;
	}

	public void put(Piece piece) {
		owner = (piece.getColor() == PlayerColor.WHITE) ? Owner.WHITE : Owner.BLACK;
		this.piece = piece;
	}

	@Override
	public String toString() {
		String s = " [" + pos.toString();
		s += piece == null ? ":EMPTY] " : ":" + piece.toString() + "] ";
		return s;
		//return piece == null ? "[" + owner.toString() + "]" : "[" + piece.toString() + "]";
	}
}
