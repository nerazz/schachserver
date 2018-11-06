package pieces;

import board.Position;
import board.Square;
import players.Color;

/**
 * created on: 02.11.18
 */

public class Bishop extends Piece {

	public Bishop(Color color, Position current) {
		super(color, current);
	}

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
}
