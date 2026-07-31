import java.util.Scanner;

abstract class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;
    
    Person(String firstName, String lastName, int identification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }
    
    public void printPerson() {
        System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
    }
}

class Student extends Person {
    private int[] testScores;
    
    Student(String firstName, String lastName, int identification, int[] scores) {
        super(firstName, lastName, identification);
        this.testScores = scores;
    }
    
    public char calculate() {
        int sum = 0;
        for (int score : testScores) {
            sum += score;
        }
        int avg = sum / testScores.length;
        
        if (avg >= 90 && avg <= 100) return 'O';
        if (avg >= 80 && avg < 90) return 'E';
        if (avg >= 70 && avg < 80) return 'A';
        if (avg >= 55 && avg < 70) return 'P';
        if (avg >= 40 && avg < 55) return 'D';
        return 'T';
    }
}


public class days {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first name, last name, and ID:");
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        
        System.out.println("Enter number of scores:");
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        
        System.out.println("Enter " + numScores + " scores separated by spaces:");
        for (int i = 0; i < numScores; i++) {
            testScores[i] = scan.nextInt();
        }
        scan.close();
        
        Student s = new Student(firstName, lastName, id, testScores);
        System.out.println("\n--- HackerRank Output Format ---");
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
    }
}