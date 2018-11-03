package board;


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
		init();
	}

	private void init() {
		Piece.setBoard(this);
		Position p;
		for (int i = 0; i < 8; i++) {
			p = new Position(i, 1);
			get(p).setPiece(new Pawn(Color.WHITE, p));
			p = new Position(i, 6);
			get(p).setPiece(new Pawn(Color.BLACK, p));
		}
		p = new Position(0, 0);
		get(p).setPiece(new Rook(Color.WHITE, p));

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

	@Override
	public String toString() {
		StringBuilder board = new StringBuilder();
		/*for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == 0) {
					board.append(8-i).append(" ");
				}
				board.append(squares[7-i][j].toString());
			}
			board.append("\n");
		}
		board.append("   A  B  C  D  E  F  G  H");
		return board.toString();StringBuilder board = new StringBuilder();*/
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (j == 0) {
					board.append(i+1).append(" ");
				}
				board.append(get(j, i).toString());
			}
			board.append("\n");
		}
		board.append("   A  B  C  D  E  F  G  H");
		return board.toString();
	}
}
