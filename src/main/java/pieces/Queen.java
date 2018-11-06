package pieces;

import board.Position;
import players.Color;

public class Queen extends Piece {


	public Queen(Color color, Position current) {
		super(color, current);
	}

	@Override
	public boolean canMove(Position pos) {
		return false;
	}

}
