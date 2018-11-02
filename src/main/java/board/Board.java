package board;


/**
 * created on: 02.11.18
 */

public class Board {
    private Field[][] fields = new Field[8][8];

    public void init() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                fields[i][j] = new Field();

            }
        }
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    board.append(i).append(" ");
                }
                board.append(fields[i][j].toString());
            }
            board.append("\n");
        }
        board.append("   A  B  C  D  E  F  G  H");
        return board.toString();
    }
}
