import java.util.Scanner;

abstract class Book {
    String title;
    String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    abstract void display();
}


class MyBook extends Book {
    // the price variable
    int price;
    
    // constructor that takes title, author, and price
    MyBook(String title, String author, int price) {
        super(title, author); 
        this.price = price;
    }
    
    // display method 
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}


public class Abstract_class2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        scanner.close();

        //  book and display it
        Book book = new MyBook(title, author, price);
        
        System.out.println("\n--- HackerRank Output Format ---");
        book.display();
    }
}