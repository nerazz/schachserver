package pieces;

import board.Owner;
import board.Position;
import board.Field;
import players.PlayerColor;

public class Knight extends Piece {

	private PlayerColor color;


	public Knight(PlayerColor color, Position current) {

		super(color, current);
	}


	public void validmove() {


		Field[][] fields = getBoard().getState();
		int x = getCurrent().getX();
		int y = getCurrent().getY();
		Owner owner;
		if (color == PlayerColor.WHITE) {
			owner = Owner.WHITE;

		} else {
			owner = Owner.BLACK;
		}

		if (x + 1 <= 7 && y + 2 <= 7 && (fields[x + 1][y + 2].getOwner() == Owner.EMPTY || fields[x + 1][y + 2].getOwner() != owner)) {
			validmoves.add(new Position(x + 1, y + 2));
		}
		if (x + 2 <= 7 && y + 1 <= 7 && (fields[x + 2][y + 1].getOwner() == Owner.EMPTY || fields[x + 2][y + 1].getOwner() != owner)) {
			validmoves.add(new Position(x + 2, y + 1));
		}
		if (x + 2 <= 7 && y - 1 >= 0 && (fields[x + 2][y - 1].getOwner() == Owner.EMPTY || fields[x + 2][y - 1].getOwner() != owner)) {
			validmoves.add(new Position(x + 2, y - 1));
		}
		if (x + 1 <= 7 && y - 2 >= 0 && (fields[x + 1][y - 2].getOwner() == Owner.EMPTY || fields[x + 1][y - 2].getOwner() != owner)) {
			validmoves.add(new Position(x + 1, y - 2));
		}
		if (x - 2 >= 0 && y - 1 >= 0 && (fields[x - 2][y - 1].getOwner() == Owner.EMPTY || fields[x - 2][y - 1].getOwner() != owner)) {
			validmoves.add(new Position(x - 2, y - 1));
		}
		if (x - 1 >= 0 && y - 2 >= 0 && (fields[x - 1][y - 2].getOwner() == Owner.EMPTY || fields[x - 1][y - 2].getOwner() != owner)) {
			validmoves.add(new Position(x - 1, y - 2));
		}
		if (x - 1 >= 0 && y + 2 <= 7 && (fields[x - 1][y + 2].getOwner() == Owner.EMPTY || fields[x - 1][y + 2].getOwner() != owner)) {
			validmoves.add(new Position(x - 1, y + 2));
		}
		if (x - 2 >= 0 && y + 1 <= 7 && (fields[x + -2][y + 1].getOwner() == Owner.EMPTY || fields[x - 2][y + 1].getOwner() != owner)) {
			validmoves.add(new Position(x - 2, y + 1));
		}


	}


}


