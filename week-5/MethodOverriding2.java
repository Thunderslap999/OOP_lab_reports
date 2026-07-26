class BiCycle577Week5 {
    String define_me() {
        return "a vehicle with pedals.";
    }
}

class MotorCycle577Week5 extends BiCycle577Week5 {
    @Override
    String define_me() {
        return "a cycle with an engine.";
    }

    MotorCycle577Week5() {
        System.out.println("Hello I am a motorcycle, I am " + define_me());
        String temp = super.define_me();
        System.out.println("My ancestor is a cycle who is " + temp);
    }
}

public class MethodOverriding2 {
    public static void main(String[] args) {
        new MotorCycle577Week5();
    }
}
