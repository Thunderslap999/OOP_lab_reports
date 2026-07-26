
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

class Singleton {
    // 1. A public String instance variable named str
    public String str;
    
    // 2. A private static instance of the class
    private static Singleton instance = new Singleton();
    
    // 3. A private constructor so no other class can instantiate it
    private Singleton() {
    }
    
    // 4. A PUBLIC static method to return the single instance
    public static Singleton getSingleInstance() {
        return instance;
    }
}
