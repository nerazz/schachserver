package pieces;

import board.Board;
import board.IllegalMoveException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pieces.PiecesEnum.*;
import static players.Color.*;

class PawnTest {
	private Board b;
	private Piece p;

	@BeforeEach
	void setupBoard() {
		b = new Board();
		b.addPiece(PAWN, WHITE, 1, 1);
		p = b.getPiece(1,1);
	}

	@Test
	void moves() {
		assertDoesNotThrow(() -> b.move(p, 1, 2));
		assertEquals(p, b.getPiece(1,2), "can move");
		b.addPiece(KNIGHT, WHITE, 1,3);
		assertThrows(IllegalMoveException.class, () -> b.move(p, 1,3),
				"white pawn blocked by white");
		b.addPiece(KNIGHT, BLACK, 1,3);
		assertThrows(IllegalMoveException.class, () -> b.move(p, 1,3),
				"white pawn blocked by black");
	}


	@Test
	void takes() {
		b.addPiece(QUEEN, BLACK, 0,2);
		b.addPiece(QUEEN, BLACK, 1,3);
		assertDoesNotThrow(() -> b.move(p, 0,2));
		assertDoesNotThrow(() -> b.move(p, 1,3));
	}

	@Test
	void canMoveTwoSquaresOnFirstMove() {
		assertDoesNotThrow(() -> b.move(p, 1,3), "can move two squares on first move");
		assertThrows(IllegalMoveException.class, () -> b.move(p, 1, 5), "can't move two squares on second move");
	}

	//TODO: tests for black
	//TODO: upgrade
	//TODO: en passant


}