package board;

/**
 * created on: 02.11.18
 */

public class Coordinate {
    private int x = -1;
    private int y = -1;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate)) {
            return false;
        }
        return (((Coordinate)o).x == x && ((Coordinate)o).y == y);
    }
}
