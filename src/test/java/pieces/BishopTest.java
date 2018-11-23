package pieces;

import board.Board;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static board.Piece.*;
import static org.junit.jupiter.api.Assertions.*;
import static players.Color.BLACK;
import static players.Color.WHITE;

class BishopTest {

	private static Board b;

	@BeforeAll
	static void setup() {
		b = new Board();
		String state =
				  "----------------" //7
				+ "----------------" //6
				+ "--BP------------" //5
				+ "----BP----------" //4
				+ "--BP--WB--------" //3
				+ "----------------" //2
				+ "----------WP----" //1
				+ "BP----------BP--";//0
				// 0 1 2 3 4 5 6 7
		b.loadState(state);
	}

	@Test
	void moves() {
		assertTrue(b.isValidMove(3, 3, 4, 4), "can move diagonal (up right)");
		assertTrue(b.isValidMove(3, 3, 2, 2), "can move diagonal (down left)");
		assertTrue(b.isValidMove(3, 3, 4, 2), "can move diagonal (down right)");
		assertFalse(b.isValidMove(3, 3, 4, 3), "can't move straight");
	}

	@Test
	void takes() {
		assertTrue(b.isValidMove(3, 3, 2, 4), "can take near diagonal");
		assertTrue(b.isValidMove(3, 3, 0, 0), "can take far diagonal");
		assertFalse(b.isValidMove(3, 3, 1, 5), "can't take over enemy");
		assertFalse(b.isValidMove(3, 3, 6, 0), "can't take over own");
		assertFalse(b.isValidMove(3, 3, 1, 3), "can't take straight");
	}
}