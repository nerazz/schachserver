import board.Board;
import players.Player;
import players.PlayerColor;

public class Main {
    public static void main(String[] args) {
        Player white = new Player(PlayerColor.WHITE);
        Player black = new Player(PlayerColor.BLACK);
        Board b = new Board();
        b.init();
        System.out.println(b.toString());
    }
}
