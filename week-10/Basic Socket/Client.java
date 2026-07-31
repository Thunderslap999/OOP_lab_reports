import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        // Connects to the server on localhost (127.0.0.1) and port 5000
        try (Socket socket = new Socket("127.0.0.1", 5000);
             Scanner input = new Scanner(System.in);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
             
            System.out.println("Connected to the server!");
            System.out.println("Start typing messages. Type 'Over' to close the connection.");
            
            String line = "";
            
            // Keeps reading what you type in the terminal and sends it to the server
            while (!line.equals("Over")) {
                line = input.nextLine();
                out.writeUTF(line);
            }
            
            System.out.println("Disconnected.");
            
        } catch (IOException i) {
            System.out.println("Connection Error: Make sure you ran BasicServer.java first!");
        }
    }
}