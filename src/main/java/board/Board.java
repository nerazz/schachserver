package board;


import pieces.*;
import players.Player;
import players.PlayerColor;

/**
 * created on: 02.11.18
 */

public class Board {
	private final Field[][] state = new Field[8][8];//[x][y]

	public Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				state[i][j] = new Field(new Position(i, j));
			}
		}
		init();
	}

	public void init() {
		Piece.setBoard(this);
		for (int i = 0; i < 8; i++) {
			add("pawn", PlayerColor.WHITE, 1, i);
			add("pawn", PlayerColor.BLACK, 6, i);
		}
		add("rook", PlayerColor.WHITE, 0, 0);
		add("rook", PlayerColor.BLACK, 7, 0);
		add("king", PlayerColor.WHITE, 0, 0);

	}

	//put(new Rook(PlayerColor.WHITE, 0, 0);
	//add(Rook, PlayerColor.WHITE, 0, 0);
    /*private void put(Piece piece, int x, int y) {
        state[x][y].put()

    }*/

	private void add(String p, PlayerColor color, int x, int y) {//IDEA wäre nicer mit Piece-factory-pattern
		Position coord = new Position(x, y);
		switch (p) {
			case "pawn":
				state[x][y].put(new Pawn(color, coord));
				break;
			case "knight":
				state[x][y].put(new Knight(color, coord));
				break;
			case "bishop":
				state[x][y].put(new Bishop(color, coord));
				break;
			case "rook":
				state[x][y].put(new Rook(color, coord));
				break;
			case "queen":
				state[x][y].put(new Queen(color, coord));
				break;
			case "king":
				state[x][y].put(new King(color, coord));
				break;
			default:
				System.out.println("ERROR in Board.add()");//TODO: LOGGER


		}
	}

	public Piece getPiece(Position position) {
		System.out.println(state[position.getX()][position.getY()].getPiece());
		return state[position.getX()][position.getY()].getPiece();//FIXME: nullchecks & co
	}

	public Field get(int x, int y) {//TODO: clone returnen; statt getState und state[][] benutzen
		return state[y][x];//durch umgedrehtes Array x & y vertauscht?
	}

	public Field[][] getState() {//TODO: durch get ersetzen
		return state.clone();
	}

	public void move(Piece piece, Position dest) {
		if (/*piece.valid(dest)*/ true) {
			Position current = piece.getCurrent();
			Field field = state[current.getX()][current.getY()];
			field.setPiece(null);
			field.setOwner(Owner.EMPTY);
			piece.setPosition(dest);
			field = state[dest.getX()][dest.getY()];
			field.setPiece(piece);
			Owner owner = (piece.getColor() == PlayerColor.WHITE) ? Owner.WHITE : Owner.BLACK;//TODO: enums besser überlegen
			field.setOwner(owner);
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
				board.append(state[7-i][j].toString());
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
				board.append(state[i][j].toString());
			}
			board.append("\n");
		}
		board.append("   A  B  C  D  E  F  G  H");
		return board.toString();
	}
}
