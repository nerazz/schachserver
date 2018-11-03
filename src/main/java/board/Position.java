package board;

/**
 * created on: 02.11.18
 */

public class Position {
	private final int x, y;//letter, number TODO: x to char?

	public Position(int letter, int number) {
		this.x = 7-number;//wegen umgedrehtem Array müssen hier x & y vertauscht sein?
		this.y = letter;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Position)) {
			return false;
		}
		return (((Position)o).x == x && ((Position)o).y == y);
	}

	@Override
	public String toString() {
		char cx = (char)(x + 65);
		return String.format("{%c,%d}", cx, y+1);
	}
}
