import java.util.Scanner;

public class StdinAndStdout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
        scanner.close();
    }
}
