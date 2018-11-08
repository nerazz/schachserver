package board;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import players.Color;

import static board.Piece.*;

/**
 * created on: 02.11.18
 */

public class Board {
	private final Square[][] squares = new Square[8][8];//[x][y]

	public Board() {
		Square.init(this);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new Square(new Position(j, 7-i));
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

	public Square get(int x, int y) {//TODO: clone returnen; statt getState und squares[][] benutzen
		return squares[7-y][x];//durch umgedrehtes Array x & y vertauscht
	}

	public Square get(Position position) {
		return squares[7-position.getY()][position.getX()];
	}

	public Piece getPiece(int x, int y) {
		return get(x, y).getPiece();
	}

	public Color getColor(int x, int y) {
		return get(x, y).getColor();
	}

	public boolean move(Position src, Position dest) {
		Square square = get(src);
		if (!square.pieceCanMoveTo(dest)) {
			return false;
		}
		Piece p = square.getPiece();
		Color c = square.getColor();
		square.empty();
		get(dest).put(p, c);
		return true;
	}

	public boolean isValidMove(Position src, Position dest) {
		return get(src).pieceCanMoveTo(dest);
	}

	public boolean isValidMove(int srcX, int srcY, int destX, int destY) {
		return isValidMove(new Position(srcX, srcY), new Position(destX, destY));
	}

	public void loadState(String state) {
		if (state.length() != 128) {
			throw new IllegalArgumentException("Illegal size of board");
		}
		state = state.toLowerCase();
		int k = 0;
		String current;
		for (int i = 0; i < 8; i++) {
			for (int j = 7; j >= 0; j--) {
				current = state.substring(k*2, (k+1)*2);
				Square square = get(7-j, 7-i);
				if (current.equals("--")) {//TODO: cleaner
					square.empty();
					k++;
					continue;
				}
				Color color = current.substring(0,1).equals("w") ? Color.WHITE : Color.BLACK;
				switch (current.substring(1,2)) {
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
				k++;
			}
		}
	}

	/*public String saveState() {//TODO: ohne json?
		BoardState bs = new BoardState();
		String[][] state = new String[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				state[i][j] = squares[i][j].toString();
			}
		}
		bs.setState(state);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(bs);
	}*/

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
