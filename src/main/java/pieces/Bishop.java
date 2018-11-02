package pieces;

import board.Board;
import board.Coordinate;
import board.Field;
import board.State;
import players.Player;
import players.PlayerColor;

/**
 * created on: 02.11.18
 */

public class Bishop extends Piece {

	private PlayerColor color;


	public Bishop(PlayerColor color, Coordinate current) {
		super(color, current);
	}


	public void validmove() {

		State state;
		if (color == PlayerColor.WHITE) {
			state = State.WHITE;

		} else {
			state = State.BLACK;
		}

		Field[][] fields = getBoard().getState();
		int x = getCurrent().getX();
		int y = getCurrent().getY();
		boolean stop = true;
		int a = 1;
		while (x + a <= 7 && y + a <= 7 && stop) {
			if (fields[x + a][y + a].getState() == State.EMPTY) {
				validmoves.add(new Coordinate(x + a, y + a));
			} else if (fields[x + a][y + a].getState() != state) {
				validmoves.add(new Coordinate(x + a, y + a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}

		stop = true;
		a = 1;
		while (x - a >= 0 && y - a >= 0 && stop) {
			if (fields[x + a][y + a].getState() == State.EMPTY) {
				validmoves.add(new Coordinate(x - a, y - a));
			} else if (fields[x - a][y - a].getState() != state) {
				validmoves.add(new Coordinate(x - a, y - a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}


		stop = true;
		a = 1;
		while (x + a <= 7 && y - a >= 0 && stop) {
			if (fields[x + a][y - a].getState() == State.EMPTY) {
				validmoves.add(new Coordinate(x + a, y - a));
			} else if (fields[x + a][y - a].getState() != state) {
				validmoves.add(new Coordinate(x + a, y - a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}

		stop = true;
		a = 1;
		while (x - a >= 0 && y + a <= 7 && stop) {
			if (fields[x - a][y + a].getState() == State.EMPTY) {
				validmoves.add(new Coordinate(x - a, y + a));

			} else if (fields[x - a][y + a].getState() != state) {
				validmoves.add(new Coordinate(x - a, y + a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}


	}
}


