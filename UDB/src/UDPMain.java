import java.util.Scanner;

public class UDPMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose mode: ");
        System.out.println("1. Start UDP Server");
        System.out.println("2. Start UDP Client");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (choice == 1) {
            UDPServer server = new UDPServer();
            server.start();
        } else if (choice == 2) {
            UDPClient client = new UDPClient();
            client.start();
        } else {
            System.out.println("Invalid choice. Exiting...");
        }

        scanner.close();
    }
}
