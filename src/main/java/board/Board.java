package board;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pieces.*;
import players.Color;

import java.util.Arrays;

import static pieces.PiecesEnum.*;

/**
 * created on: 02.11.18
 */

public class Board {
	private final Square[][] squares = new Square[8][8];//[x][y]


	public Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new Square(new Position(j, 7-i));
			}
		}
		Piece.setBoard(this);
	}

	public Board initWithPieces() {
		String state =
				  "BRBNBBBQBKBBBNBR"
				+ "BPBPBPBPBPBPBPBP"
				+ "EMEMEMEMEMEMEMEM"
				+ "EMEMEMEMEMEMEMEM"
				+ "EMEMEMEMEMEMEMEM"
				+ "EMEMEMEMEMEMEMEM"
				+ "WPWPWPWPWPWPWPWP"
				+ "WRWNWBWQWKWBWNWR";
		loadState(state);
		return this;
	}


	public Piece addPiece(PiecesEnum piece, Color color, Position pos) {//TODO: switch mit enum zum createn
		switch (piece) {
			case PAWN:
				return getSquare(pos).setPiece(new Pawn(color, pos));
			case KNIGHT:
				return getSquare(pos).setPiece(new Knight(color, pos));
			case BISHOP:
				return getSquare(pos).setPiece(new Bishop(color, pos));
			case ROOK:
				return getSquare(pos).setPiece(new Rook(color, pos));
			case QUEEN:
				return getSquare(pos).setPiece(new Queen(color, pos));
			case KING:
				return getSquare(pos).setPiece(new King(color, pos));
			/*	break;
			case EMPTY:
				getSquare(pos).setPiece(null);*/
		}
		return null;
	}

	public Piece addPiece(PiecesEnum piece, Color color, int x, int y) {
		return addPiece(piece, color, new Position(x, y));
	}

	public void clearSquare(int x, int y) {
		getSquare(x, y).setPiece(null);
	}

	public Piece getPiece(Position position) {
		return getSquare(position).getPiece();//FIXME: nullchecks & co
	}

	public Piece getPiece(int x, int y) {
		return getPiece(new Position(x, y));
	}

	public Square getSquare(int x, int y) {//TODO: clone returnen; statt getState und squares[][] benutzen
		return squares[7-y][x];//durch umgedrehtes Array x & y vertauscht?
	}

	public Square getSquare(Position position) {
		return squares[7-position.getY()][position.getX()];
	}

	public void move(Piece piece, Position dest) throws IllegalMoveException {
		if (piece.canMove(dest)) {
			Position current = piece.getPosition();
			Square square = getSquare(current);
			square.setPiece(null);
			piece.setPosition(dest);
			square = getSquare(dest);
			square.setPiece(piece);
		} else {
			//System.out.println("ERROR in Board.move()");//TODO: logger
			throw new IllegalMoveException("This is not a valid move");
		}
	}

	public void move(Piece piece, int x, int y) throws IllegalMoveException{
		move(piece, new Position(x, y));
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
				if (current.equals("em")) {
					k++;
					continue;
				}
				Color color = current.substring(0,1).equals("w") ? Color.WHITE : Color.BLACK;
				switch (current.substring(1,2)) {
					case "p":
						addPiece(PAWN, color, 7-j, 7-i);
						break;
					case "n":
						addPiece(KNIGHT, color, 7-j, 7-i);
						break;
					case "b":
						addPiece(BISHOP, color, 7-j, 7-i);
						break;
					case "r":
						addPiece(ROOK, color, 7-j, 7-i);
						break;
					case "q":
						addPiece(QUEEN, color, 7-j, 7-i);
						break;
					case "k":
						addPiece(KING, color, 7-j, 7-i);
						break;
					default:
						throw new IllegalArgumentException("can't parse given state");
				}
				k++;
			}
		}
	}

	public String saveState() {
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
	}

	@Override
	public String toString() {
		StringBuilder board = new StringBuilder();
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (j == 0) {
					board.append(i+1).append(" ");
				}
				board.append(getSquare(j, i).toString());
			}
			board.append("\n");
		}
		board.append("   \t\t A\t\t\t    B\t\t\t   C\t\t\t  D\t\t\t    E\t\t\t   F\t\t\t   G\t\t\t   H");
		return board.toString();
	}
}
