import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Multithreaded Server started. Waiting for clients...");
            
            // The server loops forever, waiting for new clients to connect
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");
                
                // When a client connects, hand them off to a new Thread so the server can keep listening
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}

// This is the Thread that handles each individual client
class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream())
        ) {
            dos.writeUTF("Welcome to the server! Type 'Exit' to close the connection.");
            
            String received;
            while (true) {
                received = dis.readUTF();
                if (received.equalsIgnoreCase("Exit")) {
                    System.out.println("Client disconnected.");
                    socket.close();
                    break;
                }
                System.out.println("Client says: " + received);
                dos.writeUTF("Server received: " + received);
            }
        } catch (IOException e) {
            System.out.println("Connection lost.");
        }
    }
}