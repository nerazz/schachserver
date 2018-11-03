package pieces;

import board.Owner;
import board.Position;
import board.Field;
import players.PlayerColor;

/**
 * created on: 02.11.18
 */

public class Pawn extends Piece {


	public Pawn(PlayerColor color, Position current) {
		super(color, current);
	}


	public void validmove() {

		Field[][] get = getBoard().getState();
		int x = getCurrent().getX();
		int y = getCurrent().getY();

		if (getColor() == PlayerColor.WHITE) {
			if (getBoard().get(x, y + 1).getOwner() == Owner.EMPTY) {
				validmoves.add(new Position(x, y + 1));
			}
			if (getBoard().get(x + 1, y + 1).getOwner() != Owner.EMPTY && getBoard().get(x + 1, y + 1).getOwner() == Owner.BLACK) {
				validmoves.add(new Position(x + 1, y + 1));
			}
			if (getBoard().get(x - 1, y + 1).getOwner() != Owner.EMPTY && getBoard().get(x - 1, y + 1).getOwner() == Owner.BLACK) {
				validmoves.add(new Position(x - 1, y + 1));
			}
		} else {
			if (getBoard().get(x, y - 1).getOwner() == Owner.EMPTY) {
				validmoves.add(new Position(x, y - 1));
			}
			if (getBoard().get(x - 1, y - 1).getOwner() != Owner.EMPTY && getBoard().get(x - 1, y - 1).getOwner() == Owner.WHITE) {
				validmoves.add(new Position(x - 1, y - 1));
			}
			if (getBoard().get(x + 1, y - 1).getOwner() != Owner.EMPTY && getBoard().get(x + 1, y - 1).getOwner() == Owner.WHITE) {

				validmoves.add(new Position(x + 1, y - 1));
			}
		}

	}


	//test
}
