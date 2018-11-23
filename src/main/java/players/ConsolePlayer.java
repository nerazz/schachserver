package players;

import board.Move;
import board.Position;
import players.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * created on: 02.11.18
 */

public class ConsolePlayer extends Player {
	public static BufferedReader br;

	public static void init() {//FIXME: yikes
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void readMove() {
		//TODO: regex für move parsen?
		String in = "";
		try {
			in = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (in.equals("surrender")) {
			//TODO
		}
		//a3 e4
		char[] chars = in.toCharArray();
		int[] nums = new int[4];
		nums[0] = chars[0] - 97;
		nums[1] = chars[1] - 49;
		nums[2] = chars[3] - 97;
		nums[3] = chars[4] - 49;
		Position src = new Position(nums[0], nums[1]);
		Position dst = new Position(nums[2], nums[3]);
		super.setMove(new Move(src, dst));
		super.setStoredMove(true);
	}

	@Override
	public void success() {
		System.out.println("move successful");
		setStoredMove(false);
	}

	@Override
	public void fail() {
		System.out.println("move failed");
		setStoredMove(false);
	}



}
