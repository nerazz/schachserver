package pieces;

import board.Board;
import board.Position;
import players.Color;

/**
 * created on: 02.11.18
 */

public class Pawn extends Piece {
	boolean hasMoved = false;

	public Pawn(Color color, Position position) {
		super(color, position);
	}


	@Override
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
		if (y != src.getY() + dir)
			return false;//wrong direction

		if (x == src.getX() && b.getSquare(dest).isEmpty())
			return true;
		else
			return (x == src.getX() + 1 || x == src.getX() - 1)
					&& b.getSquare(dest).getPiece().getColor() != getColor();
	}



}
