package board;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Pawn;
import pieces.Piece;
import pieces.Rook;
import players.Color;

import static org.junit.jupiter.api.Assertions.*;
import static pieces.PiecesEnum.*;
import static players.Color.*;

class BoardTest {

	private static Position p0, p1, p2, p3;
	private static Square f0, f1, f2, f3;
	private static Board b;

	@BeforeAll
	static void setupPositions() {
		/*p0 = new Position(0,0);//a1
		p1 = new Position(2,5);//c6
		p2 = new Position(7,3);//h4
		p3 = new Position(6,6);//g7

		f0 = new Square(p0);
		b.addPiece(ROOK, WHITE, 0, 0);
		f1 = new Square(p1);
		f2 = new Square(p2);
		f3 = new Square(p3);
		b.addPiece(PAWN, BLACK, 6, 6);*/

	}

	@BeforeEach
	void setupBoard() {
		b = new Board();
	}

	@Test
	void getPiece() {
		//assertEquals();
	}

	@Test
	void get() {
		/*assertEquals(f0, b.getSquare(0,0));
		assertEquals(f1, b.getSquare(2,5));
		assertEquals(f2, b.getSquare(7,3));
		assertEquals(f3, b.getSquare(6,6));*/
	}

	@Test
	void piecesOnlyMoveOnLegalMove() {
		b.addPiece(PAWN, WHITE, 1, 1);
		Piece p = b.getPiece(1, 1);
		assertDoesNotThrow(() -> b.move(p, 1, 2));
		assertEquals(p, b.getPiece(1,2), "can move");
		assertThrows(IllegalMoveException.class, () -> b.move(p, 5, 6),
				"white pawn cant move there");
		assertEquals(p, b.getPiece(1,2), "Pawn is still on old square");
		b.addPiece(KNIGHT, BLACK, 1,3);
		assertThrows(IllegalMoveException.class, () -> b.move(p, 1,3),
				"white pawn blocked by black shouldn't be able to move");
		assertEquals(p, b.getPiece(1,2), "Pawn is still on old square");
		b.clearSquare(1,3);
		assertDoesNotThrow(() -> b.move(p, 1, 3));
		assertEquals(p, b.getPiece(1,3), "can move after exception");
	}

}