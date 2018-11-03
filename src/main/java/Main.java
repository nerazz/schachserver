import board.Board;
import io.Console;

public class Main {
	public static void main(String[] args) {
		Board b = new Board().addPieces();
		System.out.println(b.toString());

		Console.init();

		/*for(;;) {
			int[] nums = Console.readMove();
			Position source = new Position(nums[0], nums[1]);
			Position dest = new Position(nums[2], nums[3]);
			System.out.println("source: " + source.toString());
			System.out.println("dest: " + dest.toString());
			b.move(b.getPiece(source), dest);
			System.out.println(b.toString());
		}*/
		System.out.println(b.save());
	}
}
