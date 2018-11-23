import players.ConsolePlayer;
import io.Game;
import players.Player;

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
	}
}
