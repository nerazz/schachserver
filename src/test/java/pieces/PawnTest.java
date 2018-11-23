package pieces;

import board.Board;
import board.Move;
import board.Position;
import board.Square;
import io.Game;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static board.Piece.*;
import static org.junit.jupiter.api.Assertions.*;
import static players.Color.*;

class PawnTest {
	private static Board board;

	@BeforeAll
	static void setup() {
		board = new Board();
		String state =
				  "----------------"
				+ "--------BP--BP--"
				+ "--------WQ------"
				+ "----------------"
				+ "BQBQBQ----------"
				+ "--WP------------"
				+ "------------WP--"
				+ "----------------";
		board.loadState(state);
	}

	@Test
	void moves() {
		assertTrue(board.isValidMove(6, 1, 6, 2), "white can move forwards");
		assertTrue(board.isValidMove(6, 1, 6, 0), "white can't move backwards");
		assertTrue(board.isValidMove(6, 6, 6, 5), "black can move forwards");
		assertTrue(board.isValidMove(6, 6, 6, 7), "black can't move backwards");
	}

	@Test
	void takes() {
		assertTrue(board.isValidMove(1, 2, 0, 3), "can take diagonal left");
		assertTrue(board.isValidMove(1, 2, 2, 3), "can take diagonal right");
		assertFalse(board.isValidMove(1, 2, 1, 3), "white can't take in front");
		assertFalse(board.isValidMove(4, 6, 4, 5), "black can't take in front");
	}

	@Test
	void special() {
		assertTrue(board.isValidMove(6, 1, 6, 3), "white can move 2 on first move");
		/*Move m = new Move(new Position(6, 1), new Position(6, 3));
		assertTrue(board.move(m));
		assertTrue(board.isValidMove(6, 3, 6, 5), "white can't move 2 on first move");*/

		assertTrue(board.isValidMove(6, 6, 6, 4), "black can move 2 on first move");
		/*m = new Move(new Position(6, 6), new Position(6, 4));
		assertTrue(board.move(m));
		assertTrue(board.isValidMove(6, 4, 6, 2), "black can't move 2 on first move");*/
	}

	//TODO: upgrade
	//TODO: en passant


}