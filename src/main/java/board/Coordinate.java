package board;

/**
 * created on: 02.11.18
 */

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate)) {
            return false;
        }
        return (((Coordinate)o).x == x && ((Coordinate)o).y == y);
    }

    @Override
    public String toString() {
        char cx = (char)(x + 65);
        return String.format("{%c,%d}", cx, y+1);
    }
}
