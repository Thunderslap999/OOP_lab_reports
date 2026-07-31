import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(4444)) {
            System.out.println("Calculator Server is running. Waiting for a client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while (true) {
                // Wait for the equation from the client
                String input = dis.readUTF();
                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                System.out.println("Equation received: " + input);
                int result = 0;

                // Parse the equation (e.g., "5 + 10")
                StringTokenizer st = new StringTokenizer(input);
                int operand1 = Integer.parseInt(st.nextToken());
                String operation = st.nextToken();
                int operand2 = Integer.parseInt(st.nextToken());

                // Perform the calculation
                switch (operation) {
                    case "+": result = operand1 + operand2; break;
                    case "-": result = operand1 - operand2; break;
                    case "*": result = operand1 * operand2; break;
                    case "/": result = operand1 / operand2; break;
                    default: System.out.println("Unknown operation.");
                }

                // Send the result back to the client
                dos.writeUTF(Integer.toString(result));
            }
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}