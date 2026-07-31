import java.net.*;
import java.io.*;

public class Server {
    public static void main(String args[]) {
        // Starts the server on port 5000
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for a client...");

            // accept() pauses the program until a client connects
            Socket socket = server.accept();
            System.out.println("Client accepted!");

            // Takes input from the client socket
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";

            // Reads messages from the client until they type "Over"
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println("Client sent: " + line);
                } catch (IOException i) {
                    System.out.println(i);
                    break;
                }
            }
            
            System.out.println("Closing connection...");
            socket.close();
            
        } catch (IOException i) {
            System.out.println("Server Error: " + i.getMessage());
        }
    }
}