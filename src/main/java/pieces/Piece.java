package pieces;

/**
 * created on: 02.11.18
 */

public class Piece {

        private Board board; // Jeder Spieler hat eogenes Board um Spielstand zu überprüfen

    public int valid (Coodinate xy) {
        if (validmoves.contains(xy))
            return 1;
        else return -1;
    }
}
