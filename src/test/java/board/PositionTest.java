package board;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
	private Position p0;

	@BeforeEach
	void setupPositions() {//TODO: eher BeforeAll
		p0 = new Position(1, 3);//b4
	}

	@Test
	void constructorTest() {//nichts so sinnvoll bisher, vielleicht anders testen?
		p0 = new Position(1, 3);
		assertEquals(1, p0.getX());
		assertEquals(3, p0.getY());
	}

	@Test
	void getX() {
		assertEquals(1, p0.getX());
	}

	@Test
	void getY() {
		assertEquals(3, p0.getY());
	}

	@Test
	void toStringTest() {
		assertEquals("{B,4}", p0.toString());
	}
}