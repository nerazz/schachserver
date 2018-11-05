package pieces;

import board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import players.Color;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
	private Board b;

	@BeforeEach
	void setupBoard() {
		b = new Board();
		b.addPiece(PiecesEnum.PAWN, Color.WHITE, 0, 0);
	}

	@Test
	void isValid() {
	}
}