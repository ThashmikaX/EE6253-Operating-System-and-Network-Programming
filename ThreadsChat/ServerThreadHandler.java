package ThreadsChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThreadHandler extends Thread {
	
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private Scanner scannerInput;
	private int client_id;
	
	public ServerThreadHandler(Socket client_socket, int currentClientId) throws IOException {
		this.client = client_socket;
		this.client_id = currentClientId;
		out = new PrintWriter(client.getOutputStream(),true);
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		scannerInput = new Scanner(System.in);
	}
	
	public void run() {
		try {
			out.println("Welcome to socket chats");
			
			while(true) {
				String input = in.readLine() ;
				System.out.println("Client"+client_id+" Says: "+input);
				
				// if(input=="EXIT") {
				// 	out.println("Ending Chat");
				// 	System.out.println("Ended Chat session on Server");
				// 	break;
				// }
				
				System.out.println("Enter Reply to Client"+client_id+": ");
				String output = scannerInput.nextLine();
				out.println(output);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
	}
}