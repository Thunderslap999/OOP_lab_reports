import java.util.Scanner;


class MyCalculator {
    public long power(int n, int p) throws Exception {
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        } else if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }
        return (long) Math.pow(n, p);
    }
}


public class Exception_Handling {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Enter pairs of numbers (n and p). Press Ctrl+C to exit.");
        
        // This loop keeps running as long as you keep typing numbers
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();
            
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                // This catches the custom errors we threw in MyCalculator
                System.out.println(e);
            }
        }
    }
}