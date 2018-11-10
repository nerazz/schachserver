package board;


/**
 * @author Niklas Zd
 * @since 09.11.2018
 */
public class Move {
	private final Position SOURCE;
	private final Position DESTINATION;

	public Move(Position source, Position destination) {
		SOURCE = source;
		DESTINATION = destination;
	}

	public Position getSrc() {
		return SOURCE;
	}

	public Position getDst() {
		return DESTINATION;
	}

	@Override
	public String toString() {
		return String.format("%s -> %s", SOURCE.toString(), DESTINATION.toString());
	}
}
