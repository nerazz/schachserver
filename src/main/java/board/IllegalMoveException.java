package board;

/**
 * @author Niklas Zd
 * @since 06.11.2018
 */
public class IllegalMoveException extends Exception{

	public IllegalMoveException() {
		super();
	}

	public IllegalMoveException(String errorMessage) {
		super(errorMessage);
	}

	public IllegalMoveException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

	IllegalMoveException(Throwable cause) {
		super(cause);
	}

}
