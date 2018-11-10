import board.Board;
import io.ConsolePlayer;
import io.Game;
import io.Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		Board board = new Board().initWithPieces();
		ConsolePlayer.init();
		Game game = new Game(board);

		Server server = new Server(game);
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(server);
		System.out.println(board);


		/*for(;;) {
			int[] nums = ConsolePlayer.readMove();
			Position source = new Position(nums[0], nums[1]);
			Position dest = new Position(nums[2], nums[3]);
			board.move(source, dest);
			System.out.println(board.toString());
		}*/
	}
}
