package board;


import players.Player;

/**
 * created on: 02.11.18
 */

public class Board {
    private final Field[][] state = new Field[8][8];
    private final Player white;
    private final Player black;

    public Board(Player white, Player black) {
        this.white = white;
        this.black = black;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                state[i][j] = new Field(i, j);
            }
        }
    }

    public Field[][] getState() {
        return state.clone();
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    board.append(i+1).append(" ");
                }
                board.append(state[i][j].toString());
            }
            board.append("\n");
        }
        board.append("   A  B  C  D  E  F  G  H");
        return board.toString();
    }
}
