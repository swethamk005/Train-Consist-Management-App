import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PassengerBogie {
    private String bogieId;
    private String bogieType;
    private int seatCapacity;

    public PassengerBogie(String bogieId, String bogieType, int seatCapacity) {
        this.bogieId = bogieId;
        this.bogieType = bogieType;
        this.seatCapacity = seatCapacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    public String getBogieType() {
        return bogieType;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void displayBogie() {
        System.out.println("Bogie ID      : " + bogieId);
        System.out.println("Bogie Type    : " + bogieType);
        System.out.println("Seat Capacity : " + seatCapacity);
    }
}

public class TrainConsistManagement {
    public static void main(String[] args) {
        // Create a list of passenger bogies
        List<PassengerBogie> bogies = new ArrayList<>();

        // Add passenger bogies
        bogies.add(new PassengerBogie("BG101", "Sleeper", 72));
        bogies.add(new PassengerBogie("BG102", "AC Chair", 56));
        bogies.add(new PassengerBogie("BG103", "First Class", 24));
        bogies.add(new PassengerBogie("BG104", "Second Sitting", 90));

        // Display all bogies
        System.out.println("=== ALL PASSENGER BOGIES ===");
        displayBogies(bogies);

        // Filter bogies with seating capacity greater than or equal to 60
        List<PassengerBogie> highCapacityBogies = bogies.stream()
                .filter(bogie -> bogie.getSeatCapacity() >= 60)
                .collect(Collectors.toList());

        // Display filtered bogies
        System.out.println("\n=== FILTERED PASSENGER BOGIES (CAPACITY >= 60) ===");
        displayBogies(highCapacityBogies);
    }

    // Method to display bogie details
    public static void displayBogies(List<PassengerBogie> bogies) {
        if (bogies.isEmpty()) {
            System.out.println("No bogies found.");
            return;
        }

        for (PassengerBogie bogie : bogies) {
            bogie.displayBogie();
            System.out.println("--------------------------");
        }
    }
}