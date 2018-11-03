package pieces;

import board.Board;
import board.Position;
import players.PlayerColor;

import java.util.ArrayList;
import java.util.List;

/**
 * created on: 02.11.18
 */

public abstract class Piece {

	private static Board board; // Jeder Spieler hat eogenes Board um Spielstand zu überprüfen
	public List<Position> validmoves = new ArrayList<Position>();
	private final PlayerColor color;
	private boolean hasMoved = false;
	private Position current_position;
	private Position new_position;


	protected Piece(PlayerColor color, Position current) {
		this.color = color;
		current_position = current;

	}

	public static void setBoard(Board b) {
		board = b;
	}

	public void setPosition(Position c) {
		current_position = c;
		//FIXME: hasMoved wofür? muss vielleicht hier true gesetzt werden
	}

	public Position getCurrent() {
		return current_position;
	}


	public PlayerColor getColor() {
		return color;
	}

	Board getBoard() {
		return board;
	}

	public boolean valid(Position xy) {
		System.out.println("valid moves for " + this.current_position + ": " + validmoves);
		if (validmoves.contains(xy)) {

			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		s = (color == PlayerColor.WHITE) ? "W" : "B";
		s += this.getClass().getSimpleName();
		return s;
	}
}
