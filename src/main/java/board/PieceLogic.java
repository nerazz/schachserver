package board;


import players.Color;

/**
 * @author Niklas Zd
 * @since 10.11.2018
 */
public final class PieceLogic {

	private PieceLogic() {}

	public static boolean isValid(Board board, Move move) {
		if (move.getSrc().equals(move.getDst()))
			return false;
		switch (board.get(move.getSrc()).getPiece()) {
			case NONE:
				return false;
			case PAWN:
				return pawnMove(board, move);
		}
		throw new IllegalStateException("ERROR in PieceLogic.isValid");
	}

	public static boolean pawnMove(Board board, Move move) {
		Square src = board.get(move.getSrc());
		Square dst = board.get(move.getDst());
		int dir = (src.getColor() == Color.WHITE) ? 1 : -1;
		/*if (!hasMoved) {
			//TODO: 2 squares
		}*/
		if (src.getY() + dir != dst.getY())
			return false;//wrong direction

		if (dst.getY() == src.getX() && dst.getPiece() == Piece.NONE)
			return true;
		else
			return (dst.getX() == src.getX() + 1 || dst.getX() == src.getX() - 1)
					&& dst.getColor() != src.getColor();
	}

	public static boolean bishopMove(Board board, Move move) {
		return false;
		//bishop
		/*@Override
		public boolean canMove(Position dest) {
			Position POS = getPosition();
			if (POS.equals(dest))
				return false;

			if (!getBoard().getSquare(dest).isEmpty()) {
				if (getBoard().getSquare(dest).getPiece().getColor() == getColor()) {
					return false;
				}
			}

			int dirX = (dest.getX() < POS.getX()) ? -1 : 1;
			int dirY = (dest.getY() < POS.getY()) ? -1 : 1;

			while (!POS.equals(dest)) {
				POS = new Position(POS.getX() + dirX, POS.getY() + dirY);
				if (POS.getX() < 0 || POS.getX() > 7 || POS.getY() < 0 || POS.getY() > 7)
					return false;
				if (!POS.equals(dest) && !getBoard().getSquare(POS).isEmpty())
					return false;
			}
			return true;
		}*/
	}
}
