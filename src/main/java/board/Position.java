package board;

/**
 * created on: 02.11.18
 */

public class Position {
	private final int X, Y;//letter, number TODO: X to char?

	public Position(int letter, int number) {
		this.X = letter;//wegen umgedrehtem Array müssen hier X & Y vertauscht sein?
		this.Y = number;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Position)) {
			return false;
		}
		return (((Position)o).X == X && ((Position)o).Y == Y);
	}

	@Override
	public String toString() {
		char cx = (char)(X + 65);
		return String.format("(%c,%d)", cx, Y +1);
	}
}
