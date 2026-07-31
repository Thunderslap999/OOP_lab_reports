import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("127.0.0.1", 4444);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in)
        ) {
            System.out.println("Connected to the Calculator Server!");
            
            while (true) {
                System.out.print("Enter equation (e.g. '5 + 10') or type 'bye' to exit: ");
                String input = sc.nextLine();
                
                // Send the equation to the server
                dos.writeUTF(input);
                
                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("Closing connection.");
                    break;
                }
                
                // Wait for the server to send the answer back
                String answer = dis.readUTF();
                System.out.println("Server calculated Answer = " + answer + "\n");
            }
        } catch (Exception e) {
            System.out.println("Client Error: Is the server running?");
        }
    }
}