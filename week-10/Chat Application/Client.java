import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5555)) {
            System.out.println("Connected to the Chat Server! Start typing...");
            
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage = "", serverMessage = "";

            // Loop runs until  type "stop"
            while (!clientMessage.equals("stop")) {
                // Send message to Server
                System.out.print("You (Client): ");
                clientMessage = br.readLine();
                dos.writeUTF(clientMessage);
                dos.flush();
                
                // Read reply from Server
                serverMessage = dis.readUTF();
                System.out.println("Server: " + serverMessage);
            }
            
        } catch (Exception e) {
            System.out.println("Client Error: Make sure the ChatServer is running first!");
        }
    }
}