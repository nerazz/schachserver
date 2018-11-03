package board;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pieces.*;
import players.Color;

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

	public Board addPieces() {
		add(Color.WHITE);
		add(Color.BLACK);
		return this;
	}

	private void add(Color color) {
		Position p;
		int row;
		row = (color == Color.WHITE) ? 1 : 6;

		for (int i = 0; i < 8; i++) {
			p = new Position(i, row);
			get(p).setPiece(new Pawn(color, p));
		}
		row = (color == Color.WHITE) ? 0 : 7;
		p = new Position(0, row);
		get(p).setPiece(new Rook(color, p));
		p = new Position(7, row);
		get(p).setPiece(new Rook(color, p));
		p = new Position(1, row);
		get(p).setPiece(new Knight(color, p));
		p = new Position(6, row);
		get(p).setPiece(new Knight(color, p));
		p = new Position(2, row);
		get(p).setPiece(new Bishop(color, p));
		p = new Position(5, row);
		get(p).setPiece(new Bishop(color, p));
		p = new Position(3, row);
		get(p).setPiece(new Queen(color, p));
		p = new Position(4, row);
		get(p).setPiece(new King(color, p));

	}

	public void set(Piece piece, Color color, ) {//TODO: switch mit enum zum createn
		get(p).setPiece();
	}

	public Piece getPiece(Position position) {
		//System.out.println(squares[position.getX()][position.getY()].getPiece());
		System.out.println(get(position));
		return get(position).getPiece();//FIXME: nullchecks & co
	}

	public Square get(int x, int y) {//TODO: clone returnen; statt getState und squares[][] benutzen
		return squares[7-y][x];//durch umgedrehtes Array x & y vertauscht?
	}

	public Square get(Position position) {
		return squares[7-position.getY()][position.getX()];
	}

	public void move(Piece piece, Position dest) {
		if (piece.isValid(dest)) {
			Position current = piece.getPosition();
			Square square = get(current);
			square.setPiece(null);
			piece.setPosition(dest);
			square = get(dest);//FIXME: muss transformiert werden
			square.setPiece(piece);
		} else {
			System.out.println("ERROR in Board.move()");//TODO: logger
		}
	}

	public void load(String boardState) {//TODO: parse from json (vor allem für tests?)
		Gson gson = new GsonBuilder().create();
		BoardState bs = gson.fromJson(boardState, BoardState.class);
		System.out.println(bs.getState());
	}

	public String save() {
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
				board.append(get(j, i).toString());
			}
			board.append("\n");
		}
		board.append("   \t\t A\t\t\t    B\t\t\t   C\t\t\t  D\t\t\t    E\t\t\t   F\t\t\t   G\t\t\t   H");
		return board.toString();
	}
}
