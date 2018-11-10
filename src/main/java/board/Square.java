package board;

import players.Color;

import static board.Piece.*;

/**
 * created on: 02.11.18
 */

public class Square {
	private static Board board;//FIXME: sehr schlecht (z.b. wenn mehrere spiele gleichzeitig -> nur neustes board existiert
	private final Position POS;
	private Piece piece;
	private Color color;

	Square(Position pos) {
		this.POS = pos;
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

	public boolean pieceCanMoveTo(Position dst) {
		return piece != Piece.NONE;
		//boolean valid = false;
		/*switch (piece) {
			case PAWN:
				valid = pawn(dst);
				break;
		}
		return valid;*/
	}

	public boolean pieceCanMoveTo(int x, int y) {
		return pieceCanMoveTo(new Position(x, y));
	}//IDEA: in board packen, um board in fields zu fixen

	private boolean pawn(Position dst) {
		return false;
	}

	public Piece getPiece() {
		return piece;
	}

	public Color getColor() {
		return color;
	}

	public Position getPos() {
		return POS;
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
		Position POS = getPosition();
		if (POS.equals(dest))
			return false;

		if (!getBoard().getSquare(dest).isEmpty()) {
			if (getBoard().getSquare(dest).getPiece().getColor() == getColor()) {
				return false;
			}
		}

		int dirX = (dest.getX() < POS.getX()) ? -1 : 1;
		int dirY = (dest.getY() < POS.getY()) ? -1 : 1;

		while (!POS.equals(dest)) {
			POS = new Position(POS.getX() + dirX, POS.getY() + dirY);
			if (POS.getX() < 0 || POS.getX() > 7 || POS.getY() < 0 || POS.getY() > 7)
				return false;
			if (!POS.equals(dest) && !getBoard().getSquare(POS).isEmpty())
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
		return (POS.equals(f.getPos()) && piece == f.getPiece() && color == f.getColor());
	}
}
