import board.Board;
import io.ConsolePlayer;
import io.Game;
import io.Server;
import players.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		ConsolePlayer.init();
		/*Server server = new Server();
		ExecutorService es = Executors.newSingleThreadExecutor();//IDEA: server auf mainthread?
		es.execute(server);*/
		Player one = new ConsolePlayer();
		Player two = new ConsolePlayer();
		Game game = new Game();
		game.addPlayer(one);
		game.addPlayer(two);


		/*for(;;) {
			int[] nums = ConsolePlayer.readMove();
			Position source = new Position(nums[0], nums[1]);
			Position dest = new Position(nums[2], nums[3]);
			board.move(source, dest);
			System.out.println(board.toString());
		}*/
	}
}
