package io;


import board.Board;
import board.Move;
import players.ConsolePlayer;
import players.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static io.GameState.*;

/**
 * @author Niklas Zd
 * @since 08.11.2018
 */
public class Game implements Runnable {
	private int players = 0;
	private Board board = new Board();
	private Player white, black;
	private GameState state = WAITING_FOR_PLAYER;
	private final Object LOCK = new Object();

	public void addPlayer(Player player) {
		players++;
		switch (players) {//TODO: random white+black
			case 1:
				white = player;
				white.setLock(LOCK);
				System.out.println("1/2 players");
				break;
			case 2:
				black = player;
				black.setLock(LOCK);
				System.out.println("2/2 players, starting game...");
				ExecutorService es = Executors.newSingleThreadExecutor();//TODO: hier und wirklich in extrathread?
				es.execute(this);
				break;
			default:
				throw new IllegalStateException("too many players");
		}
	}

	private void rollPlayers() {
		if (Math.random() < 0.5) {
			Player swap = white;
			white = black;
			black = swap;
		}
	}

	@Override
	public void run() {
		rollPlayers();
		startGame();
	}

	public String getBoardStateJson() {
		return board.saveStateToJson();
	}

	public void startGame() {
		board.initWithPieces();
		state = TURN_WHITE;
		Player current = white;
		Move move;
		boolean nextPlayer;
		while (state != WIN_WHITE && state != WIN_BLACK) {
			nextPlayer = false;
			System.out.println("STATE: " + state.toString());
			System.out.println(board.toString());
			while(!nextPlayer) {
				//start für local:
				((ConsolePlayer)current).readMove();
				//end
				synchronized (LOCK) {
					while (!current.hasStoredMove()) {
						try {
							LOCK.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				move = current.getMove();
				if (board.isValidMove(move)) {
					board.move(move);
					current.success();
					//TODO: hier checken, ob gewonnen wurde
					//board.checkIfCheckOrMate
					if (state == TURN_WHITE) {
						current = black;
						state = TURN_BLACK;
					} else if (state == TURN_BLACK) {
						current = white;
						state = TURN_WHITE;
					}
					else
						throw new IllegalStateException("ERROR in Game.startGame().turn");
					nextPlayer = true;
				} else {
					current.fail();
				}
				System.out.println("----------round end------------");
			}
		}
	}
}
