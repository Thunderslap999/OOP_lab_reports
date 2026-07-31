import java.util.Scanner;

// ==========================================
// 1. VS CODE ONLY: The dummy parent class
// ==========================================
abstract class Book {
    String title;
    abstract void setTitle(String s);
    
    String getTitle() {
        return title;
    }
}

// ==========================================
// 2. HACKERRANK SUBMISSION: Copy ONLY this part
// ==========================================
class MyBook extends Book {
    
    @Override
    void setTitle(String s) {
        title = s;
    }
}

// ==========================================
// 3. VS CODE ONLY: The Main method to run it
// ==========================================
public class Abstract_class1 {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a book title to test: ");
        String title = sc.nextLine();
        
        MyBook new_novel = new MyBook();
        new_novel.setTitle(title);
        
        System.out.println("The title is: " + new_novel.getTitle());
        sc.close();
    }
}