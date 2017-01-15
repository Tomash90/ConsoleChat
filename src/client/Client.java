package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		int port = 5000;
		try {
			while (true) {
				socket = new Socket("192.168.0.102", port);
				OutputStream outToServer = socket.getOutputStream();
				DataOutputStream out = new DataOutputStream(outToServer);
				Scanner scanner = new Scanner(System.in);
				out.writeUTF("From " + socket.getLocalSocketAddress() + "\n" + scanner.nextLine());
				DataInputStream in = new DataInputStream(socket.getInputStream());
				System.out.println(in.readUTF());
			}
		} catch (IOException e) {
			System.err.println("Connection error!");
			e.printStackTrace();
		}

	}

}
