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
		if (board.get(move.getSrc()).getColor() == board.get(move.getDst()).getColor())
			return false;
		switch (board.get(move.getSrc()).getPiece()) {
			case NONE:
				return false;
			case PAWN:
				return pawnMove(board, move);
			case BISHOP:
				return bishopMove(board, move);
			case KING:
				return kingMove(board, move);
		}
		throw new IllegalStateException("ERROR in PieceLogic.isValid");
	}

	public static boolean pawnMove(Board board, Move move) {
		Square src = board.get(move.getSrc());
		Square dst = board.get(move.getDst());
		int dir = (src.getColor() == Color.WHITE) ? 1 : -1;



		if ((dir == 1 && src.getY() == 1) || ((dir == -1) && (src.getY() == 6))) {
			if ((dst.getY() == src.getY() + 2 && src.getX() == dst.getX()) || (dst.getY() == src.getY() - 2 && src.getX() == dst.getX()))
				return true;
		}

		if (src.getY() + dir != dst.getY())
			return false;//wrong direction

		if (dst.getX() == src.getX() && dst.getPiece() == Piece.NONE)
			return true;
		else
			return (dst.getX() == src.getX() + 1 || dst.getX() == src.getX() - 1)
					&& dst.getColor() != src.getColor();
	}

	public static boolean kingMove(Board board, Move move) {
		Square src = board.get(move.getSrc());
		Square dst = board.get(move.getDst());


		//if(isCheck) {
		//  return false;
		// TODO: König im Schach?


		int xdif = src.getX() - dst.getX();
		int ydif = src.getY() - dst.getY();

		if ((xdif <= 1 && xdif >= -1) && (ydif <= 1 && ydif >= -1)) {
			return true;

		}
		else return false;

	}

	public static boolean bishopMove(Board board, Move move) {


		Square src = board.get(move.getSrc());
		Square dst = board.get(move.getDst());

			int dirX = (dst.getX() < src.getX()) ? -1 : 1;
			int dirY = (dst.getY() < src.getY()) ? -1 : 1;

			Position pos = new Position(src.getX() + dirX, src.getY() + dirY);

			while (!src.equals(dst)) {
				pos = new Position(pos.getX() + dirX, pos.getY() + dirY);
				if (pos.getX() < 0 || pos.getX() > 7 || pos.getY() < 0 || pos.getY() > 7)
					return false;
				if (!pos.equals(dst) && board.get(pos).getPiece() != Piece.NONE)
					return false;
			}
			return true;
		}
	}
