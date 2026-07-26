class Person {
    private final String firstName;
    private final String lastName;
    private final int idNumber;

    Person(String firstName, String lastName, int idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    void printPerson() {
        System.out.println("Name: " + lastName + ", " + firstName);
        System.out.println("ID: " + idNumber);
    }
}

class Student extends Person {
    private final int[] testScores;

    Student(String firstName, String lastName, int idNumber, int[] scores) {
        super(firstName, lastName, idNumber);
        this.testScores = scores;
    }

    char calculate() {
        int sum = 0;
        for (int score : testScores) {
            sum += score;
        }
        int average = sum / testScores.length;

        if (average >= 90) {
            return 'O';
        }
        if (average >= 80) {
            return 'E';
        }
        if (average >= 70) {
            return 'A';
        }
        if (average >= 55) {
            return 'P';
        }
        if (average >= 40) {
            return 'D';
        }
        return 'T';
    }
}

public class Inheritance3 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        String firstName = firstLine[0];
        String lastName = firstLine[1];
        int idNumber = Integer.parseInt(firstLine[2]);

        int scoreCount = scanner.nextInt();
        int[] scores = new int[scoreCount];
        for (int i = 0; i < scoreCount; i++) {
            scores[i] = scanner.nextInt();
        }
        scanner.close();

        Student student = new Student(firstName, lastName, idNumber, scores);
        student.printPerson();
        System.out.println("Grade: " + student.calculate());
    }
}
