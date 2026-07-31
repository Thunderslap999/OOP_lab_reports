import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("127.0.0.1", 5000);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Connected to the server!");
            System.out.println("Server says: " + dis.readUTF());

            while (true) {
                System.out.print("Enter a message: ");
                String message = scanner.nextLine();
                dos.writeUTF(message);
                
                if (message.equalsIgnoreCase("Exit")) {
                    System.out.println("Closing connection.");
                    break;
                }
                
                String response = dis.readUTF();
                System.out.println(response);
            }
        } catch (IOException e) {
            System.out.println("Error connecting to server. Is the server running?");
        }
    }
}