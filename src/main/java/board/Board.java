package board;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pieces.*;
import players.Color;

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
		addColor(Color.WHITE);
		addColor(Color.BLACK);
		return this;
	}

	private void addColor(Color color) {
		Position p;
		int row;
		row = (color == Color.WHITE) ? 1 : 6;

		for (int i = 0; i < 8; i++) {
			p = new Position(i, row);
			getSquare(p).setPiece(new Pawn(color, p));
		}
		row = (color == Color.WHITE) ? 0 : 7;
		addPiece(ROOK, color, 0, row);
		addPiece(KNIGHT, color, 1, row);
		addPiece(BISHOP, color, 2, row);
		addPiece(QUEEN, color, 3, row);
		addPiece(KING, color, 4, row);
		addPiece(BISHOP, color, 5, row);
		addPiece(KNIGHT, color, 6, row);
		addPiece(ROOK, color, 7, row);
	}

	public void addPiece(PiecesEnum piece, Color color, Position pos) {//TODO: switch mit enum zum createn
		switch (piece) {
			case PAWN:
				getSquare(pos).setPiece(new Pawn(color, pos));
				break;
			case KNIGHT:
				getSquare(pos).setPiece(new Knight(color, pos));
				break;
			case BISHOP:
				getSquare(pos).setPiece(new Bishop(color, pos));
				break;
			case ROOK:
				getSquare(pos).setPiece(new Rook(color, pos));
				break;
			case QUEEN:
				getSquare(pos).setPiece(new Queen(color, pos));
				break;
			case KING:
				getSquare(pos).setPiece(new King(color, pos));
			/*	break;
			case EMPTY:
				getSquare(pos).setPiece(null);*/
		}
	}

	public void addPiece(PiecesEnum piece, Color color, int x, int y) {
		addPiece(piece, color, new Position(x, y));
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
		if (piece.isValid(dest)) {
			Position current = piece.getPosition();
			Square square = getSquare(current);
			square.setPiece(null);
			piece.setPosition(dest);
			square = getSquare(dest);//FIXME: muss transformiert werden
			square.setPiece(piece);
		} else {
			//System.out.println("ERROR in Board.move()");//TODO: logger
			throw new IllegalMoveException("This is not a valid move");
		}
	}

	public void move(Piece piece, int x, int y) throws IllegalMoveException{
		move(piece, new Position(x, y));
	}

	public void loadState(String boardState) {//TODO: parse from json (vor allem für tests?)
		Gson gson = new GsonBuilder().create();
		BoardState bs = gson.fromJson(boardState, BoardState.class);
		System.out.println(bs.getState());
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
