class Flower {
    String whatsYourName() {
        return "I have many names and types.";
    }
}

class Jasmine extends Flower {
    @Override
    String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower {
    @Override
    String whatsYourName() {
        return "Lily";
    }
}

class Lotus extends Flower {
    @Override
    String whatsYourName() {
        return "Lotus";
    }
}

class Region {
    Flower yourNationalFlower() {
        return new Flower();
    }
}

class WestBenga extends Region {
    @Override
    Jasmine yourNationalFlower() {
        return new Jasmine();
    }
}

class Karnataka extends Region {
    @Override
    Lotus yourNationalFlower() {
        return new Lotus();
    }
}

class AndhraPradesh extends Region {
    @Override
    Lily yourNationalFlower() {
        return new Lily();
    }
}

public class Covariance{
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String state = scanner.nextLine().trim();
        scanner.close();

        Region region = switch (state) {
            case "WestBengal" -> new WestBenga();
            case "Karnataka" -> new Karnataka();
            case "AndhraPradesh" -> new AndhraPradesh();
            default -> null;
        };

        if (region != null) {
            System.out.println(region.yourNationalFlower().whatsYourName());
        }
    }
}
