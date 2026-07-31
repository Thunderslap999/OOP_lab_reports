import java.util.Scanner;

abstract class Book {
    String title;
    abstract void setTitle(String s);
    
    String getTitle() {
        return title;
    }
}


class MyBook extends Book {
    
    @Override
    void setTitle(String s) {
        title = s;
    }
}


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