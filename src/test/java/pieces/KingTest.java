package pieces;

import board.Board;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingTest {

	private static Board b;

	@BeforeAll
	static void setup() {
		b = new Board();
		String state =
				  "----------------" //7
				+ "----------------" //6
				+ "----------------" //5
				+ "--------BP------" //4
				+ "----BPWK--------" //3
				+ "----------------" //2
				+ "----------------" //1
				+ "--------BR------";//0
				// 0 1 2 3 4 5 6 7
		b.loadState(state);
	}

	@Test
	void moves() {
		assertTrue(b.isValidMove(3, 3, 3, 4), "can move upwards");
		assertTrue(b.isValidMove(3, 3, 2, 2), "can move diagonal");
		assertFalse(b.isValidMove(3, 3, 2, 1), "can't move more squares");
		assertFalse(b.isValidMove(3, 3, 4, 3), "can't move into check");
	}

	@Test
	void takes() {
		assertTrue(b.isValidMove(3, 3, 3, 2), "can take left");
		assertFalse(b.isValidMove(3, 3, 4, 4), "can't take into check");
		assertFalse(b.isValidMove(3, 3, 4, 0), "can't take far");
	}

}