import java.util.Scanner;

// Submit on beecrowd as public class Main
public class SalaryIncrease {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double salary = scanner.nextDouble();
        scanner.close();

        double percent;
        if (salary <= 400.0) {
            percent = 15;
        } else if (salary <= 800.0) {
            percent = 12;
        } else if (salary <= 1200.0) {
            percent = 10;
        } else if (salary <= 2000.0) {
            percent = 7;
        } else {
            percent = 4;
        }

        double increase = salary * (percent / 100.0);
        System.out.printf("Novo salario: %.2f%n", salary + increase);
        System.out.printf("Reajuste ganho: %.2f%n", increase);
        System.out.printf("Em percentual: %.0f %%%n", percent);
    }
}
