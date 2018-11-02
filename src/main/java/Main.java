import board.Board;
import board.Coordinate;
import input.Console;
import players.Player;
import players.PlayerColor;

public class Main {
	public static void main(String[] args) {
		Player white = new Player(PlayerColor.WHITE);
		Player black = new Player(PlayerColor.BLACK);
		Board b = new Board(white, black);
		System.out.println(b.toString());

		Console.init();

		for(;;) {
			int[] nums = Console.readMove();
			Coordinate source = new Coordinate(nums[0], nums[1]);
			Coordinate dest = new Coordinate(nums[2], nums[3]);
			b.move(b.getPiece(source), dest);
			System.out.println(b.toString());
		}
	}
}
