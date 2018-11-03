package pieces;

import board.Board;
import board.Position;
import board.Square;
import players.Color;

/**
 * created on: 02.11.18
 */

public class Pawn extends Piece {
	boolean hasMoved = false;

	public Pawn(Color color, Position position) {
		super(color, position);
	}


	@Override
	public boolean isValid(Position pos) {
		int x = pos.getX();
		int y = pos.getY();
		Position current = getPosition();
		Board b = getBoard();



		/*int x = getPosition().getX();
		int y = getPosition().getY();*/

		if (getColor() == Color.WHITE) {
			//TODO: check if in range
			if (y == current.getY() + 1 && x == current.getX() && b.get(pos).isEmpty()) {
				//TODO: check if empty
				hasMoved = true;
				return true;
			}
			if (y == current.getY() + 1 && (x == current.getX() + 1 || x == current.getX() - 1) && b.get(pos).getPiece().getColor() == Color.BLACK){
				hasMoved = true;
				return true;
			}
		}

		else {
			if (y == current.getY() - 1 && x == current.getX() && b.get(pos).isEmpty()) {
				hasMoved = true;
				return true;
			}
			if (y == current.getY() + 1 && (x == current.getX() + 1 || x == current.getX() - 1) && b.get(pos).getPiece().getColor() == Color.BLACK){
				hasMoved = true;
				return true;
			}
		}

		return false;
/*
				validMoves.add(new Position(x, y+1));
				return true;
			}

			/*if (b.get(x, y + 1).getPiece().equals(null)) {
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
			}*/
		/*}
		return false;
*/
	}



}
