package players;

/**
 * created on: 02.11.18
 */

public class Player { //IDEA: Black, White extends Player?
	private final Color color;


	public Player (Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
}
