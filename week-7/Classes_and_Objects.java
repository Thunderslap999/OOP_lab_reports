import java.util.Scanner;


class P1Student {
    private int[] scores = new int[5];

    public void input(Scanner sc) {
        for (int i = 0; i < 5; i++) {
            scores[i] = sc.nextInt();
        }
    }

    public int calculateTotalScore() {
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += scores[i];
        }
        return total;
    }
}

public class Classes_and_Objects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        P1Student[] students = new P1Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new P1Student();
            System.out.print("Enter 5 scores for student " + (i + 1) + ": ");
            students[i].input(sc);
        }
        
        int kristenScore = students[0].calculateTotalScore();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (students[i].calculateTotalScore() > kristenScore) {
                count++;
            }
        }
        System.out.println("Students scoring higher than Kristen: " + count);
        sc.close();
    }
}