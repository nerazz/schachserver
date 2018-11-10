package io;


import board.Board;
import board.Move;
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
	private Board board;
	private Player white, black;
	private GameState state = WAITING_FOR_PLAYER;
	private final Object LOCK = new Object();

	public Game(Board board) {
		this.board = board;
	}

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

	@Override
	public void run() {
		startGameNew();
	}

	public void startGameNew() {
		state = TURN_WHITE;
		Player current = white;
		Move move;
		boolean nextPlayer;
		while (state != WIN_WHITE && state != WIN_BLACK) {
			nextPlayer = false;
			System.out.println("STATE: " + state.toString());
			while(!nextPlayer) {

				synchronized (LOCK) {
					while (!current.hasStoredMove()) {
						try {
							LOCK.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				System.out.println("after lock");
				move = current.getMove();
				if (board.isValidMove(move.getSrc(), move.getDst())) {
					board.move(move.getSrc(), move.getDst());
					current.success();
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
					System.out.println("successful move!");
				} else {
					current.fail();
					System.out.println("failed move!");
				}
				System.out.println(board.toString());
				System.out.println("----------round end------------");
			}
		}
	}

	private void startGame() {
		Player current = white;
		Move move;
		boolean done;
		while(state != WIN_WHITE && state != WIN_BLACK) {
			done = false;
			System.out.println("STATE: " + state.toString());
			synchronized (LOCK) {
				while (!current.hasMoved() && !done) {
					try {
						System.out.println("waiting for move");
						LOCK.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("after lock");
					move = current.getMove();
					if (board.isValidMove(move.getSrc(), move.getDst())) {
						board.move(move.getSrc(), move.getDst());
						current.setMoved(false);
						current.success();
						//state = TURN_BLACK;//TODO: geht locker besser, vielleicht mit boolean whitesTurn = !whitesTurn
						if (state == TURN_WHITE) {
							current = black;
							state = TURN_BLACK;
						} else if (state == TURN_BLACK) {
							current = white;
							state = TURN_WHITE;
						}
						else
							throw new IllegalStateException("ERROR in Game.startGame().turn");
						System.out.println("successful move!");
						done = true;
					} else {
						current.setMoved(false);
						current.fail();
						System.out.println("failed move!");
					}
					System.out.println(board.toString());
					System.out.println("----------round end------------");
				}
			}
		}
	}
}
