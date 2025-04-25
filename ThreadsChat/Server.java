package ThreadsChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static int port = 4001;

	public static void main(String[] args) throws IOException {
		
		System.out.println("\t\t Threaded Chat Server");
		System.out.println("\t\t ============");
		
		ServerSocket serversocket = new ServerSocket(port);
		
		int current_client = 0; //id of the first client that will connect
		
		try {
			while(true) {
				Socket client = serversocket.accept();
				System.out.println("Client is connected... \n\n");
				
				ServerThreadHandler ct = new ServerThreadHandler(client, current_client); // to help with assigning client to thread
				ct.start();
				current_client++;
				

			}
		} finally {
			serversocket.close();
		}
		
	}

}