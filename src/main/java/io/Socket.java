package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

/**
 * created on: 03.11.18
 */

public class Socket {
	private ServerSocket server;
	private java.net.Socket client;
	private PrintWriter out;
	private BufferedReader in;

	public void start() {
		try {
			server = new ServerSocket(8086);
			client = server.accept();
			out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			System.out.println(in.readLine());
			out.print("hello");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		try {
			in.close();
			out.close();
			client.close();
			server.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
