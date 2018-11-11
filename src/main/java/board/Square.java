package board;

import players.Color;

import static board.Piece.*;

/**
 * created on: 02.11.18
 */

public class Square {
	private final Position POS;
	private Piece piece;
	private Color color;

	Square(Position pos) {
		this.POS = pos;
	}

	void empty() {
		piece = Piece.NONE;
		color = Color.NONE;
	}

	void put(Piece piece, Color color) {
		this.piece = piece;
		this.color = color;
	}

	Piece getPiece() {
		return piece;
	}

	Color getColor() {
		return color;
	}

	private Position getPos() {
		return POS;
	}

	int getX() {
		return POS.getX();
	}

	int getY() {
		return POS.getY();
	}

	@Override
	public String toString() {
		if (piece == Piece.NONE)
			return "--";
		String p;
		if (piece == KNIGHT)
			p = "N";
		else
			p = String.valueOf(piece.toString().charAt(0));
		return String.valueOf(color.toString().charAt(0)) + p;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Square)) {
			return false;
		}
		Square f = (Square)o;
		return (POS.equals(f.getPos()) && piece == f.getPiece() && color == f.getColor());
	}
}
