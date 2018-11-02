package players;

/**
 * created on: 02.11.18
 */

public class Player { //IDEA: Black, White extends Player?
    private final PlayerColor color;


    public Player (PlayerColor color) {
        this.color = color;
    }

    public PlayerColor getColor() {
        return color;
    }
}
