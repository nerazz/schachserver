import board.Board;
import board.Position;
import io.Console;

public class Main {
	public static void main(String[] args) {
		Board b = new Board().initWithPieces();
		Console.init();
		System.out.println(b);

		for(;;) {
			int[] nums = Console.readMove();
			Position source = new Position(nums[0], nums[1]);
			Position dest = new Position(nums[2], nums[3]);
			//System.out.println("source: " + source.toString());
			//System.out.println("dest: " + dest.toString());
			b.move(source, dest);
			System.out.println(b.toString());
		}
	}
}
