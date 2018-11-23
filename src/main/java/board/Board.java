package board;


import com.google.gson.Gson;
import players.Color;

import static board.Piece.*;

/**
 * created on: 02.11.18
 */

public class Board {
	private final Square[][] SQUARES = new Square[8][8];//[x][y]

	public Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				SQUARES[i][j] = new Square(new Position(j, 7-i));
			}
		}
	}

	public Board initWithPieces() {
		String state =
				  "BRBNBBBQBKBBBNBR"
				+ "BPBPBPBPBPBPBPBP"
				+ "----------------"
				+ "----------------"
				+ "----------------"
				+ "----------------"
				+ "WPWPWPWPWPWPWPWP"
				+ "WRWNWBWQWKWBWNWR";
		loadState(state);
		return this;
	}

	Square get(int x, int y) {//TODO: clone returnen?
		return SQUARES[7-y][x];//durch umgedrehtes Array x & y vertauscht
	}

	Square get(Position pos) {
		return get(pos.getX(), pos.getY());
	}

	public boolean isValidMove(Move move) {
		return PieceLogic.isValid(this, move);//TODO: uncomment when rdy
		//return get(move.getSrc()).getPiece() != Piece.NONE;
	}

	public boolean isValidMove(int sx, int sy, int dx, int dy) {
		return isValidMove(new Move(new Position(sx, sy), new Position(dx, dy)));
	}

	public boolean move(Move move) {
		if(!isValidMove(move))
			return false;
		Square src = get(move.getSrc());
		get(move.getDst()).put(src.getPiece(), src.getColor());
		src.empty();
		return true;
	}

	public void loadState(String state) {//TODO: geht sicherlich besser, vielleicht mit stream?
		if (state.length() != 128) {
			throw new IllegalArgumentException("Illegal size of board");
		}
		state = state.toLowerCase();
		int k = 0;
		String current;
		for (int i = 0; i < 8; i++) {
			for (int j = 7; j >= 0; j--) {
				current = state.substring(k*2, (k+1)*2);
				k++;
				Square square = get(7-j, 7-i);
				if (current.equals("--")) {
					square.empty();
					continue;
				}
				Color color = current.substring(0, 1).equals("w") ? Color.WHITE : Color.BLACK;
				switch (current.substring(1, 2)) {
					case "p":
						square.put(PAWN, color);
						break;
					case "n":
						square.put(KNIGHT, color);
						break;
					case "b":
						square.put(BISHOP, color);
						break;
					case "r":
						square.put(ROOK, color);
						break;
					case "q":
						square.put(QUEEN, color);
						break;
					case "k":
						square.put(KING, color);
						break;
					default:
						throw new IllegalArgumentException("can't parse given state");
				}
			}
		}
	}

	public String saveStateToJson() {
		/*
			{
				status: "xy",
				state: [
					["BR", "BN", "BB", ...]
					["BP", "BP", "BP", ...]
					["--", "--", "--", ...]
					...
				]
			}
		 */

		String[][] state = new String[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				state[i][j] = SQUARES[i][j].toString();
			}
		}
		return new Gson().toJson(state);
	}

	@Override
	public String toString() {
		StringBuilder board = new StringBuilder();
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (j == 0) {
					board.append(i+1).append(" ");
				}
				board.append(get(j, i).toString()).append(" ");
			}
			board.append("\n");
		}
		board.append("  A  B  C  D  E  F  G  H");
		return board.toString();
	}
}
