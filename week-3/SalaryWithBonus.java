import java.util.Scanner;

public class SalaryWithBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        double fixedSalary = scanner.nextDouble();
        double totalSales = scanner.nextDouble();
        scanner.close();

        double total = fixedSalary + totalSales * 0.15;
        System.out.printf("TOTAL = R$ %.2f%n", total);
    }
}
