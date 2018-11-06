import board.Board;
import board.IllegalMoveException;
import board.Position;
import io.Console;

public class Main {
	public static void main(String[] args) {
		Board b = new Board().initWithPieces();
		System.out.println(b.toString());

		Console.init();

		for(;;) {
			int[] nums = Console.readMove();
			Position source = new Position(nums[0], nums[1]);
			Position dest = new Position(nums[2], nums[3]);
			System.out.println("source: " + source.toString());
			System.out.println("dest: " + dest.toString());
			try {
				b.move(b.getPiece(source), dest);
			} catch (IllegalMoveException e) {
				e.printStackTrace();
			}
			System.out.println(b.toString());
		}
	}
}
