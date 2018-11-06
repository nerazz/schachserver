package pieces;

import board.Position;
import board.Square;
import players.Color;

/**
 * created on: 02.11.18
 */

public class Bishop extends Piece {

	private Color color;


	public Bishop(Color color, Position current) {
		super(color, current);
	}

	@Override
	public boolean canMove(Position pos) {
		return false;
	}


	/*public void validmove() {

		Owner owner;
		if (color == Color.WHITE) {
			owner = Owner.WHITE;

		} else {
			owner = Owner.BLACK;
		}

		Square[][] squares = getBoard().getState();
		int x = getPosition().getX();
		int y = getPosition().getY();
		boolean stop = true;
		int a = 1;
		while (x + a <= 7 && y + a <= 7 && stop) {
			if (squares[x + a][y + a].getOwner() == Owner.EMPTY) {
				validMoves.add(new Position(x + a, y + a));
			} else if (squares[x + a][y + a].getOwner() != owner) {
				validMoves.add(new Position(x + a, y + a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}

		stop = true;
		a = 1;
		while (x - a >= 0 && y - a >= 0 && stop) {
			if (squares[x + a][y + a].getOwner() == Owner.EMPTY) {
				validMoves.add(new Position(x - a, y - a));
			} else if (squares[x - a][y - a].getOwner() != owner) {
				validMoves.add(new Position(x - a, y - a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}


		stop = true;
		a = 1;
		while (x + a <= 7 && y - a >= 0 && stop) {
			if (squares[x + a][y - a].getOwner() == Owner.EMPTY) {
				validMoves.add(new Position(x + a, y - a));
			} else if (squares[x + a][y - a].getOwner() != owner) {
				validMoves.add(new Position(x + a, y - a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}

		stop = true;
		a = 1;
		while (x - a >= 0 && y + a <= 7 && stop) {
			if (squares[x - a][y + a].getOwner() == Owner.EMPTY) {
				validMoves.add(new Position(x - a, y + a));

			} else if (squares[x - a][y + a].getOwner() != owner) {
				validMoves.add(new Position(x - a, y + a));
				stop = false;
			} else {
				stop = false;
			}
			a++;
		}


	}*/
}


