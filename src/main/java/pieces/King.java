package pieces;

import board.Owner;
import board.Position;
import board.Field;
import players.PlayerColor;

public class King extends Piece {


	private PlayerColor color;


	public King(PlayerColor color, Position current) {

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

		if (x + 1 <= 7 && y + 1 <= 7 && (fields[x + 1][y + 1].getOwner() == Owner.EMPTY || fields[x + 1][y + 1].getOwner() != owner)) {
			validmoves.add(new Position(x + 1, y + 1));
		}
		if (y + 1 <= 7 && (fields[x][y + 1].getOwner() == Owner.EMPTY || fields[x][y + 1].getOwner() != owner)) {
			validmoves.add(new Position(x, y + 1));
		}
		if (x + 1 <= 7 && y - 1 >= 0 && (fields[x + 1][y - 1].getOwner() == Owner.EMPTY || fields[x + 1][y - 1].getOwner() != owner)) {
			validmoves.add(new Position(x + 1, y - 1));
		}
		if (x + 1 <= 7 && (fields[x + 1][y].getOwner() == Owner.EMPTY || fields[x + 1][y].getOwner() != owner)) {
			validmoves.add(new Position(x + 1, y));
		}
		if (y - 1 >= 0 && (fields[x][y - 1].getOwner() == Owner.EMPTY || fields[x][y - 1].getOwner() != owner)) {
			validmoves.add(new Position(x, y - 1));
		}
		if (x - 1 >= 0 && y - 1 >= 0 && (fields[x - 1][y - 1].getOwner() == Owner.EMPTY || fields[x - 1][y - 1].getOwner() != owner)) {
			validmoves.add(new Position(x - 1, y - 1));
		}
		if (x - 1 >= 0 && y + 1 <= 7 && (fields[x - 1][y + 1].getOwner() == Owner.EMPTY || fields[x - 1][y + 2].getOwner() != owner)) {
			validmoves.add(new Position(x - 1, y + 1));
		}
		if (x - 1 >= 0 && (fields[x + -1][y].getOwner() == Owner.EMPTY || fields[x - 1][y].getOwner() != owner)) {
			validmoves.add(new Position(x - 1, y));
		}

	}

}





