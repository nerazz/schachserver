package io;

import board.Board;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created on: 03.11.18
 */

public class Server implements Runnable {
	private ServerSocket server;
	private Map<Integer, SocketPlayer> clients = new HashMap<>();
	private Integer id = 0;
	private Game game;

	public Server(Game game) {
		this.game = game;
	}

	@Override
	public void run() {
		SocketPlayer.initServer(this);
		try {
			server = new ServerSocket(8086);
			ExecutorService es = Executors.newFixedThreadPool(10);
			System.out.println("created server, listening for connections...");
			while (true) {//TODO: shutdown
				java.net.Socket client = server.accept();
				System.out.println("new connection: " + client);
				SocketPlayer socketPlayer = new SocketPlayer(client, id);
				clients.put(id, socketPlayer);
				game.addPlayer(socketPlayer);
				es.execute(socketPlayer);
				id++;
				System.out.println("current clients: " + clients.size());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeSocket(Integer id) {
		clients.remove(id);
		System.out.println("closed " + id);
	}

	public void stop() {//TODO: close all clients
		try {
			clients.forEach((k,v) -> v.stop());
			System.out.println((clients.size() == 0) ? "all clients closed!"
					: "ERROR: not all clients closed!");
			server.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
