import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5555)) {
            System.out.println("Chat Server started. Waiting for a friend to connect...");
            Socket socket = serverSocket.accept();
            System.out.println("Friend connected! You can now chat.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage = "", serverMessage = "";

            // Loop runs until type "stop"
            while (!clientMessage.equals("stop")) {
                // Read from Client
                clientMessage = dis.readUTF();
                System.out.println("Client: " + clientMessage);
                
                // Reply to Client
                System.out.print("You (Server): ");
                serverMessage = br.readLine();
                dos.writeUTF(serverMessage);
                dos.flush();
            }
            
            System.out.println("Chat ended.");
            socket.close();
            
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}