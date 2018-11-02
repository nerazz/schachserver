package board;


import pieces.*;
import players.Player;
import players.PlayerColor;

/**
 * created on: 02.11.18
 */

public class Board {
	private final Field[][] state = new Field[8][8];//[x][y]
	private final Player white;
	private final Player black;

	public Board(Player white, Player black) {
		this.white = white;
		this.black = black;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				state[i][j] = new Field(i, j);
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

	}

	//put(new Rook(PlayerColor.WHITE, 0, 0);
	//add(Rook, PlayerColor.WHITE, 0, 0);
    /*private void put(Piece piece, int x, int y) {
        state[x][y].put()

    }*/

	private void add(String p, PlayerColor color, int x, int y) {//IDEA wäre nicer mit Piece-factory-pattern
		Coordinate coord = new Coordinate(x, y);
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
				System.out.println("ERROR in Board.java in add()");//TODO: LOGGER


		}
	}

	public Field[][] getState() {
		return state.clone();
	}

	@Override
	public String toString() {
		StringBuilder board = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == 0) {
					board.append(7-i).append(" ");
				}
				board.append(state[7-i][j].toString());
			}
			board.append("\n");
		}
		board.append("   A  B  C  D  E  F  G  H");
		return board.toString();
	}
}
