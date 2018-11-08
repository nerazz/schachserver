package pieces;

import board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static players.Color.WHITE;
import static players.Color.BLACK;

class RookTest {

	/*private Board b;
	private Piece p;

	@BeforeEach
	void setupBoard() {
		b = new Board();
		p = b.addPiece(ROOK, WHITE, 3, 3);
	}

	@Test
	void moves() {
		assertTrue(p.canMove(2,3));
		assertTrue(p.canMove(1,3));
		assertTrue(p.canMove(3,5));
		assertTrue(p.canMove(3,1));

		assertFalse(p.canMove(3,3));
		assertFalse(p.canMove(2,2));
		assertFalse(p.canMove(5,2));

		b.addPiece(ROOK, WHITE, 3,4);
		assertFalse(p.canMove(3,5), "can't move through own color");
		b.addPiece(ROOK, BLACK, 3,4);
		assertFalse(p.canMove(3,5), "can't move through enemy color");
	}

	@Test
	void takes() {
		b.addPiece(ROOK, BLACK, 2,3);
		assertTrue(p.canMove(2,3), "can take enemy");
		b.addPiece(ROOK, WHITE, 3,4);
		assertFalse(p.canMove(3,4), "can't take own color");
		b.addPiece(ROOK, BLACK, 3,5);
		assertFalse(p.canMove(3,5),"can't take through own color");
		b.addPiece(ROOK, BLACK, 3,4);
		assertFalse(p.canMove(3,5),"can't take through enemy color");
	}*/

}