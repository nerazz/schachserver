package pieces;

import board.Position;
import board.Square;
import players.Color;

public class Knight extends Piece {

	private Color color;


	public Knight(Color color, Position current) {

		super(color, current);
	}

	@Override
	public boolean canMove(Position pos) {
		return false;
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

		if (x + 1 <= 7 && y + 2 <= 7 && (squares[x + 1][y + 2].getOwner() == Owner.EMPTY || squares[x + 1][y + 2].getOwner() != owner)) {
			validMoves.add(new Position(x + 1, y + 2));
		}
		if (x + 2 <= 7 && y + 1 <= 7 && (squares[x + 2][y + 1].getOwner() == Owner.EMPTY || squares[x + 2][y + 1].getOwner() != owner)) {
			validMoves.add(new Position(x + 2, y + 1));
		}
		if (x + 2 <= 7 && y - 1 >= 0 && (squares[x + 2][y - 1].getOwner() == Owner.EMPTY || squares[x + 2][y - 1].getOwner() != owner)) {
			validMoves.add(new Position(x + 2, y - 1));
		}
		if (x + 1 <= 7 && y - 2 >= 0 && (squares[x + 1][y - 2].getOwner() == Owner.EMPTY || squares[x + 1][y - 2].getOwner() != owner)) {
			validMoves.add(new Position(x + 1, y - 2));
		}
		if (x - 2 >= 0 && y - 1 >= 0 && (squares[x - 2][y - 1].getOwner() == Owner.EMPTY || squares[x - 2][y - 1].getOwner() != owner)) {
			validMoves.add(new Position(x - 2, y - 1));
		}
		if (x - 1 >= 0 && y - 2 >= 0 && (squares[x - 1][y - 2].getOwner() == Owner.EMPTY || squares[x - 1][y - 2].getOwner() != owner)) {
			validMoves.add(new Position(x - 1, y - 2));
		}
		if (x - 1 >= 0 && y + 2 <= 7 && (squares[x - 1][y + 2].getOwner() == Owner.EMPTY || squares[x - 1][y + 2].getOwner() != owner)) {
			validMoves.add(new Position(x - 1, y + 2));
		}
		if (x - 2 >= 0 && y + 1 <= 7 && (squares[x + -2][y + 1].getOwner() == Owner.EMPTY || squares[x - 2][y + 1].getOwner() != owner)) {
			validMoves.add(new Position(x - 2, y + 1));
		}


	}*/


}


