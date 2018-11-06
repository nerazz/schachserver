package board;

import pieces.Piece;

/**
 * created on: 02.11.18
 */

public class Square {
	private Piece piece;
	private final Position pos;


	Square(Position pos) {
		this.pos = pos;
	}

	public Piece setPiece(Piece piece) {
		return this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public boolean isEmpty() {
		return piece == null;
	}

	public Position getPos() {
		return pos;
	}

	@Override
	public String toString() {
		String s = " [" + pos.toString();
		s += piece == null ? ":EMPTY] " : ":" + piece.toString() + "] ";
		return s;
		//return piece == null ? "[" + owner.toString() + "]" : "[" + piece.toString() + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Square)) {
			return false;
		}
		Square f = (Square)o;
		return (pos.equals(f.getPos()) && piece.equals(f.getPiece()));
	}
}
