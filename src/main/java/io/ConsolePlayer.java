package io;

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

	public static int[] readMove() {
		//TODO: regex für move parsen?
		String in = "";
		try {
			in = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//a3 e4
		char[] chars = in.toCharArray();
		int[] nums = new int[4];
		nums[0] = chars[0] - 97;
		nums[1] = chars[1] - 49;
		nums[2] = chars[3] - 97;
		nums[3] = chars[4] - 49;
		return nums;
	}

}
