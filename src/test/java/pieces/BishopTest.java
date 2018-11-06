package pieces;

import board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pieces.PiecesEnum.*;
import static players.Color.BLACK;
import static players.Color.WHITE;

class BishopTest {

	private Board b;
	private Piece p;

	@BeforeEach
	void setupBoard() {
		b = new Board();
		p = b.addPiece(BISHOP, WHITE, 3, 3);
	}

	@Test
	void moves() {
		assertTrue(p.canMove(2,2));
		assertTrue(p.canMove(1,1));
		assertTrue(p.canMove(4,4));
		assertTrue(p.canMove(5,5));
		assertTrue(p.canMove(7,7));
		assertTrue(p.canMove(4,2));
		assertTrue(p.canMove(5,1));
		assertTrue(p.canMove(0,6));
		assertFalse(p.canMove(1,7));
		assertFalse(p.canMove(2,3));
		assertFalse(p.canMove(3,2));
		assertFalse(p.canMove(0,7));

		b.addPiece(KNIGHT, WHITE, 2,2);
		assertFalse(p.canMove(1,2), "blocked by own color");
		b.addPiece(KNIGHT, WHITE, 5,1);
		assertFalse(p.canMove(5,1), "blocked by own color");

		b.addPiece(KNIGHT, BLACK, 5,5);
		assertFalse(p.canMove(7,7), "blocked by enemy color");

	}


	@Test
	void takes() {
		b.addPiece(QUEEN, BLACK, 6,6);
		b.addPiece(QUEEN, BLACK, 0,0);
		assertTrue(p.canMove(6,6), "can take in one direction");
		assertTrue(p.canMove(0,0), "can take in another direction");
		b.addPiece(QUEEN, WHITE, 0,6);
		assertFalse(p.canMove(0,6), "can't take own piece");
		b.addPiece(QUEEN, WHITE, 5,5);
		assertFalse(p.canMove(6,6), "blocked by own color");
		b.addPiece(QUEEN, BLACK, 5,5);
		assertFalse(p.canMove(6,6), "blocked by enemy color");
	}
}