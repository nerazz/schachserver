package pieces;

import board.Position;
import board.Square;
import players.Color;

public class King extends Piece {


	private Color color;


	public King(Color color, Position current) {

		super(color, current);
	}


	/*public void validmove() {

		Square[][] squares = getBoard().getState();
		int x = getPosition().getX();
		int y = getPosition().getY();
		Owner owner;
		if (color == Color.WHITE) {
			owner = Owner.WHITE;

		} else {
			owner = Owner.BLACK;
		}

		if (x + 1 <= 7 && y + 1 <= 7 && (squares[x + 1][y + 1].getOwner() == Owner.EMPTY || squares[x + 1][y + 1].getOwner() != owner)) {
			validMoves.add(new Position(x + 1, y + 1));
		}
		if (y + 1 <= 7 && (squares[x][y + 1].getOwner() == Owner.EMPTY || squares[x][y + 1].getOwner() != owner)) {
			validMoves.add(new Position(x, y + 1));
		}
		if (x + 1 <= 7 && y - 1 >= 0 && (squares[x + 1][y - 1].getOwner() == Owner.EMPTY || squares[x + 1][y - 1].getOwner() != owner)) {
			validMoves.add(new Position(x + 1, y - 1));
		}
		if (x + 1 <= 7 && (squares[x + 1][y].getOwner() == Owner.EMPTY || squares[x + 1][y].getOwner() != owner)) {
			validMoves.add(new Position(x + 1, y));
		}
		if (y - 1 >= 0 && (squares[x][y - 1].getOwner() == Owner.EMPTY || squares[x][y - 1].getOwner() != owner)) {
			validMoves.add(new Position(x, y - 1));
		}
		if (x - 1 >= 0 && y - 1 >= 0 && (squares[x - 1][y - 1].getOwner() == Owner.EMPTY || squares[x - 1][y - 1].getOwner() != owner)) {
			validMoves.add(new Position(x - 1, y - 1));
		}
		if (x - 1 >= 0 && y + 1 <= 7 && (squares[x - 1][y + 1].getOwner() == Owner.EMPTY || squares[x - 1][y + 2].getOwner() != owner)) {
			validMoves.add(new Position(x - 1, y + 1));
		}
		if (x - 1 >= 0 && (squares[x + -1][y].getOwner() == Owner.EMPTY || squares[x - 1][y].getOwner() != owner)) {
			validMoves.add(new Position(x - 1, y));
		}

	}*/

}





