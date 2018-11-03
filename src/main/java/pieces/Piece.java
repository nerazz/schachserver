package pieces;

import board.Board;
import board.Position;
import players.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * created on: 02.11.18
 */

public abstract class Piece {

	private static Board board; // Jeder Spieler hat eogenes Board um Spielstand zu überprüfen?
	List<Position> validMoves = new ArrayList<>();
	private final Color color;
	private Position position;


	protected Piece(Color color, Position position) {
		this.color = color;
		this.position = position;

	}

	public static void setBoard(Board b) {
		board = b;
	}

	public void setPosition(Position c) {
		position = c;
	}

	public Position getPosition() {
		return position;
	}


	public Color getColor() {
		return color;
	}

	Board getBoard() {
		return board;
	}//TODO: möglichst ohne board

	public boolean isValid(Position xy) {
		System.out.println("isValid moves for " + this.position + ": " + validMoves);
		if (validMoves.contains(xy)) {

			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String s = (color == Color.WHITE) ? "W" : "B";
		s += this.getClass().getSimpleName().substring(0,4);
		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Piece)) {
			return false;
		}
		Piece p = (Piece)o;
		return (color == p.getColor() && position.equals(p.getPosition()));
	}
}
