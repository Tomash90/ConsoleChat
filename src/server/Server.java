package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	private static ServerSocket serverSocket;

	public static void main(String[] args) {
		int port = 5000;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				DataInputStream in = new DataInputStream(socket.getInputStream());
				System.out.println(in.readUTF());
				OutputStream outToServer = socket.getOutputStream();
				DataOutputStream out = new DataOutputStream(outToServer);
				Scanner scanner = new Scanner(System.in);
				out.writeUTF("From " + socket.getLocalSocketAddress() + "\n" + scanner.nextLine());
			}
		} catch (IOException e) {
			System.err.println("Can't listen on given port");
			System.exit(1);
		}
	}
}
