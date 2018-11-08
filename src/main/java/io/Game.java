package io;


import board.Board;
import players.Color;
import players.Player;

/**
 * @author Niklas Zd
 * @since 08.11.2018
 */
public class Game {
	private int players = 0;
	private Board board;
	private Player white, black;

	public void addPlayer(Player player) {
		players++;
		switch (players) {
			case 1:
				white = player;
				break;
			case 2:
				black = player;
				startGame();
				break;
			default:
				throw new IllegalStateException("too many players");
		}
	}

	private void startGame() {
		board = new Board().initWithPieces();
		if (Math.random() < 0.5) {
			Player swap = white;
			white = black;
			black = swap;
		}
		//TODO: send info to players
	}
}
