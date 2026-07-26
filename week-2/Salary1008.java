import java.util.Scanner;

// Submit on beecrowd as public class Main
public class Salary1008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int hours = scanner.nextInt();
        double rate = scanner.nextDouble();
        scanner.close();

        double salary = hours * rate;
        System.out.printf("NUMBER = %d%n", number);
        System.out.printf("SALARY = U$ %.2f%n", salary);
    }
}
