package players;

import board.Move;

/**
 * created on: 02.11.18
 */

public abstract class Player {
	private Move move;
	private boolean hasStoredMove = false;//nur in SocketPlayer?
	private boolean hasMoved = false;
	private Object lock;

	public void setLock(Object lock) {
		this.lock = lock;
	}

	public boolean hasMoved() {
		return hasMoved;
	}

	public void resetMoved() {
		hasMoved = false;
	}

	public void setMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public void setStoredMove(boolean stored) {
		if (stored) {
			synchronized (lock) {
				lock.notifyAll();//TODO: needs synchronized?
			}
		}
		hasStoredMove = stored;
	}

	public boolean hasStoredMove() {
		return hasStoredMove;
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public void success() {//successful move

	}

	public void fail() {//failed move

	}
}
