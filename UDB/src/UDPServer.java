import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    private static final int PORT = 9876;

    public void start() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(PORT);
            byte[] receiveBuffer = new byte[1024];

            System.out.println("Server is listening on port " + PORT + "...");

            while (true) {
                // Receive packet from client
                DatagramPacket packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(packet);

                String receivedMessage = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + receivedMessage);

                // Send acknowledgment back to client
                String response = "Acknowledged: " + receivedMessage;
                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                        responseData, responseData.length, packet.getAddress(), packet.getPort()
                );
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close(); // Ensure the socket is closed
                System.out.println("Socket closed.");
            }
        }
    }
}
