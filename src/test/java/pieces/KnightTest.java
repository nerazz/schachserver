package pieces;

import board.Board;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KnightTest {

	private static Board b;

	@BeforeAll
	static void setup() {
		b = new Board();
		String state =
				  "----------------" //7
				+ "----------------" //6
				+ "----------------" //5
				+ "--BP----BP------" //4
				+ "------WN--------" //3
				+ "----------------" //2
				+ "----------BP----" //1
				+ "----------------";//0
				// 0 1 2 3 4 5 6 7
		b.loadState(state);
	}

	@Test
	void moves() {
		assertTrue(b.isValidMove(3, 3, 1, 2), "can move L down left");
		assertTrue(b.isValidMove(3, 3, 5, 4), "can move L top right");
		assertFalse(b.isValidMove(3, 3, 5, 5), "can't move diagonal");
		assertFalse(b.isValidMove(3, 3, 3, 5), "can't move upwards");
	}

	@Test
	void takes() {
		assertTrue(b.isValidMove(3, 3, 1, 4), "can take L top left");
		assertFalse(b.isValidMove(3, 3, 5, 1), "can't take diagonal far");
		assertFalse(b.isValidMove(3, 3, 4, 4), "can't take diagonal near");
	}
}