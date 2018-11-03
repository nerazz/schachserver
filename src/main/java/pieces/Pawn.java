package pieces;

import board.Board;
import board.Position;
import board.Square;
import players.Color;

import java.security.acl.Owner;

/**
 * created on: 02.11.18
 */

public class Pawn extends Piece {


	public Pawn(Color color, Position current) {
		super(color, current);
	}


	public void validmove() {
		Board b = getBoard();
		int x = getPosition().getX();
		int y = getPosition().getY();

		if (getColor() == Color.WHITE) {

			if (b.get(x, y + 1).getPiece().equals(null)) {
				validMoves.add(new Position(x, y + 1));
			}
			if (getBoard().get(x + 1, y + 1).getOwner() != Owner.EMPTY && getBoard().get(x + 1, y + 1).getOwner() == Owner.BLACK) {
				validMoves.add(new Position(x + 1, y + 1));
			}
			if (getBoard().get(x - 1, y + 1).getOwner() != Owner.EMPTY && getBoard().get(x - 1, y + 1).getOwner() == Owner.BLACK) {
				validMoves.add(new Position(x - 1, y + 1));
			}
		} else {
			if (getBoard().get(x, y - 1).getOwner() == Owner.EMPTY) {
				validMoves.add(new Position(x, y - 1));
			}
			if (getBoard().get(x - 1, y - 1).getOwner() != Owner.EMPTY && getBoard().get(x - 1, y - 1).getOwner() == Owner.WHITE) {
				validMoves.add(new Position(x - 1, y - 1));
			}
			if (getBoard().get(x + 1, y - 1).getOwner() != Owner.EMPTY && getBoard().get(x + 1, y - 1).getOwner() == Owner.WHITE) {

				validMoves.add(new Position(x + 1, y - 1));
			}
		}

	}



}
