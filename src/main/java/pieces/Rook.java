package pieces;

import board.Position;
import players.Color;

public class Rook extends Piece {


	public Rook(Color color, Position current) {
		super(color, current);
	}

	@Override
	public boolean canMove(Position pos) {
		return false;
	}


}
