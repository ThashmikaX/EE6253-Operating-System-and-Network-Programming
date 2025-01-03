package ThreadsChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	static int PORT = 4001; 
	public static void main(String[] args) throws IOException {
		System.out.println("\t\t Simple Client");
		System.out.println("\t\t ===============");
		
		Scanner scannerInput = new Scanner(System.in);
		String input,output;
		
		InetAddress ipAdress = InetAddress.getLocalHost();
		
		Socket socket = new Socket(ipAdress,PORT);
		
		System.out.println("Server is connected.. \n\n");
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		try {
			while(true) {
				input = in.readLine();
				System.out.println("Server Says: "+ input);
				
				if(input == "Ending Chat") {
					System.out.println("Ended Chat session on Server");
					break;
				}
				
				System.out.println("Enter reply to Server: ");
				output = scannerInput.nextLine();
				out.println(output);
				}
			
		} finally {
			out.close();
			in.close();
			System.out.println("Closing the connection ...");
			socket.close();
			System.exit(0);
		}		
	}	
}