import java.util.ArrayList;
import java.util.List;

// Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String bogieId;
    private String bogieType;
    private int seatCapacity;

    public PassengerBogie(String bogieId, String bogieType, int seatCapacity) throws InvalidCapacityException {
        if (seatCapacity <= 0) {
            throw new InvalidCapacityException("Invalid capacity for bogie " + bogieId + ": Capacity must be greater than 0.");
        }

        this.bogieId = bogieId;
        this.bogieType = bogieType;
        this.seatCapacity = seatCapacity;
    }

    public void displayBogie() {
        System.out.println("Bogie ID      : " + bogieId);
        System.out.println("Bogie Type    : " + bogieType);
        System.out.println("Seat Capacity : " + seatCapacity);
    }
}

public class TrainConsistManagement {
    public static void main(String[] args) {
        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            bogies.add(new PassengerBogie("BG101", "Sleeper", 72));   // Valid
            bogies.add(new PassengerBogie("BG102", "AC Chair", 0));   // Invalid
            bogies.add(new PassengerBogie("BG103", "First Class", -5)); // Invalid
            bogies.add(new PassengerBogie("BG104", "Second Sitting", 90)); // Won't execute after first exception
        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        // Display only successfully added bogies
        System.out.println("\n=== VALID PASSENGER BOGIES IN TRAIN ===");
        if (bogies.isEmpty()) {
            System.out.println("No valid bogies added.");
        } else {
            for (PassengerBogie bogie : bogies) {
                bogie.displayBogie();
                System.out.println("--------------------------");
            }
        }
    }
}