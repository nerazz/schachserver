package players;


import board.Move;
import board.Position;
import io.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Niklas Zd
 * @since 09.11.2018
 */
public class SocketPlayer extends Player implements Runnable {
	private static Server server;//TODO: ohne server static; andere idee zum closen
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private Integer id;

	public SocketPlayer(Socket socket, Integer id) {
		this.socket = socket;
		this.id = id;
	}

	public static void initServer(Server server) {
		SocketPlayer.server = server;
	}

	@Override
	public void run() {//TODO: send status premoved
		try {
			System.out.println("start run for " + socket);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			System.out.println("created in, out for " + this);
			String inputLine;
			while ((inputLine = in.readLine()) != null && !out.checkError()) {
				System.out.println("received \"" + inputLine + "\" from " + socket);
				parseMove(inputLine);
				//out.println(inputLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		stop();
	}

	public void stop() {
		try {
			in.close();
			out.close();
			socket.close();
			server.closeSocket(id);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/*public void parseMove(String moveToParse) {//JSON-Moves;TODO: geht locker besser
		Gson gson = new GsonBuilder().create();
		JsonMove jsonMove = gson.fromJson(moveToParse, JsonMove.class);

		int x = jsonMove.move[0].charAt(0) - 97;
		int y = jsonMove.move[0].charAt(1) - 49;
		Position src = new Position(x, y);
		x = jsonMove.move[1].charAt(0) - 97;
		y = jsonMove.move[1].charAt(1) - 49;
		Position dst = new Position(x, y);
		Move move = new Move(src, dst);
		System.out.println("parsed move: " + move.toString());
		super.setMove(move);
		super.setMoved(true);
	}*/

	public void parseMove(String moveToParse) {
		if (moveToParse.equals("surrender")) {
			//TODO
		}
		char[] chars = moveToParse.toCharArray();
		Position src = new Position(chars[0] - 97, chars[1] - 49);
		Position dst = new Position(chars[3] - 97, chars[4] - 49);
		Move move = new Move(src, dst);
		System.out.println("parsed move: " + move.toString());
		super.setMove(move);
		super.setStoredMove(true);
	}

	@Override
	public void success() {
		System.out.println("sending successful");
		out.println("{status: \"success\", state: " + server.getBoardStateJson() + "}");
		setStoredMove(false);
	}

	@Override
	public void fail() {
		System.out.println("sending fail");
		out.println("{status: \"refused\", state: " + server.getBoardStateJson() + "}");
		setStoredMove(false);
	}
}
