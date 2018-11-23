package pieces;

import board.Board;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenTest {

	private static Board b;

	@BeforeAll
	static void setup() {
		b = new Board();
		String state =
				  "------BP--------" //7
				+ "----------------" //6
				+ "----------------" //5
				+ "----BP----------" //4
				+ "--WP--WQ--WP--BP" //3
				+ "------BP--------" //2
				+ "----------WP----" //1
				+ "------BP----BP--";//0
				// 0 1 2 3 4 5 6 7
		b.loadState(state);
	}

	@Test
	void moves() {
		assertTrue(b.isValidMove(3, 3, 3, 6), "can move upwards");
		assertTrue(b.isValidMove(3, 3, 4, 3), "can move right");
		assertTrue(b.isValidMove(3, 3, 5, 5), "can move diagonal");
		assertFalse(b.isValidMove(3, 3, 0, 3), "can't move through own pieces");
		assertFalse(b.isValidMove(3, 3, 3, 1), "can't move through enemy pieces straight");
		assertFalse(b.isValidMove(3, 3, 1, 5), "can't move through enemy pieces diagonal");
	}

	@Test
	void takes() {
		assertTrue(b.isValidMove(3, 3, 3, 2), "can take downward near");
		assertTrue(b.isValidMove(3, 3, 3, 7), "can take upward far");
		assertTrue(b.isValidMove(3, 3, 2, 4), "can take diagonal");
		assertFalse(b.isValidMove(3, 3, 3, 0), "can't take straight through enemy piece");
		assertFalse(b.isValidMove(3, 3, 7, 3), "can't take straight through own piece");
		assertFalse(b.isValidMove(3, 3, 6, 0), "can't take diagonal through own piece");
	}

}