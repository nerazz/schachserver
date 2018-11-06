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
	public boolean isValid(Position pos) {
		int x = pos.getX();
		int y = pos.getY();
		Position current = getPosition();
		Board b = getBoard();

		int dir = (getColor() == Color.WHITE) ? 1 : -1;

		/*if (!hasMoved) {
			//TODO: 2 squares
		}*/
		if (y != current.getY() + dir)
			return false;//wrong direction

		if (x == current.getX() && b.getSquare(pos).isEmpty())
			return true;
		else
			return (x == current.getX() + 1 || x == current.getX() - 1)
					&& b.getSquare(pos).getPiece().getColor() != getColor();

	}



}
