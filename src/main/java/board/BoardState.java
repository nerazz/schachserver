package board;

/**
 * created on: 03.11.18
 */

class BoardState {
	private String[][] state;

	void setState(String[][] state) {
		this.state = state;
	}

	String[][] getState() {
		return state;
	}
}
