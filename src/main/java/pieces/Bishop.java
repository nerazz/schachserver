package pieces;

import board.Owner;
import board.Position;
import board.Field;
import players.PlayerColor;

/**
 * created on: 02.11.18
 */

public class Bishop extends Piece {

	private PlayerColor color;


	public Bishop(PlayerColor color, Position current) {
		super(color, current);
	}


	public void validmove() {

		Owner owner;
		if (color == PlayerColor.WHITE) {
			owner = Owner.WHITE;

		} else {
			owner = Owner.BLACK;
		}

		Field[][] fields = getBoard().getState();
		int x = getCurrent().getX();
		int y = getCurrent().getY();
		boolean stop = true;
		int a = 1;
		while (x + a <= 7 && y + a <= 7 && stop) {
			if (fields[x + a][y + a].getOwner() == Owner.EMPTY) {
				validmoves.add(new Position(x + a, y + a));
			} else if (fields[x + a][y + a].getOwner() != owner) {
				validmoves.add(new Position(x + a, y + a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}

		stop = true;
		a = 1;
		while (x - a >= 0 && y - a >= 0 && stop) {
			if (fields[x + a][y + a].getOwner() == Owner.EMPTY) {
				validmoves.add(new Position(x - a, y - a));
			} else if (fields[x - a][y - a].getOwner() != owner) {
				validmoves.add(new Position(x - a, y - a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}


		stop = true;
		a = 1;
		while (x + a <= 7 && y - a >= 0 && stop) {
			if (fields[x + a][y - a].getOwner() == Owner.EMPTY) {
				validmoves.add(new Position(x + a, y - a));
			} else if (fields[x + a][y - a].getOwner() != owner) {
				validmoves.add(new Position(x + a, y - a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}

		stop = true;
		a = 1;
		while (x - a >= 0 && y + a <= 7 && stop) {
			if (fields[x - a][y + a].getOwner() == Owner.EMPTY) {
				validmoves.add(new Position(x - a, y + a));

			} else if (fields[x - a][y + a].getOwner() != owner) {
				validmoves.add(new Position(x - a, y + a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}


	}
}


