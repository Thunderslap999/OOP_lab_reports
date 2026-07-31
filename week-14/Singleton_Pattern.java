class Singleton {
    public String str;
    private static Singleton instance;
    
    private Singleton() {}
    
    static Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


public class Singleton_Pattern {
    public static void main(String[] args) {
        // Testing the singleton
        Singleton s1 = Singleton.getSingleInstance();
        s1.str = "Hello from the Singleton pattern!";
        
        Singleton s2 = Singleton.getSingleInstance();
        
        // s2 will print s1's string because they are the exact same instance!
        System.out.println(s2.str); 
    }
}