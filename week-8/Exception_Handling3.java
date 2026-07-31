import java.util.Scanner;


class Calculator {
    public int power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n and p should be non-negative");
        }
        return (int) Math.pow(n, p);
    }
}


public class Exception_Handling3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter pairs of numbers (n and p). Press Ctrl+C to stop.");
        
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            } catch (Exception e) {
                // This problem specifically wants just the message, not the Exception name
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}