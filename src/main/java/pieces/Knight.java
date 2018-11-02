package pieces;

import board.Board;
import board.Coordinate;
import board.Field;
import board.State;
import players.PlayerColor;

public class Knight extends Piece {

	private PlayerColor color;


	public Knight(PlayerColor color, Coordinate current) {

		super(color, current);
	}


	public void validmove() {


		Field[][] fields = getBoard().getState();
		int x = getCurrent().getX();
		int y = getCurrent().getY();
		State state;
		if (color == PlayerColor.WHITE) {
			state = State.WHITE;

		} else {
			state = State.BLACK;
		}

		if (x + 1 <= 7 && y + 2 <= 7 && (fields[x + 1][y + 2].getState() == State.EMPTY || fields[x + 1][y + 2].getState() != state)) {
			validmoves.add(new Coordinate(x + 1, y + 2));
		}
		if (x + 2 <= 7 && y + 1 <= 7 && (fields[x + 2][y + 1].getState() == State.EMPTY || fields[x + 2][y + 1].getState() != state)) {
			validmoves.add(new Coordinate(x + 2, y + 1));
		}
		if (x + 2 <= 7 && y - 1 >= 0 && (fields[x + 2][y - 1].getState() == State.EMPTY || fields[x + 2][y - 1].getState() != state)) {
			validmoves.add(new Coordinate(x + 2, y - 1));
		}
		if (x + 1 <= 7 && y - 2 >= 0 && (fields[x + 1][y - 2].getState() == State.EMPTY || fields[x + 1][y - 2].getState() != state)) {
			validmoves.add(new Coordinate(x + 1, y - 2));
		}
		if (x - 2 >= 0 && y - 1 >= 0 && (fields[x - 2][y - 1].getState() == State.EMPTY || fields[x - 2][y - 1].getState() != state)) {
			validmoves.add(new Coordinate(x - 2, y - 1));
		}
		if (x - 1 >= 0 && y - 2 >= 0 && (fields[x - 1][y - 2].getState() == State.EMPTY || fields[x - 1][y - 2].getState() != state)) {
			validmoves.add(new Coordinate(x - 1, y - 2));
		}
		if (x - 1 >= 0 && y + 2 <= 7 && (fields[x - 1][y + 2].getState() == State.EMPTY || fields[x - 1][y + 2].getState() != state)) {
			validmoves.add(new Coordinate(x - 1, y + 2));
		}
		if (x - 2 >= 0 && y + 1 <= 7 && (fields[x + -2][y + 1].getState() == State.EMPTY || fields[x - 2][y + 1].getState() != state)) {
			validmoves.add(new Coordinate(x - 2, y + 1));
		}


	}


}


