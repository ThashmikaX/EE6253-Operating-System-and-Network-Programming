import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    private static final int SERVER_PORT = 9876;
    private static final String SERVER_ADDRESS = "localhost";

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);

            System.out.print("Enter message to send to the server: ");
            String message = scanner.nextLine();

            byte[] sendData = message.getBytes();

            // Send packet to server
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
            socket.send(packet);
            System.out.println("Message sent to server: " + message);

            // Receive response from server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Response from server: " + response);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
