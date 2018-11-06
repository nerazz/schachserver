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
		b.addPiece(KNIGHT, WHITE, 1,2);
		assertFalse(p.canMove(1,2), "white pawn blocked by white");
		b.addPiece(KNIGHT, BLACK, 1,2);
		assertFalse(p.canMove(1,2), "white pawn blocked by black");

		b.addPiece(PAWN, BLACK, 1, 6);
		b.addPiece(KNIGHT, BLACK, 1,5);
		assertFalse(p.canMove(1,5), "black pawn blocked by black");
		b.addPiece(KNIGHT, WHITE, 1,5);
		assertFalse(p.canMove(1,5), "black pawn blocked by white");
	}


	@Test
	void takes() {
		b.addPiece(QUEEN, BLACK, 0,2);
		b.addPiece(QUEEN, BLACK, 2,2);
		//b.addPiece(QUEEN, BLACK, );
		assertTrue(p.canMove(0,2), "white pawn can take diagonal left");
		assertTrue(p.canMove(2,2), "white pawn can take diagonal right");

		b.addPiece(PAWN, BLACK, 1, 6);
		b.addPiece(QUEEN, BLACK, 0,2);
		b.addPiece(QUEEN, BLACK, 0,3);
		assertTrue(p.canMove(0,2));
		assertTrue(p.canMove(0,3));
	}

	@Test
	void canMoveTwoSquaresOnFirstMove() {
		assertTrue(p.canMove(1,3), "can move two squares on first move");
		assertDoesNotThrow(() -> b.move(p, 1,3));
		assertFalse(p.canMove(1,5), "can't move two squares on second move");
	}

	//TODO: tests for black
	//TODO: upgrade
	//TODO: en passant


}