package board;

import players.Color;

import static players.Color.*;
import static board.Piece.*;

/**
 * created on: 02.11.18
 */

public class Square {
	private static Board board;//FIXME: sehr schlecht (z.b. wenn mehrere spiele gleichzeitig -> nur neustes board existiert
	private final Position pos;
	private Piece piece;
	private Color color;

	Square(Position pos) {
		this.pos = pos;
	}

	static void init(Board board) {
		Square.board = board;
	}

	public void empty() {
		piece = Piece.NONE;
		color = Color.NONE;
	}

	public void put(Piece piece, Color color) {
		this.piece = piece;
		this.color = color;
	}

	public boolean pieceCanMoveTo(Position dest) {
		boolean valid = false;
		if (piece == Piece.NONE) {
			return false;
		}
		return true;
		/*switch (piece) {
			case PAWN:
				valid = pawn(dest);
				break;
		}
		return valid;*/
	}

	public boolean pieceCanMoveTo(int x, int y) {
		return pieceCanMoveTo(new Position(x, y));
	}

	private boolean pawn(Position dest) {
		return false;
	}

	public Piece getPiece() {
		return piece;
	}

	public Color getColor() {
		return color;
	}

	public Position getPos() {
		return pos;
	}

	//pawn
	/*@Override
	public boolean canMove(Position dest) {
		if (getPosition().equals(dest))
			return false;

		int x = dest.getX();
		int y = dest.getY();
		Position src = getPosition();
		Board b = getBoard();

		int dir = (getColor() == Color.WHITE) ? 1 : -1;

		/*if (!hasMoved) {
			//TODO: 2 squares
		}*/
		/*if (y != src.getY() + dir)
			return false;//wrong direction

		if (x == src.getX() && b.get(dest).isEmpty())
			return true;
		else
			return (x == src.getX() + 1 || x == src.getX() - 1)
					&& b.get(dest).getPiece().getColor() != getColor();
	}

	//bishop
	@Override
	public boolean canMove(Position dest) {
		Position pos = getPosition();
		if (pos.equals(dest))
			return false;

		if (!getBoard().getSquare(dest).isEmpty()) {
			if (getBoard().getSquare(dest).getPiece().getColor() == getColor()) {
				return false;
			}
		}

		int dirX = (dest.getX() < pos.getX()) ? -1 : 1;
		int dirY = (dest.getY() < pos.getY()) ? -1 : 1;

		while (!pos.equals(dest)) {
			pos = new Position(pos.getX() + dirX, pos.getY() + dirY);
			if (pos.getX() < 0 || pos.getX() > 7 || pos.getY() < 0 || pos.getY() > 7)
				return false;
			if (!pos.equals(dest) && !getBoard().getSquare(pos).isEmpty())
				return false;
		}
		return true;
	}

	*/

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
		return (pos.equals(f.getPos()) && piece == f.getPiece() && color == f.getColor());
	}
}
