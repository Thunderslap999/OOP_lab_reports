import java.io.*;
import java.util.*;

public class Exception_Handling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers to divide (x and y):");
        
        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Result: " + (x / y));
        } catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        scanner.close();
    }
}